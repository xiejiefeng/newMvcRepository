package com.xjf.wemall.AOPService.helloWorld.Impl;

import org.springframework.stereotype.Component;

import com.xjf.wemall.AOPService.helloWorld.API.IHelloWorldService;

@Component
public class HelloWorldService implements IHelloWorldService {
	
	@Override
    public void sayHello() {
        System.out.println("============Hello World!");
    }
	
	@Override
	public void sayBefore(String param1,String param2) {
	    System.out.println("===========say " + param1 + "===========say " + param2);
	}

	@Override  
	public boolean sayAfterReturning() {
	    System.out.println("===========after returning");
	    return true;
	}
}
