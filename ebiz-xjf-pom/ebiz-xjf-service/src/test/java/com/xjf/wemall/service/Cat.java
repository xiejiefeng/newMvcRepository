package com.xjf.wemall.service;

class Cat extends Animal {
	
	public static String age;
	
	static {
		System.out.println("Cat 静态初始模块");
	}
	
	{
		System.out.println("Cat 初始模块");
	}
	
	public Cat(String age) {
		this.age = age;
	}
	
	public Cat() {
		this.age = "10";
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
}
