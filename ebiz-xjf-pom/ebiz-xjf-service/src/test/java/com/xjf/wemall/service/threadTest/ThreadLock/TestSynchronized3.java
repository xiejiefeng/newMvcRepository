package com.xjf.wemall.service.threadTest.ThreadLock;

public class TestSynchronized3 {

	public void test1(Object lock) {
		synchronized(lock) {
			int i = 10;
			while (i-- > 0) {
				System.out
						.println(Thread.currentThread().getName() + " : " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public void test3(Object lock) {
		synchronized(lock) {
			int i = 10;
			while (i-- > 0) {
				System.out
						.println(Thread.currentThread().getName() + " : " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException ie) {
				}
			}
		}
	}

	public static void main(String[] args) {
		final TestSynchronized3 myt2 = new TestSynchronized3();

		final Object lock1 = new Object();
		final Object lock2 = new Object();
		
		Thread test1 = new Thread(new Runnable() {
			public void run() {
				myt2.test1(lock1);
			}
		}, "test1");
		Thread test2 = new Thread(new Runnable() {
			public void run() {
				myt2.test3(lock1);
			}
		}, "test3");
		test1.start();
		;
		test2.start();
	}

}
