package com.xjf.wemall.AOPService.helloWorld;

import org.junit.Test;  
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.AOPService.AopTestBase;
import com.xjf.wemall.AOPService.helloWorld.API.IHelloWorldService;

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
}  