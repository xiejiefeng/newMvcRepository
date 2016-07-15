package com.xjf.wemall.service.crazyjavachapter16.part6;

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
class Producer extends Thread
{
	private BlockingQueue<String> bq;
	public Producer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		String[] strArr = new String[]
		{
			//"Java",
			//"Struts",
			"Spring"
		};
		for (int i = 0 ; i < 999999999 ; i++ )
		{
			System.out.println(getName() + "准备生产集合元素！");
			try
			{
				Thread.sleep(600);
				// 尝试放入元素，如果队列已满，线程被阻塞
				//bq.put(strArr[i % 3]);
				bq.put(strArr[0]);
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
			System.out.println(getName() + "生产完成：" + bq);
		}
	}
}
class Consumer extends Thread
{
	private BlockingQueue<String> bq;
	public Consumer(BlockingQueue<String> bq)
	{
		this.bq = bq;
	}
	public void run()
	{
		while(true)
		{
			String pro = "";
			System.out.println(getName() + "准备消费集合元素！");
			try
			{
				Thread.sleep(600);
				// 尝试取出元素，如果队列已空，线程被阻塞
				pro = bq.take();
			}
			catch (Exception ex){
				ex.printStackTrace();
			}
//			System.out.println(getName() + "消费完成：" + bq);
			System.out.println(getName() + "消费完成：" + pro);
		}
	}
}
public class BlockingQueueTest2
{
	public static void main(String[] args)
	{
		// 创建一个容量为1的BlockingQueue
		BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
		// 启动3条生产者线程
		Thread pro1 = new Producer(bq);
		pro1.setName("生产者1");
		Thread pro2 = new Producer(bq);
		pro2.setName("生产者2");
		Thread pro3 = new Producer(bq);
		pro3.setName("生产者3");
		// 启动一条消费者线程
		Thread cust = new Consumer(bq);
		cust.setName("消费者");
		
		pro1.start();
		pro2.start();
		pro3.start();
		cust.start();
	}
}