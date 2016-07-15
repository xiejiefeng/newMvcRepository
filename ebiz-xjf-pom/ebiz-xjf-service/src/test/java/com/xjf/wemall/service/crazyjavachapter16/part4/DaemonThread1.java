package com.xjf.wemall.service.crazyjavachapter16.part4;
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
public class DaemonThread1 extends Thread
{
	// 定义后台线程的线程执行体与普通线程没有任何区别
	public void run()
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println(getName() + "  " + i);
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{
		
		for (int i = 0 ; i < 10 ; i++ )
		{
			System.out.println(Thread.currentThread().getName()
				+ "  " + i);
			if (i == 2) {
				DaemonThread1 t = new DaemonThread1();
				// 启动后台线程
				t.start();
			}
		}
	}
}
