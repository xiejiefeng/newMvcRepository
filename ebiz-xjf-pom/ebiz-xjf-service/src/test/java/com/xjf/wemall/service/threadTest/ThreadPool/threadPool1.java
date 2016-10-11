package com.xjf.wemall.service.threadTest.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionException;

public class threadPool1 {

	//public static LinkedBlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>();
	// 核心池满了，往阻塞队列里面塞，阻塞队列满了，如果小于线程池最大数，则直接执行。
	// 如果大于，拒绝执行
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		threadPool1 poolThread = new threadPool1();
		// for (int i = 0; i < 15; i++) {
		for (int i = 0; i < 20; i++) {
			MyTask myTask = poolThread.new MyTask(i);
			try {
				executor.execute(myTask);
			} catch (RejectedExecutionException e) {
				System.out.println(i + "的线程池已满，被拒绝");
				// 被拒绝后，开线程继续执行，但是此时，executor.shutdown();不能被执行
				MyPoolTask reTask = poolThread.new MyPoolTask(executor, myTask);
				Thread reThread = new Thread(reTask);
				reThread.start();
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

	// 被拒绝后,执行线程池线程
	class MyPoolTask implements Runnable {
		ThreadPoolExecutor executor;
		MyTask task;

		public MyPoolTask(ThreadPoolExecutor executor, MyTask task) {
			this.executor = executor;
			this.task = task;
		}

		@SuppressWarnings("static-access")
		@Override
		public void run() {
			System.out.println("重新正在执行task " + task.getTask());
			try {
				executor.execute(task);
			} catch (RejectedExecutionException e) {
				System.out.println(task.getTask() + "的线程池已满，被拒绝");
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// 再次执行
				run();
			}
		}
	}
}
