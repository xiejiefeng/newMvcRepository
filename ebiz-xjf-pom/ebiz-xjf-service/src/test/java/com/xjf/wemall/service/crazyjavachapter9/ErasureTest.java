package com.xjf.wemall.service.crazyjavachapter9;


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
class Apple1<T extends Number>
{
	T size;
	public Apple1()
	{
	}
	public Apple1(T size)
	{
		this.size = size;
	}
	public void setSize(T size)
	{
		this.size = size;
	}
	public T getSize()
	{
		return this.size;
	}
}
public class ErasureTest
{
	public static void main(String[] args)
	{
		Apple1<Integer> a = new Apple1<>(6);    // ①
		// a的getSize方法返回Integer对象
		Integer as = a.getSize();
		// 把a对象赋给Apple变量，丢失尖括号里的类型信息
		Apple1 b = a;      // ②
		// b只知道size的类型是Number
		Number size1 = b.getSize();
		// 下面代码引起编译错误
//		Integer size2 = b.getSize();  // ③
	}
}

