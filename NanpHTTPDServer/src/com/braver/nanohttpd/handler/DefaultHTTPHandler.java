/**
 * @(#) HTTPSession.java Created on 2013-9-13
 *
 *  Copyright (c) 2012 Braver. All Rights Reserved
 */
package com.braver.nanohttpd.handler;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.braver.nanohttpd.MIMEType;
import com.braver.nanohttpd.NanoHTTPD;
import com.braver.nanohttpd.Utils;
import com.braver.nanohttpd.cookie.CookieHandler;
import com.braver.nanohttpd.request.Method;
import com.braver.nanohttpd.response.Response;
import com.braver.nanohttpd.response.ResponseException;
import com.braver.nanohttpd.response.Status;
import com.braver.nanohttpd.tmp.TempFile;
import com.braver.nanohttpd.tmp.TempFileManager;

/**
 * The class <code>HTTPSession</code> Handles one session, i.e. parses the HTTP
 * request and returns the response.
 * 
 * @author Feng OuYang
 * @version 1.0
 */
public class DefaultHTTPHandler implements HTTPHandler {

	protected static final String TAG = "HTTPSession";

	public static final int BUFSIZE = 8192;
	private TempFileManager tempFileManager;
	private OutputStream outputStream;
	private InputStream inputStream;
	private int splitbyte;
	private int rlen;
	private String uri;
	private Method method;
	private Map<String, String> parms;
	private Map<String, String> headers;
	private CookieHandler cookies;

