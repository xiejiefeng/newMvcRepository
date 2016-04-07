package com.xjf.wemall.service;

public class OutInnerClass {
	private String outerProp = "outer";
	private static String staticProp = "static outer";
	
	private class innerClass {
		private String innerProp = "inner";
		
		public void op() {
			System.out.println(OutInnerClass.this.outerProp);
		}
	}
	
	class pubInnerClass {
		private String innerProp = "inner";
		
		public void op() {
			System.out.println(OutInnerClass.this.outerProp);
		}
	}
	
	public static class pubStaticInnerClass {
		private String innerProp = "static inner";
		private static String staticInnerProp = "static static inner";
		public void op() {
			// 静态类不能访问外部类非静态变量
//			System.out.println(OutInnerClass.this.outerProp);
			OutInnerClass oc = new OutInnerClass();
			System.out.println(oc.outerProp);
			
			// 静态类只能访问外部类静态变量
			System.out.println(OutInnerClass.staticProp);
		}
	}
	
	private static class priStaticInnerClass {
		private String innerProp = "static inner";
		private static String staticInnerProp = "static static inner";
		public void op() {
			// 静态类不能访问外部类非静态变量
//			System.out.println(OutInnerClass.this.outerProp);
			// 静态类只能访问外部类静态变量
			System.out.println(OutInnerClass.staticProp);
		}
	}
	
	public void inpo() {
//		System.out.println(innerProp);
		innerClass ic = new innerClass();
		System.out.println(ic.innerProp);
		ic.op();
		System.out.println(pubStaticInnerClass.staticInnerProp);
		
		pubStaticInnerClass sic = new pubStaticInnerClass();
		System.out.println(sic.innerProp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutInnerClass oc = new OutInnerClass();
		oc.inpo();
	}

}
