package com.xjf.wemall.service.threadTest.ThreadRQ;

import java.util.ArrayList;
import java.util.Vector;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        long start = System.currentTimeMillis();
        for(int i=0;i<10000000;i++)
            vector.add(i);
        long end = System.currentTimeMillis();
        System.out.println("Vector进行100000次插入操作耗时："+(end-start)+"ms");
        
        
        start = System.currentTimeMillis();
        for(int i=0;i<10000000;i++)
            list.add(i);
        end = System.currentTimeMillis();
        System.out.println("ArrayList进行100000次插入操作耗时："+(end-start)+"ms");
    }
}
