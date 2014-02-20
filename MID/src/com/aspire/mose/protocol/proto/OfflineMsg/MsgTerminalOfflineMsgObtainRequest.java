// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: protoc/TerminalOfflineMsgObtainRequest.proto

package com.aspire.mose.protocol.proto.OfflineMsg;

public final class MsgTerminalOfflineMsgObtainRequest {
  private MsgTerminalOfflineMsgObtainRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  public interface TerminalOfflineMsgObtainRequestOrBuilder
      extends com.google.protobuf.MessageLiteOrBuilder {
    
    // required string deviceID = 1;
    boolean hasDeviceID();
    String getDeviceID();
  }
  public static final class TerminalOfflineMsgObtainRequest extends
      com.google.protobuf.GeneratedMessageLite
      implements TerminalOfflineMsgObtainRequestOrBuilder {
    // Use TerminalOfflineMsgObtainRequest.newBuilder() to construct.
    private TerminalOfflineMsgObtainRequest(Builder builder) {
      super(builder);
    }
    private TerminalOfflineMsgObtainRequest(boolean noInit) {}
    
    private static final TerminalOfflineMsgObtainRequest defaultInstance;
    public static TerminalOfflineMsgObtainRequest getDefaultInstance() {
      return defaultInstance;
    }
    
    public TerminalOfflineMsgObtainRequest getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    private int bitField0_;
    // required string deviceID = 1;
    public static final int DEVICEID_FIELD_NUMBER = 1;
    private java.lang.Object deviceID_;
    public boolean hasDeviceID() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public String getDeviceID() {
      java.lang.Object ref = deviceID_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (com.google.protobuf.Internal.isValidUtf8(bs)) {
          deviceID_ = s;
        }
        return s;
      }
    }
    private com.google.protobuf.ByteString getDeviceIDBytes() {
      java.lang.Object ref = deviceID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8((String) ref);
        deviceID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    
    private void initFields() {
      deviceID_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasDeviceID()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, getDeviceIDBytes());
      }
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, getDeviceIDBytes());
      }
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageLite.Builder<
        com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest, Builder>
        implements com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequestOrBuilder {
      // Construct using com.aspire.mose.protocol.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private void maybeForceBuilderInitialization() {
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        deviceID_ = "";
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest getDefaultInstanceForType() {
        return com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest.getDefaultInstance();
      }
      
      public com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest build() {
    	  com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
    	  com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest buildPartial() {
    	  com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest result = new com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.deviceID_ = deviceID_;
        result.bitField0_ = to_bitField0_;
        return result;
      }
      
      public Builder mergeFrom(com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest other) {
        if (other == com.aspire.mose.protocol.proto.OfflineMsg.MsgTerminalOfflineMsgObtainRequest.TerminalOfflineMsgObtainRequest.getDefaultInstance()) return this;
        if (other.hasDeviceID()) {
          setDeviceID(other.getDeviceID());
        }
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasDeviceID()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              
              return this;
            default: {
              if (!parseUnknownField(input, extensionRegistry, tag)) {
                
                return this;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              deviceID_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required string deviceID = 1;
      private java.lang.Object deviceID_ = "";
      public boolean hasDeviceID() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public String getDeviceID() {
        java.lang.Object ref = deviceID_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref).toStringUtf8();
          deviceID_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      public Builder setDeviceID(String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        deviceID_ = value;
        
        return this;
      }
      public Builder clearDeviceID() {
        bitField0_ = (bitField0_ & ~0x00000001);
        deviceID_ = getDefaultInstance().getDeviceID();
        
        return this;
      }
      void setDeviceID(com.google.protobuf.ByteString value) {
        bitField0_ |= 0x00000001;
        deviceID_ = value;
        
      }
      
      // @@protoc_insertion_point(builder_scope:protocol.TerminalOfflineMsgObtainRequest)
    }
    
    static {
      defaultInstance = new TerminalOfflineMsgObtainRequest(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:protocol.TerminalOfflineMsgObtainRequest)
  }
  
  
  static {
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}
