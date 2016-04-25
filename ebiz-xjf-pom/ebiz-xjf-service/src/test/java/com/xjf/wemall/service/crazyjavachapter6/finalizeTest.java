package com.xjf.wemall.service.crazyjavachapter6;

public class finalizeTest {
	private static finalizeTest ftt = null;
//	private finalizeTest ft = null;
	
	public void info() {
		System.out.println("测试内存清理");
	}
	
	public void finalize() throws Throwable {
		super.finalize();
		ftt = this;
//		ft = this;
		System.out.println("系统正在清理GcTest对象");
	}
	
	public static void main(String[] args) {
		// 匿名对象，因为没有被赋给任何引用变量，所以对象立即变为可恢复状态
		new finalizeTest();
//		finalizeTest ff = new finalizeTest();
		System.gc();
		// 强制调用finalize方法
//		Runtime.getRuntime().runFinalization();
		System.runFinalization();
		ftt.info();
		
		
		// 比较调用finalize方法，因为finalizeTest ff = new finalizeTest(); 对象被main方法引用。
//		ff.info();

	}

}
