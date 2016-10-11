package com.xjf.wemall.service.threadTest.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionException;

public class threadPool2 {

	static int coreNum = 2;
	static int MaxNum = 4;
	static int queueNum = 4;
	
	static LinkedBlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>();
	static ThreadPoolExecutor executor = new ThreadPoolExecutor(coreNum, MaxNum, 200,
			TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(queueNum));
	// 核心池满了，往阻塞队列里面塞，阻塞队列满了，如果小于线程池最大数，则直接执行。
	// 如果大于，拒绝执行
	public static void main(String[] args) throws InterruptedException {
		threadPool2 poolThread = new threadPool2();
		
		// 阻塞队列线程池监控
		QueueTask queueTask = poolThread.new QueueTask();
		queueTask.start();
		
		// 线程池执行
		for (int i = 0; i < 10; i++) {
			MyTask myTask = poolThread.new MyTask(i);
			try {
				executor.execute(myTask);
			} catch (RejectedExecutionException e) {
				System.out.println("task " + i + "的线程池已满，被拒绝，并被塞入阻塞队列");
				// 往阻塞队列里面塞
				blockQueue.put(myTask);
				
			} catch (Exception e) {
				System.out.println("未知错误");
			}
			System.out.println("线程池中线程数目：" + executor.getPoolSize()
					+ "，队列中等待执行的任务数目：" + executor.getQueue().size()
					+ "，已执行完别的任务数目：" + executor.getCompletedTaskCount());
		}
		// executor.shutdown();
	}

	// 线程池线程
	class MyTask implements Runnable {
		private int taskNum;

		public MyTask(int num) {
			this.taskNum = num;
		}

		public int getTask() {
			return taskNum;
		}

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			System.out.println("正在执行task " + taskNum);
			try {
				Thread.currentThread().sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("task " + taskNum + "执行完毕");
		}
	}
	
	// 阻塞队列
	class QueueTask extends Thread {
		@SuppressWarnings("static-access")
		@Override
		public void run() {
			while(true) {
				// 取走第一个，阻塞队列会自动wait
				MyTask queueTask;
				try {
					queueTask = (MyTask) blockQueue.take();
					System.out.println("取出task " + queueTask.getTask() + "    线程中队列为" +executor.getQueue().size());
					
					// 阻塞队列，如果在这里，应该线程最大已经用满，判断线程池线程队列是否为满
					while(executor.getQueue().size() == queueNum) {
						System.out.println("取出task " + queueTask.getTask() + "等待");
						// 满了就等待
						Thread.currentThread().sleep(1000);
					}
					
					executor.execute(queueTask);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
