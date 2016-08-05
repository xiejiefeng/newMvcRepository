package com.xjf.wemall.service.threadTest;

import java.io.IOException;

public class ThreadInterrupt {

	// interrupt，顾名思义，即中断的意思。单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常，
	// 也就说，它可以用来中断一个正处于阻塞状态的线程；
	// 另外，通过interrupt方法和isInterrupted()方法来停止正在运行的线程。
	public static void main(String[] args) throws IOException {

//		 // interrupt1
//		 ThreadInterrupt test = new ThreadInterrupt();
//		 MyThread1 thread = test.new MyThread1();
//		 thread.start();
//		 try {
//			 Thread.currentThread().sleep(2000);
//		 } catch (InterruptedException e) {
//		
//		 }
//		 thread.interrupt();

		 // interrupt2 中断运行中的线程
		 // 运行该程序会发现，while循环会一直运行直到变量i的值超出Integer.MAX_VALUE。
		 // 所以说直接调用interrupt方法不能中断正在运行中的线程。
//		 ThreadInterrupt test = new ThreadInterrupt();
//		 MyThread2 thread = test.new MyThread2();
//		 thread.start();
//		 try {
//		 Thread.currentThread().sleep(2000);
//		 } catch (InterruptedException e) {
//		
//		 }
//		 thread.interrupt();

		 ThreadInterrupt test = new ThreadInterrupt();
		 MyThread3 thread = test.new MyThread3();
		 thread.start();
		 try {
			 Thread.currentThread().sleep(1000);
		 } catch (InterruptedException e) {
		
		 }
		 thread.interrupt();

//		ThreadInterrupt test = new ThreadInterrupt();
//		MyThread4 thread = test.new MyThread4();
//		thread.start();
//		try {
//			Thread.currentThread().sleep(2000);
//		} catch (InterruptedException e) {
//
//		}
//		thread.setStop(true);
	}

	class MyThread1 extends Thread {
		@Override
		public void run() {
			try {
				System.out.println("进入睡眠状态");
				Thread.currentThread().sleep(10000);
				System.out.println("睡眠完毕");
			} catch (InterruptedException e) {
				System.out.println("得到中断异常");
			}
			System.out.println("run方法执行完毕");
		}
	}

	class MyThread2 extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (i < Integer.MAX_VALUE) {
				System.out.println(i + " while循环");
				i++;
			}
		}
	}

	class MyThread3 extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (!isInterrupted() && i < Integer.MAX_VALUE) {
				System.out.println(i + " while循环");
				i++;
			}
		}
	}

	class MyThread4 extends Thread {
		private volatile boolean isStop = false;

		@Override
		public void run() {
			int i = 0;
			while (!isStop) {
				System.out.println(i + " while循环");
				i++;
			}
		}

		public void setStop(boolean stop) {
			this.isStop = stop;
		}
	}
}