	public void execute(TempFileManager tempFileManager, InputStream inputStream,
			OutputStream outputStream) throws IOException {
		this.tempFileManager = tempFileManager;
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		try {
			// Read the first 8192 bytes.
			// The full header should fit in here.
			// Apache's default header limit is 8KB.
			// Do NOT assume that a single read will get the entire header at
			// once!
			byte[] buf = new byte[BUFSIZE];
			splitbyte = 0;
			rlen = 0;
			{
				int read = inputStream.read(buf, 0, BUFSIZE);
				if (read == -1) {
					// socket was been closed
					throw new SocketException("NanoHttpd Shutdown");
				}
				while (read > 0) {
					rlen += read;
					splitbyte = findHeaderEnd(buf, rlen);
					if (splitbyte > 0)
						break;
					read = inputStream.read(buf, rlen, BUFSIZE - rlen);
				}
			}

			if (splitbyte < rlen) {
				ByteArrayInputStream splitInputStream = new ByteArrayInputStream(buf, splitbyte,
						rlen - splitbyte);
				SequenceInputStream sequenceInputStream = new SequenceInputStream(splitInputStream,
						inputStream);
				inputStream = sequenceInputStream;
			}

			parms = new HashMap<String, String>();
			headers = new HashMap<String, String>();

			// Create a BufferedReader for parsing the header.
			BufferedReader hin = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
					buf, 0, rlen)));

			// Decode the header into parms and header java properties
			Map<String, String> pre = new HashMap<String, String>();
			decodeHeader(hin, pre, parms, headers);

			method = Method.lookup(pre.get("method"));
			if (method == null) {
				throw new ResponseException(Status.BAD_REQUEST, "BAD REQUEST: Syntax error.");
			}

			uri = pre.get("uri");

			cookies = new CookieHandler(headers);

			// Ok, now do the serve()
			Response r = serve(this);
			if (r == null) {
				throw new ResponseException(Status.INTERNAL_ERROR,
						"SERVER INTERNAL ERROR: Serve() returned a null response.");
			} else {
				cookies.unloadQueue(r);
				r.setRequestMethod(method);
				r.send(outputStream);
			}
		} catch (SocketException e) {
			// throw it out to close socket object (finalAccept)
			throw e;
		} catch (IOException ioe) {
			Response r = new Response(Status.INTERNAL_ERROR, MIMEType.PLAINTEXT,
					"SERVER INTERNAL ERROR: IOException: " + ioe.getMessage());
			r.send(outputStream);
			Utils.safeClose(outputStream);
		} catch (ResponseException re) {
			Response r = new Response(re.getStatus(), MIMEType.PLAINTEXT, re.getMessage());
			r.send(outputStream);
			Utils.safeClose(outputStream);
		} finally {
			tempFileManager.clear();
		}
	}

	protected void parseBody(Map<String, String> files) throws IOException, ResponseException {
		RandomAccessFile randomAccessFile = null;
		BufferedReader in = null;
		try {

			randomAccessFile = getTmpBucket();

			long size;
			if (headers.containsKey("content-length")) {
				size = Integer.parseInt(headers.get("content-length"));
			} else if (splitbyte < rlen) {
				size = rlen - splitbyte;
			} else {
				size = 0;
			}

			// Now read all the body and write it to f
			byte[] buf = new byte[512];
			while (rlen >= 0 && size > 0) {
				rlen = inputStream.read(buf, 0, 512);
				size -= rlen;
				if (rlen > 0) {
					randomAccessFile.write(buf, 0, rlen);
				}
			}

			// Get the raw body as a byte []
			ByteBuffer fbuf = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
					randomAccessFile.length());
			randomAccessFile.seek(0);

			// Create a BufferedReader for easily reading it as string.
			InputStream bin = new FileInputStream(randomAccessFile.getFD());
			in = new BufferedReader(new InputStreamReader(bin));

			// If the method is POST, there may be parameters
			// in data section, too, read it:
			if (Method.POST.equals(method)) {
				String contentType = "";
				String contentTypeHeader = headers.get("content-type");

				StringTokenizer st = null;
				if (contentTypeHeader != null) {
					st = new StringTokenizer(contentTypeHeader, ",; ");
					if (st.hasMoreTokens()) {
						contentType = st.nextToken();
					}
				}

				if ("multipart/form-data".equalsIgnoreCase(contentType)) {
					// Handle multipart/form-data
					if (!st.hasMoreTokens()) {
						throw new ResponseException(
								Status.BAD_REQUEST,
								"BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
					}

					String boundaryStartString = "boundary=";
					int boundaryContentStart = contentTypeHeader.indexOf(boundaryStartString)
							+ boundaryStartString.length();
					String boundary = contentTypeHeader.substring(boundaryContentStart,
							contentTypeHeader.length());
					if (boundary.startsWith("\"") && boundary.startsWith("\"")) {
						boundary = boundary.substring(1, boundary.length() - 1);
					}

					decodeMultipartData(boundary, fbuf, in, parms, files);
				} else {
					// Handle application/x-www-form-urlencoded
					String postLine = "";
					char pbuf[] = new char[512];
					int read = in.read(pbuf);
					while (read >= 0 && !postLine.endsWith("\r\n")) {
						postLine += String.valueOf(pbuf, 0, read);
						read = in.read(pbuf);
					}
					postLine = postLine.trim();
					decodeParms(postLine, parms);
				}
			} else if (Method.PUT.equals(method)) {
				files.put("content", saveTmpFile(fbuf, 0, fbuf.limit()));
			}
		} finally {
			Utils.safeClose(randomAccessFile);
			Utils.safeClose(in);
		}
	}

	/**
	 * Decodes the sent headers and loads the data into Key/value pairs
	 */
	private void decodeHeader(BufferedReader in, Map<String, String> pre,
			Map<String, String> parms, Map<String, String> headers) throws ResponseException {
		try {
			// Read the request line
			String inLine = in.readLine();
			if (inLine == null) {
				return;
			}

			StringTokenizer st = new StringTokenizer(inLine);
			if (!st.hasMoreTokens()) {
				throw new ResponseException(Status.BAD_REQUEST,
						"BAD REQUEST: Syntax error. Usage: GET /example/file.html");
			}

			pre.put("method", st.nextToken());

			if (!st.hasMoreTokens()) {
				throw new ResponseException(Status.BAD_REQUEST,
						"BAD REQUEST: Missing URI. Usage: GET /example/file.html");
			}

			String uri = st.nextToken();

			// Decode parameters from the URI
			int qmi = uri.indexOf('?');
			if (qmi >= 0) {
				decodeParms(uri.substring(qmi + 1), parms);
				uri = Utils.decodePercent(uri.substring(0, qmi));
			} else {
				uri = Utils.decodePercent(uri);
			}

			// If there's another token, it's protocol version,
			// followed by HTTP headers. Ignore version but parse headers.
			// NOTE: this now forces header names lowercase since they are
			// case insensitive and vary by client.
			if (st.hasMoreTokens()) {
				String line = in.readLine();
				while (line != null && line.trim().length() > 0) {
					int p = line.indexOf(':');
					if (p >= 0)
						headers.put(line.substring(0, p).trim().toLowerCase(), line
								.substring(p + 1).trim());
					line = in.readLine();
				}
			}

			pre.put("uri", uri);
		} catch (IOException ioe) {
			throw new ResponseException(Status.INTERNAL_ERROR,
					"SERVER INTERNAL ERROR: IOException: " + ioe.getMessage(), ioe);
		}
	}

	/**
	 * Decodes the Multipart Body data and put it into Key/Value pairs.
	 */
	private void decodeMultipartData(String boundary, ByteBuffer fbuf, BufferedReader in,
			Map<String, String> parms, Map<String, String> files) throws ResponseException {
		try {
			int[] bpositions = getBoundaryPositions(fbuf, boundary.getBytes());
			int boundarycount = 1;
			String mpline = in.readLine();
			while (mpline != null) {
				if (!mpline.contains(boundary)) {
					throw new ResponseException(
							Status.BAD_REQUEST,
							"BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
				}
				boundarycount++;
				Map<String, String> item = new HashMap<String, String>();
				mpline = in.readLine();
				while (mpline != null && mpline.trim().length() > 0) {
					int p = mpline.indexOf(':');
					if (p != -1) {
						item.put(mpline.substring(0, p).trim().toLowerCase(),
								mpline.substring(p + 1).trim());
					}
					mpline = in.readLine();
				}
				if (mpline != null) {
					String contentDisposition = item.get("content-disposition");
					if (contentDisposition == null) {
						throw new ResponseException(
								Status.BAD_REQUEST,
								"BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
					}
					StringTokenizer st = new StringTokenizer(contentDisposition, "; ");
					Map<String, String> disposition = new HashMap<String, String>();
					while (st.hasMoreTokens()) {
						String token = st.nextToken();
						int p = token.indexOf('=');
						if (p != -1) {
							disposition.put(token.substring(0, p).trim().toLowerCase(), token
									.substring(p + 1).trim());
						}
					}
					String pname = disposition.get("name");
					pname = pname.substring(1, pname.length() - 1);

					String value = "";
					if (item.get("content-type") == null) {
						while (mpline != null && !mpline.contains(boundary)) {
							mpline = in.readLine();
							if (mpline != null) {
								int d = mpline.indexOf(boundary);
								if (d == -1) {
									value += mpline;
								} else {
									value += mpline.substring(0, d - 2);
								}
							}
						}
					} else {
						if (boundarycount > bpositions.length) {
							throw new ResponseException(Status.INTERNAL_ERROR,
									"Error processing request");
						}
						int offset = stripMultipartHeaders(fbuf, bpositions[boundarycount - 2]);
						String path = saveTmpFile(fbuf, offset, bpositions[boundarycount - 1]
								- offset - 4);
						files.put(pname, path);
						value = disposition.get("filename");
						value = value.substring(1, value.length() - 1);
						do {
							mpline = in.readLine();
						} while (mpline != null && !mpline.contains(boundary));
					}
					parms.put(pname, value);
				}
			}
		} catch (IOException ioe) {
			throw new ResponseException(Status.INTERNAL_ERROR,
					"SERVER INTERNAL ERROR: IOException: " + ioe.getMessage(), ioe);
		}
	}

	/**
	 * Find byte index separating header from body. It must be the last byte of
	 * the first two sequential new lines.
	 */
	private int findHeaderEnd(final byte[] buf, int rlen) {
		int splitbyte = 0;
		while (splitbyte + 3 < rlen) {
			if (buf[splitbyte] == '\r' && buf[splitbyte + 1] == '\n' && buf[splitbyte + 2] == '\r'
					&& buf[splitbyte + 3] == '\n') {
				return splitbyte + 4;
			}
			splitbyte++;
		}
		return 0;
	}

	/**
	 * Find the byte positions where multipart boundaries start.
	 */
	private int[] getBoundaryPositions(ByteBuffer b, byte[] boundary) {
		int matchcount = 0;
		int matchbyte = -1;
		List<Integer> matchbytes = new ArrayList<Integer>();
		for (int i = 0; i < b.limit(); i++) {
			if (b.get(i) == boundary[matchcount]) {
				if (matchcount == 0)
					matchbyte = i;
				matchcount++;
				if (matchcount == boundary.length) {
					matchbytes.add(matchbyte);
					matchcount = 0;
					matchbyte = -1;
				}
			} else {
				i -= matchcount;
				matchcount = 0;
				matchbyte = -1;
			}
		}
		int[] ret = new int[matchbytes.size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = matchbytes.get(i);
		}
		return ret;
	}

	/**
	 * Retrieves the content of a sent file and saves it to a temporary file.
	 * The full path to the saved file is returned.
	 */
	private String saveTmpFile(ByteBuffer b, int offset, int len) {
		String path = "";
		if (len > 0) {
			FileOutputStream fileOutputStream = null;
			try {
				TempFile tempFile = tempFileManager.createTempFile();
				ByteBuffer src = b.duplicate();
				fileOutputStream = new FileOutputStream(tempFile.getName());
				FileChannel dest = fileOutputStream.getChannel();
				src.position(offset).limit(offset + len);
				dest.write(src.slice());
				path = tempFile.getName();
			} catch (Exception e) { // Catch exception if any
				System.err.println("Error: " + e.getMessage());
			} finally {
				Utils.safeClose(fileOutputStream);
			}
		}
		return path;
	}

	private RandomAccessFile getTmpBucket() {
		try {
			TempFile tempFile = tempFileManager.createTempFile();
			return new RandomAccessFile(tempFile.getName(), "rw");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}

	/**
	 * It returns the offset separating multipart file headers from the file's
	 * data.
	 */
	private int stripMultipartHeaders(ByteBuffer b, int offset) {
		int i;
		for (i = offset; i < b.limit(); i++) {
			if (b.get(i) == '\r' && b.get(++i) == '\n' && b.get(++i) == '\r' && b.get(++i) == '\n') {
				break;
			}
		}
		return i + 1;
	}

	/**
	 * Override this to customize the server.
	 * <p/>
	 * <p/>
	 * (By default, this delegates to serveFile() and allows directory listing.)
	 * 
	 * @param uri
	 *            Percent-decoded URI without parameters, for example
	 *            "/index.cgi"
	 * @param method
	 *            "GET", "POST" etc.
	 * @param parms
	 *            Parsed, percent decoded parameters from URI and, in case of
	 *            POST, data.
	 * @param headers
	 *            Header entries, percent decoded
	 * @return HTTP response, see class Response for details
	 */
	@Deprecated
	public Response serve(String uri, Method method, Map<String, String> headers,
			Map<String, String> parms, Map<String, String> files) {
		return new Response(Status.NOT_FOUND, MIMEType.PLAINTEXT, "Not Found");
	}

	/**
	 * Override this to customize the server.
	 * <p/>
	 * <p/>
	 * (By default, this delegates to serveFile() and allows directory listing.)
	 * 
	 * @param session
	 *            The HTTP session
	 * @return HTTP response, see class Response for details
	 */
	public Response serve(DefaultHTTPHandler session) {
		Map<String, String> files = new HashMap<String, String>();
		Method method = session.getMethod();
		if (Method.PUT.equals(method) || Method.POST.equals(method)) {
			try {
				session.parseBody(files);
			} catch (IOException ioe) {
				return new Response(Status.INTERNAL_ERROR, MIMEType.PLAINTEXT,
						"SERVER INTERNAL ERROR: IOException: " + ioe.getMessage());
			} catch (ResponseException re) {
				return new Response(re.getStatus(), MIMEType.PLAINTEXT, re.getMessage());
			}
		}

		return serve(session.getUri(), method, session.getHeaders(), session.getParms(), files);
	}

	/**
	 * Decodes parameters in percent-encoded URI-format ( e.g.
	 * "name=Jack%20Daniels&pass=Single%20Malt" ) and adds them to given Map.
	 * NOTE: this doesn't support multiple identical keys due to the simplicity
	 * of Map.
	 */
	private void decodeParms(String parms, Map<String, String> p) {
		if (parms == null) {
			p.put(NanoHTTPD.QUERY_STRING_PARAMETER, "");
			return;
		}

		p.put(NanoHTTPD.QUERY_STRING_PARAMETER, parms);
		StringTokenizer st = new StringTokenizer(parms, "&");
		while (st.hasMoreTokens()) {
			String e = st.nextToken();
			int sep = e.indexOf('=');
			if (sep >= 0) {
				p.put(Utils.decodePercent(e.substring(0, sep)).trim(),
						Utils.decodePercent(e.substring(sep + 1)));
			} else {
				p.put(Utils.decodePercent(e).trim(), "");
			}
		}
	}

	public final Map<String, String> getParms() {
		return parms;
	}

	public final Map<String, String> getHeaders() {
		return headers;
	}

	public final String getUri() {
		return uri;
	}

	public final Method getMethod() {
		return method;
	}

	public final InputStream getInputStream() {
		return inputStream;
	}

	public CookieHandler getCookies() {
		return cookies;
	}

}
