package com.xjf.wemall.service;

public class test {

	public static void main(String[] args) {
		Animal a = new Cat();
		Animal b = new Animal();
		Cat c = new Cat();
		((Animal) a).animal();//animal
		a.shout();//cat
		b.shout();//Animal
		
		// default类 修改类变量
		Cat cat = new Cat();
		System.out.println(Cat.age);//10 
		
		Cat cat2 = new Cat("99");
		System.out.println(Cat.age);//99
				
		// 重写toString
		System.out.println(c.toString());
		System.out.println(a.toString());
		
		// 装箱拆箱
		Integer intObj = 5; // 装箱
		int intNotObj = intObj; // 拆箱
		
		Object booleanObj = true; // 装箱
		if (booleanObj instanceof Boolean) {
			boolean bool = (Boolean) booleanObj;// 拆箱
			boolean boo2 = (boolean) booleanObj;// 拆箱
			System.out.println(bool);
			System.out.println(boo2);
		}
	}

}
