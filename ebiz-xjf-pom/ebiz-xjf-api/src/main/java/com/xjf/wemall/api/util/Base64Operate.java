package com.xjf.wemall.api.util;

import org.apache.commons.lang3.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * Base64加密/解密
 * 
 * @version 1.0.0
 */
@SuppressWarnings("restriction")
public class Base64Operate {
	/**
	 * base64加密
	 * 
	 * @param String
	 *            str
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String toBASE64(String str) {
		if (StringUtils.isEmpty(str))
			return null;
		return (new sun.misc.BASE64Encoder()).encode(java.net.URLEncoder
				.encode(str).getBytes());
	}

	/**
	 * base64解密
	 * 
	 * @param String
	 *            str
	 * @return String
	 */
	@SuppressWarnings("deprecation")
	public static String fromBASE64(String str) {
		if (StringUtils.isEmpty(str))
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(str);
			return java.net.URLDecoder.decode(new String(b));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 测试函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		String s = 
		"{\"cityName\":\"南京\",\"sourceType\":\"1\",\"userId\":\"10002500\"}";
		
		String str = toBASE64(s);
		System.out.println("stringtoBASE64 ->  " + str);
//		System.out.println("stringfromBASE64 -> " + getFromBASE64(str));
	}
}
