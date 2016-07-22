package com.xjf.wemall.service.crazyjavachapter18.part6;

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
public class CrazyitObjectFactory
{
	public static Object getInstance(String clsName)
	{
		try
		{
			// 创建指定类对应的Class对象
			Class cls = Class.forName(clsName);
			// 返回使用该Class对象所创建的实例
			return cls.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
}