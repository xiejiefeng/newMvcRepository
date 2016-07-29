package com.xjf.wemall.service.threadTest;

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
public class ThreadYield extends Thread
{
//	public ThreadYield(String name)
//	{
//		super(name);
//	}
	// 定义run方法作为线程执行体
	public void run()
	{
		for (int i = 0; i < 50 ; i++ )
		{
			System.out.println(getName() + "  " + i);
			// 当i等于20时，使用yield方法让当前线程让步
			if (i == 2)
			{
				Thread.yield();
			}
		}
	}
	public static void main(String[] args)throws Exception
	{
		// 调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。
		// 它跟sleep方法类似，同样不会释放锁。
		// 但是yield不能控制具体的交出CPU的时间，
		// 另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。
		// 调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，
		// 它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的
		
		// 启动两条并发线程
		ThreadYield yt1 = new ThreadYield();
		yt1.setName("高级1");
		// 将ty1线程设置成最高优先级
		yt1.setPriority(Thread.MAX_PRIORITY);
		yt1.start();
		ThreadYield yt2 = new ThreadYield();
		yt2.setName("高级2");
		// 将yt2线程设置成最低优先级
//		yt2.setPriority(Thread.MIN_PRIORITY);
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
	}
}