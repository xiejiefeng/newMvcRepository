package com.xjf.wemall.service.crazyjavachapter6;

import org.junit.Test;

// 6.3.2 singleton单例
class Singleton {
	
	// 使用类变量来缓存类实例
	private static Singleton instance;
	
	private Singleton(){};
	
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(s1==s2);
	}
	
}
class SingletonTest {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		// 单例类，因为构造函数是private，不能实例化对象
		//Singleton s3 = new Singleton();
		System.out.println(s1==s2);
	}
	
}
