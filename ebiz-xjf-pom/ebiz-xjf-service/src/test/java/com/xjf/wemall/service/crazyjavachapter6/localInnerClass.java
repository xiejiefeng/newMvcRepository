package com.xjf.wemall.service.crazyjavachapter6;

abstract class abClass {
	private String name;
	public abstract String getPrice();
	public abClass() {
		System.out.println("无参构造器");
		this.name = "无参构造器的name";
	}
	public abClass(String value) {
		System.out.println("有参构造器");
		this.name = "有参构造器   name=" + value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
interface outInterFace {
	String getPrice();
}
// 6.7.4 局部内部类
// 6.7.7 匿名内部类
class localInnerClass {
	
	public void test(outInterFace a) {
		System.out.println(a.getPrice());
	}
	
	public void test2(abClass ab) {
		System.out.println(ab.getPrice());
	}
	
	public static void main(String[] args) {
		/*********************匿名内部类*************************/
		final int bb = 1;
		localInnerClass aaa = new localInnerClass();
		aaa.test(new outInterFace() {
			public String getPrice() {
				// java8以前访问局部变量必须final
				// java8以后没有此规定
				return String.valueOf(bb);
//				return "a";
			}
		});
		
//		aaa.test2(new abClass() {
//			@Override
//			public String getPrice() {
//				// TODO Auto-generated method stub
//				return this.getName();
//			}
//		});
		
		abClass d = new abClass("我是name") {
			{
				System.out.println("我是初始化块");
			}
			@Override
			public String getPrice() {
				// TODO Auto-generated method stub
				return this.getName();
			}
		};
		aaa.test2(d);
		/*********************局部内部类*************************/
		class innerBase {
			int a;
		}
		class innerSub extends innerBase {
			int b;
		}
		
		innerSub s1 = new innerSub();
		s1.a = 5;
		s1.b = 6;
		System.out.println(s1.a + "   " + s1.b);
	}
	
}
