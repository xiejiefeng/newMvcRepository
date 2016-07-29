package com.xjf.wemall.service.threadTest;

import java.io.IOException;

public class ThreadSleep {
    
    private int i = 0;
    private Object object = new Object();
     
    public static void main(String[] args) throws IOException  {
    	ThreadSleep test = new ThreadSleep();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    } 
     
     
    class MyThread extends Thread{
        @Override
        public void run() {
        	// sleep相当于让线程睡眠，交出CPU，让CPU去执行其他的任务。
        	// sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，
        	// 则即使调用sleep方法，其他线程也无法访问这个对象
        	// 如果调用了sleep方法，必须捕获InterruptedException异常或者将该异常向上层抛出。
        	// 当线程睡眠时间满后，不一定会立即得到执行，
        	// 因为此时可能CPU正在执行其他的任务。所以说调用sleep方法相当于让线程进入阻塞状态。
        	// 可以看出，当调用thread1.join()方法后，main线程会进入等待，然后等待thread1执行完之后再继续执行。
        	// 实际上调用join方法是调用了Object的wait方法
        	// wait方法会让线程进入阻塞状态，并且会释放线程占有的锁，并交出CPU执行权限。
        	// 由于wait方法会让线程释放对象锁，所以join方法同样会让线程释放对一个对象持有的锁。具体的wait方法使用在后面文章中给出。
            synchronized (object) {
                i++;
                System.out.println("i:"+i);
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"进入睡眠状态");
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }
                System.out.println("线程"+Thread.currentThread().getName()+"睡眠结束");
                i++;
                System.out.println("i:"+i);
            }
        }
    }
}