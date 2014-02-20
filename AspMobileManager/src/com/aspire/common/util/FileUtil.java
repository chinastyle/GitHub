/**
 * @(#) FileUtil.java Created on 2012-8-15
 *
 * Copyright (c) 2012 Aspire. All Rights Reserved
 */
package com.aspire.common.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class <code>FileUtil</code>
 *
 * @author likai
 * @version 1.0
 */
public class FileUtil {

    protected static Logger logger = LoggerFactory.getLogger(FileUtil.class);
    /**
     * 删除目录下的所有文件，及该目录
     * @param file 目录文件
     */
    public static void deleteFile(File file) {
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            } else if (file.isDirectory()) { // 否则如果它是一个目录
                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                    deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                }
            }
            file.delete();
        } else {
            logger.error("所删除的文件不存在！ 文件名为" + file.getName());
        }
    }
}
