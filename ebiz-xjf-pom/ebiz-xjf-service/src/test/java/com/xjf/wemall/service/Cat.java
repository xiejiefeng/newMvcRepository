package com.xjf.wemall.service;

class Cat extends Animal {
	
	public static String age;
	
	public String weight;
	
	static {
		System.out.println("Cat 静态初始模块");
	}
	
	{
		System.out.println("Cat 初始模块");
	}
	
	public class bsCat {
		public bsCat() {
			System.out.println("波斯猫");
		}
		
		public void jiao() {
			System.out.println("喵喵喵");
		}
	}
	
	public static class stBsCat {
		public stBsCat() {
			System.out.println("静态波斯猫");
		}
		
		public void jiao() {
			System.out.println("静态喵喵喵");
		}
	}
	
	public Cat(String age) {
		this.age = age;
	}
	
	public Cat() {
		this.age = "10";
		System.out.println("猫 年龄10岁");
	}
	
	public void setName(String age) {
		this.age = age;
	}
	
	@Override
	public String getName() {
		return "Cat";
	}
	// 重写toString
	public String toString() {
		return "toString";
	}
	
	public static void test() {
		System.out.println(age);
		// 静态成员不能访问非静态成员
//		System.out.println(weight);
//		setName();
		
	}
}
