package com.xjf.wemall.service.threadTest;


import java.util.ArrayList;
import java.util.concurrent.*;
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

public class ThirdThread
{
	public static void main(String[] args)
	{
		// 使用FutureTask来包装Callable对象
		FutureTask<String> task = new FutureTask<>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						int i = 0;
						for ( ; i < 100 ; i++ )
						{
							System.out.println(Thread.currentThread().getName()
								+ " 的循环变量i的值：" + i);
							if (i == 99)
							{
								throw new Exception();
							}
						}
						// call()方法可以有返回值
						return String.valueOf(i);
					};
				}
		);
		
		// 实质还是以Callable对象来创建、并启动线程
		new Thread(task , "有返回值的线程").start();
		try
		{
			// 获取线程返回值
			System.out.println("子线程的返回值：" + task.get() + "  " + task.get().getClass());
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
