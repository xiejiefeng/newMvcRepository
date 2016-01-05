/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: StringUtil.java
 * Author:   baowenzhou
 * Date:     2014-12-26 上午10:52:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.util.Random;

/**
 * 字符串工具类<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StringUtil {

	/** 随机字母 */
	public static final String RANDOM_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/** 随机数字 */
	public static final String RANDOM_NUMBER = "0123456789";

	/** 随机字母+数字 */
	public static final String RANDOM_ALL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	/**
	 * 生成随机码
	 * 
	 * @return 随机码
	 */
	public static String getRandomString(int length) {
		return getRandomString(length, RANDOM_ALL);
	}

	/**
	 * 生成随机码
	 * 
	 * @return 随机码
	 */
	public static String getRandomString(int length, String base) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
	
	/***
     * 
     * 功能描述:过滤存在的乱码 <br>
     * 〈功能详细描述〉
     *
     * @param str
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public static String dofilter(String str){
		String str_Result = "", str_OneStr = "";  
		for (int z = 0; z < str.length(); z++) {  
		   str_OneStr = str.substring(z, z + 1);  
		     if (str_OneStr.matches("[\u4e00-\u9fa5]+")||str_OneStr.matches("[\\x00-\\x7F]+")) 
		     {  
		       str_Result = str_Result + str_OneStr;    
		     }  
		}
		return str_Result;
	}
}
