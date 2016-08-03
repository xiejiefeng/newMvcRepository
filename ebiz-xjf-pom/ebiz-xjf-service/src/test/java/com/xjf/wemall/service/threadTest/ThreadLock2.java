package com.xjf.wemall.service.threadTest;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 有点问题的
class ThreadTest2 {
	private ReentrantLock lock = new ReentrantLock(true);
	public void insert() throws InterruptedException {
		System.out.println(Thread.currentThread().getName()+ " START " + lock.getQueueLength());
		lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"得到了锁");
            Thread.currentThread().sleep(200);
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(Thread.currentThread().getName()+"释放了锁");
            lock.unlock();
        }
    }
}
public class ThreadLock2 {
    
    public static void main(String[] args) throws InterruptedException, ExecutionException  {
        final ThreadTest2 test = new ThreadTest2();
        final Runnable r1 = new Runnable() {
			@Override
			public void run() {

				try {
					test.insert();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
        
        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r1, "t2");
        Thread t3 = new Thread(r1, "t3");
        Thread t4 = new Thread(r1, "t4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
    }  
     
    
}
