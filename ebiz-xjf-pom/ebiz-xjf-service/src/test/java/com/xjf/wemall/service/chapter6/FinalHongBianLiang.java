package com.xjf.wemall.service.chapter6;

// 宏变量
public class FinalHongBianLiang {

	public static void main(String[] args) {
		String s1 = "疯狂JAVA";
		String s2 = "疯狂"+"JAVA";
		System.out.println(s1 == s2);// true
		
		String str1 = "疯狂";
		String str2 = "JAVA";
		String s3 = str1 + str2;
		// false/两个字符串链接，编译时不能确定，所以新开对象
		System.out.println(s1 == s3);
		
		final String str3 = "疯狂";
		final String str4 = "JAVA";
		String s4 = str3 + str4;
		// true/两个宏变量链接，编译时可以确定值，所以可以使用字符串常量池
		System.out.println(s1 == s4);
	}

}
