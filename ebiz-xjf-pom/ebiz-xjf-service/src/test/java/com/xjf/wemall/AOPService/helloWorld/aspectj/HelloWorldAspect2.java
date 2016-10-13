package com.xjf.wemall.AOPService.helloWorld.aspectj;

import java.lang.reflect.Constructor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.xjf.wemall.AOPService.helloWorld.API.IIntroductionService;

@Aspect
@Component
public class HelloWorldAspect2 {

	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//

	/*
	 * 切面、切入点、通知全部使用注解完成： 1）使用@Aspect将POJO声明为切面；
	 * 2）使用@Pointcut进行命名切入点声明，同时指定目标方法第一个参数类型必须是java
	 * .lang.String，对于其他匹配的方法但参数类型不一致的将也是不匹配的， 通过argNames =
	 * "param"指定了将把该匹配的目标方法参数传递给通知同名的参数上；
	 * 3）使用@Before进行前置通知声明，其中value用于定义切入点表达式或引用命名切入点；
	 * 4）配置文件需要使用<aop:aspectj-autoproxy/>来开启注解风格的@AspectJ支持；
	 * 5）需要将切面注册为Bean，如“aspect”Bean； 6）测试代码完全一样。
	 */
	// 定义切入点
	@Pointcut(value = "execution(* com.xjf..*.sayBefore(..)) && args(t1,t2)", argNames = "t1,t2")
	public void beforePointcut(String param, String param2) {
	}

	@Before(value = "beforePointcut(t1,t2)", argNames = "t1,t2")
	public void beforeAdvice(String param1, String param2) {
		System.out
				.println("===========before advice param1:" + param1 + param2);
	}

	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//
	// 后置返回通知
	@AfterReturning(value = "execution(* com.xjf..*.sayBefore(..))", 
			pointcut = "execution(* com.xjf..*.sayAfterReturning(..))", argNames = "retVal", 
			returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("===========after returning advice retVal:" + retVal);
	}
	
	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//
	// 后置异常通知
	@AfterThrowing(value = "execution(* com.xjf..*.sayAfterThrowing(..))", argNames = "exception1", throwing = "exception1")
	public void afterThrowingAdvice(Exception exception) {
		System.out.println("===========after throwing advice exception:"
				+ exception);
	}
	
	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//
	// 后置最终通知
	@After(value="execution(* com.xjf..*.sayAfterFinally(..))")  
	public void afterFinallyAdvice() {  
	    System.out.println("===========after finally advice");  
	}
	
	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//
	// 环绕通知
	@Around(value="execution(* com.xjf..*.sayAround(..))")  
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Class<?> clazz = pjp.getArgs()[0].getClass();
		Constructor<?> con = clazz.getConstructor(String.class);
		Object a = con.newInstance("aaa");
	    System.out.println("===========around before advice" + a);  
	    Object retVal = pjp.proceed(new Object[] {"replace"});  
	    System.out.println("===========around after advice");  
	    return retVal;  
	}
	// -----------------------------------------------------我是妖娆的分割线-----------------------------------------------------------//
	// 引入
	@DeclareParents(value="com.xjf..*.IHelloWorldService+", defaultImpl=com.xjf.wemall.AOPService.helloWorld.Impl.IntroductiondService.class)  
	private IIntroductionService introductionService;
}