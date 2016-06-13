package com.xjf.wemall.service.crazyjavachapter6;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class referenceTest {

	public static void main(String[] args) {
		
//		// 软引用
//		String str1 = new String("测试");
//				
//		SoftReference<String> sr = new SoftReference<String>(str1);
//		
//		// 切断str和对象的联系
//		str1 = null;
//		// 取出软引用所引用对象
//		System.out.println(sr.get());
//		
//		System.gc();
//		System.runFinalization();
//		
//		// 再次取出软引用所引用对象
//		System.out.println(sr.get());
//		
//		
//		
//		// 弱引用
//		String str = new String("疯狂Java讲义");
//		
//		// 弱引用
//		WeakReference wr = new WeakReference(str);
//		
//		// 切断str和对象的联系
//		str = null;
//		// 取出弱引用所引用对象
//		System.out.println(wr.get());
//		
//		System.gc();
//		System.runFinalization();
//		
//		// 再次取出弱引用所引用对象
//		System.out.println(wr.get());


		// 虚引用
		String str1 = new String("疯狂Java讲义");
		
		// 创建引用队列
		ReferenceQueue rq = new ReferenceQueue();
		
		// 创建虚引用，用到str1和引用队列
		PhantomReference pr = new PhantomReference(str1, rq);
		
		// 切断str和对象的联系
		str1 = null;
		// 取出虚引用所引用对象
		// 系统无法从虚引用中获得被引用的对象
		System.out.println(pr.get());
		
		System.gc();
		System.runFinalization();
		
		// 垃圾回收之后，虚引用将会放入引用队列中
		// 取出引用队列中最前的引用和pr作比较
		// 轮询此队列,查看是否存在可用的引用对象。如果存在一个立即可用的对象,则从该队列中移除此对象并返回
//		System.out.println(rq.poll());
		System.out.println(rq.poll() == pr);
	}

}
