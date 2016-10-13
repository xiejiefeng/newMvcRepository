package com.xjf.wemall.AOPService.helloWorld;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.AOPService.AopTestBase;
import com.xjf.wemall.AOPService.helloWorld.API.IHelloWorldService;
import com.xjf.wemall.AOPService.helloWorld.API.IIntroductionService;

public class AopTest extends AopTestBase {
	@Autowired
	IHelloWorldService helloworldService;
    @Test  
    public void testHelloworld() {  
        helloworldService.sayHello();  
    }
    @Test  
    public void sayBefore() {  
        helloworldService.sayBefore("TParam1","TParam2");  
    }  
    
    @Test  
    public void testSchemaAfterReturningAdvice() {  
        System.out.println("======================================");
        helloworldService.sayAfterReturning();    
        System.out.println("======================================");
    }  
    
    @Test(expected = RuntimeException.class)  
    public void testSchemaAfterThrowingAdvice() {
        System.out.println("======================================");
        helloworldService.sayAfterThrowing();    
        System.out.println("======================================");
    }
    
    @Test(expected = RuntimeException.class)  
    public void testSchemaAfterFinallyAdvice() {  
        System.out.println("======================================"); 
        helloworldService.sayAfterFinally();  
        System.out.println("======================================");
    }
    
    @Test  
    public void testSchemaAroundAdvice() {  
        System.out.println("======================================");
        helloworldService.sayAround("haha");  
        System.out.println("======================================");  
    }

    @Test  
    public void testSchemaIntroduction() {  
        System.out.println("======================================");
        // 为目标对象引入新的借口
        IIntroductionService introductionService = applicationContext.getBean("helloWorldService", IIntroductionService.class);  
        introductionService.induct();  
        System.out.println("======================================");  
    }
    
    @Test  
    public void testSchemaAdvisor() {  
       System.out.println("======================================");  
       helloworldService.sayAdvisorBefore("haha");  
       System.out.println("======================================");  
    }
    
    /**
     * 注解ASPECT
     */
    @Test  
    public void testAnnotationBeforeAdvice() {  
        System.out.println("======================================");
        helloworldService.sayBefore("before1","before2");  
        System.out.println("======================================");  
    }
}  