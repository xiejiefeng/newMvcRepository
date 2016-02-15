package com.xjf.wemall.service;

class Cat extends Animal {
	
	public static String age;
	
	public Cat(String age) {
		this.age = age;
	}
	
	public Cat() {
		this.age = "10";
	}
	
	@Override
	public String getName() {
		return "Cat";
	}
}
