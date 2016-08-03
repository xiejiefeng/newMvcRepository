package com.xjf.wemall.service.threadTest;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 有点问题的
class ThreadTest {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();
	public boolean insert(Lock lock) {
        if(lock.tryLock()) {
            try {
                System.out.println(Thread.currentThread().getName()+"得到了锁");
                Thread.currentThread().sleep(200);
            } catch (Exception e) {
                // TODO: handle exception
            }finally {
                System.out.println(Thread.currentThread().getName()+"释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName()+"获取锁失败");
            return false;
        }
        return true;
    }
}
public class ThreadLock {
    
    private Lock lock = new ReentrantLock();    //注意这个地方
    public static void main(String[] args) throws InterruptedException, ExecutionException  {
        final ThreadTest test = new ThreadTest();
        // 公平锁
        final ReentrantLock lock = new ReentrantLock(true);
        
        // 使用FutureTask来包装Callable对象
		FutureTask<Boolean> task = new FutureTask<>(
				new Callable<Boolean>() {
					@Override
					public Boolean call() throws Exception {
						return test.insert(lock);
					};
				}
		);
        
        Thread t1 = new Thread(task , "thead1");
        Thread t2 = new Thread(task , "thead2");
        Thread t3 = new Thread(task , "thead3");
        Thread t4 = new Thread(task , "thead4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        System.out.print(task.get());
    }  
     
    
}
