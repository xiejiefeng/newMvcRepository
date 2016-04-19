package com.xjf.wemall.service.crazyjavachapter6;

public enum Gender {
	
	MALE("男"),FAMALE("女");
	// 定义一个public修饰变量
	private final String name;
	
	private Gender(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}