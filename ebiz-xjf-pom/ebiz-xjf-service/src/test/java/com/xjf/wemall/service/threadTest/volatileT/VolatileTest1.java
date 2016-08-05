package com.xjf.wemall.service.threadTest.volatileT;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 1）对变量的写操作不依赖于当前值
 * 2）该变量没有包含在具有其他变量的不变式中
 */
public class VolatileTest1 {
    public volatile boolean flat = false;
     
	public void doSomething() throws InterruptedException {
	    while(!flat) {
	    	Thread.currentThread().sleep(1000);
	    	System.out.println("OK");
	    }
	}
	
    public static void main(String[] args) {
        final VolatileTest1 test = new VolatileTest1();
        
        new Thread(){
            public void run() {
                try {
					test.doSomething();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            };
        }.start();
        
        new Thread(){
            public void run() {
            	try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                test.flat = true;
            };
        }.start();
        
        
    }
}
