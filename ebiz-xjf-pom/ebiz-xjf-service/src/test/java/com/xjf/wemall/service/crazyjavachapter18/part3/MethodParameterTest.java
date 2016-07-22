package com.xjf.wemall.service.crazyjavachapter18.part3;
import java.lang.reflect.*;
import java.util.*;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
class Test
{
	public void replace(String str, List<String> list){}
}
public class MethodParameterTest
{
	
	public static double pow2(double a, double n) {
		if (a == 1) {
			return 0;
		} else if (Math.pow(2, n) >= a){
			return n;
		}
		return pow2(a, n+1);
	}
	public static double pow3(double a) {
		return Math.log(a)/Math.log(2);
	}
	
	public static void main(String[] args)throws Exception
	{
		// 获取String的类
		Class<Test> clazz = Test.class;
		// 获取String类的带两个参数的replace()方法
		Method replace = clazz.getMethod("replace"
			, String.class, List.class);
		Class<?>[] test = replace.getParameterTypes();
		for (Class t : test) {
			// java.lang.String
			// java.util.List
			System.out.println(t.getName());
		}
		
		double[] a = {66,2,4,8,16,32,64};
		
		for (double b : a) {
			//System.out.println(pow2(b, 0));
			System.out.println(pow3(b));
			
			
		}
		
		// 获取指定方法的参数个数
//		System.out.println("replace方法参数个数：" + replace.getParameterCount());
//		// 获取replace的所有参数信息
//		Parameter[] parameters = replace.getParameters();
//		int index = 1;
//		// 遍历所有参数
//		for (Parameter p : parameters)
//		{
//			if (p.isNamePresent())
//			{
//				System.out.println("---第" + index++ + "个参数信息---");
//				System.out.println("参数名：" + p.getName());
//				System.out.println("形参类型：" + p.getType());
//				System.out.println("泛型类型：" + p.getParameterizedType());
//			}
//		}
	}
}