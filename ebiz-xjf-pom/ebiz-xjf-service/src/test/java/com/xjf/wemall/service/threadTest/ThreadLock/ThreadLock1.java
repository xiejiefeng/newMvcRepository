package com.xjf.wemall.service.threadTest.ThreadLock;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 1.可重入锁
// 2.可中断锁
// 3.公平锁
// 4.读写锁
public class ThreadLock1 {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args)  {
        final ThreadLock1 test = new ThreadLock1();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
         
        new Thread(){
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }  
     
    public void insert(Thread thread) {
    	// 也许有朋友会问，怎么会输出这个结果？第二个线程怎么会在第一个线程释放锁之前得到了锁？
    	// 原因在于，在insert方法中的lock变量是局部变量，每个线程执行该方法时都会保存一个副本，
    	// 那么理所当然每个线程执行到lock.lock()处获取的是不同的锁，所以就不会发生冲突。
//        Lock lock = new ReentrantLock();    //注意这个地方
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}