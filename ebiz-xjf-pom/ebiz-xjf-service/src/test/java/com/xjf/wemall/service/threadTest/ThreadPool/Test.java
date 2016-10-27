package com.xjf.wemall.service.threadTest.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);
     
    public static void main(String[] args)  {
        Test test = new Test();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
         
        producer.start();
        consumer.start();
    }
     
    class Consumer extends Thread{
         
        @Override
        public void run() {
            consume();
        }
         
        private void consume() {
            while(true){
                try {
                    int i = queue.take();
                    System.out.println("从队列取走一个元素"+i+"，队列剩余"+queue.size()+"个元素");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
    class Producer extends Thread{
         
        @Override
        public void run() {
            produce();
        }
         
        @SuppressWarnings("static-access")
		private void produce() {
            for (int i = 0; i < 999; i++) {
                try {

                    System.out.println("向队列取中插入一个元素"+i+"，队列剩余空间："+(queueSize-queue.size()));
                    queue.put(i);
                    	
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
