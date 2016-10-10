package com.xjf.wemall.service.threadTest.ThreadLock;
public class TestSynchronized2
{    
    public void test1(Object lock)   
    {    
//         synchronized(lock)
    	synchronized(this)
         {    
              int i = 10;    
              while( i-- > 0)   
              {    
                   System.out.println(Thread.currentThread().getName() + " : " + i);    
                   try   
                   {    
                        Thread.sleep(500);    
                   }   
                   catch (InterruptedException ie)   
                   {    
                   }    
              }    
         }    
    }    
      
    public synchronized void test2()   
    {    
         int i = 10;    
         while( i-- > 0)   
         {    
              System.out.println(Thread.currentThread().getName() + " : " + i);    
              try   
              {    
                   Thread.sleep(500);    
              }   
              catch (InterruptedException ie)   
              {    
              }    
         }    
    }
    public void test3(Object lock)   
    {    
    	synchronized(this)
         {    
              int i = 10;    
              while( i-- > 0)   
              {    
                   System.out.println(Thread.currentThread().getName() + " : " + i);    
                   try   
                   {    
                        Thread.sleep(500);    
                   }   
                   catch (InterruptedException ie)   
                   {    
                   }    
              }    
         }    
    }    
      
    public static void main(String[] args)   
    {    
         final TestSynchronized2 myt2 = new TestSynchronized2();
         final Object lock = new Object();
         Thread test1 = new Thread(new Runnable() {
        	 public void run() {  
        		 myt2.test1(lock);  
        		 }  
        	 }, "test1"  );    
         Thread test2 = new Thread(new Runnable() {  
        	 public void run() { 
        		 myt2.test3(lock);   
        		 }  
        	 }, "test3"  );    
         test1.start();;    
         test2.start();
    }   
    
}  
