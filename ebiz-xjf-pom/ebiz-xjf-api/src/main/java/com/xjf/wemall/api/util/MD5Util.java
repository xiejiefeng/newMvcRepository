/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: MD5Util.java
 * Author:   xiejuan
 * Date:     2014年8月19日 上午11:29:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.security.MessageDigest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author xiejuan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */

public final class MD5Util
{
  private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

  public static String encodeFile(File file)
  {
    FileInputStream in = null;
    MessageDigest md5 = null;
    try {
      in = new FileInputStream(file);
      FileChannel ch = in.getChannel();
      MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
      md5 = MessageDigest.getInstance("MD5");
      md5.update(byteBuffer);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        in.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return toHex(md5.digest());
  }

  public static String encodeString(String arg)
  {
    if (arg == null) {
      arg = "";
    }
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
      md5.update(arg.getBytes("UTF-8"));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return toHex(md5.digest());
  }

  private static String toHex(byte[] bytes) {
    StringBuffer str = new StringBuffer(32);
    for (byte b : bytes) {
      str.append(hexDigits[((b & 0xF0) >> 4)]);
      str.append(hexDigits[(b & 0xF)]);
    }
    return str.toString();
  }

  public static void main(String[] args) {
    System.out.println(encodeString("abcd"));
  }
}
