package com.xjf.wemall.AOPService.helloWorld.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;

public class HelloWorldAspect {
	// 前置通知
	public void beforeAdvice() {
		System.out.println("===========before advice");
	}

	// 后置最终通知
	public void afterFinallyAdvice() {
		System.out.println("===========after finally advice");
	}
	
	// 前置通知带参数
	public void beforeAdvice(String param1,String param2) {
	    System.out.println("===========before advice param:" + param1 + " " + param2);  
	}
	
	// 后置通知带参数
	public void afterReturningAdvice(Object retVal) {  
	    //System.out.println("===========after returning advice retVal:" + retVal);  
	    System.out.println("===========after returning advice retVal:" + (retVal == null ? "空":retVal));  
	}
	
	// 后置异常通知带参数
	public void afterThrowingAdvice(Exception exception) {  
		System.out.println("===========after throwing advice exception:" + exception);  
	}
	
	// 环绕通知
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {  
	    System.out.println("===========around before advice");  
	    Object retVal = pjp.proceed(new Object[] {"replace"});  
	    System.out.println("===========around after advice");  
	    return retVal;  
	}
}