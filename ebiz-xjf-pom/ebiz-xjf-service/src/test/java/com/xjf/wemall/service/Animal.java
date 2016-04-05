package com.xjf.wemall.service;

public class Animal {

	static {
		System.out.println("Animal 静态初始模块");
	}
	
	{
		System.out.println("Animal 初始模块");
	}
	public void shout() {
		System.out.println(getName());
	}
	
	public void animal() {
		System.out.println("animal");
	}
	
	public String getName() {
		return "animal";
	};
	
	
}
