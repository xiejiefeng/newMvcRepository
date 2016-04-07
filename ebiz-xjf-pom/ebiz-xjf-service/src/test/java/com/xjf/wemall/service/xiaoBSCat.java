package com.xjf.wemall.service;


class xiaoBSCat extends Cat.bsCat {
	
	xiaoBSCat(Cat cat)   {
		cat.super();
		System.out.println("小波斯猫");
	}
	public void jiao() {
		super.jiao();
	}
}
