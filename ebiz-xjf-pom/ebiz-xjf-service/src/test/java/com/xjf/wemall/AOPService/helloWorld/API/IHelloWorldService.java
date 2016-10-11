package com.xjf.wemall.AOPService.helloWorld.API;

public interface IHelloWorldService {
	public void sayHello();
	
	public void sayBefore(String param1,String param2);
	
	public boolean sayAfterReturning();
}
