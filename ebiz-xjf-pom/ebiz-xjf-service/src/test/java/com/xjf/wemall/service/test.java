package com.xjf.wemall.service;

import java.net.URLEncoder;

import org.apache.commons.lang3.CharEncoding;

public class test {

	public static void main(String[] args) {
//		System.out.println(String.valueOf(null));
		String badStr = "";
		badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|chr|mid|master|truncate|"
				+ "char|declare|sitename|net user|xp_cmdshell|or |like'|create|"
				+ "table|from|grant|use|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|order|by|" + "--|+|like|#";// 过滤掉的sql关键字，可以手动添加
		System.out.println(badStr);
		
		Animal a = new Cat();
		Animal b = new Animal();
		Cat c = new Cat();
		((Animal) a).animal();//animal
		a.shout();//cat
		b.shout();//Animal
		
		// default类 修改类变量
		Cat cat = new Cat();
		System.out.println(Cat.age);//10 
		
		Cat cat2 = new Cat("99");
		System.out.println(Cat.age);//99
				
		// 重写toString
		System.out.println(c.toString());
		System.out.println(a.toString());
		
		// 装箱拆箱
		Integer intObj = 5; // 装箱
		int intNotObj = intObj; // 拆箱
		
		Object booleanObj = true; // 装箱
		if (booleanObj instanceof Boolean) {
			boolean bool = (Boolean) booleanObj;// 拆箱
			boolean boo2 = (boolean) booleanObj;// 拆箱
			System.out.println(bool);
			System.out.println(boo2);
		}
		try {

			System.out.println(URLEncoder.encode(" ", CharEncoding.UTF_8));
		} catch (Exception e) {
			
			
		}
		
	}

}
