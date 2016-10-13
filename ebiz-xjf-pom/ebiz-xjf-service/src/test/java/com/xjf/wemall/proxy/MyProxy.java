package com.xjf.wemall.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.xjf.wemall.proxy.api.Service;
import com.xjf.wemall.proxy.factory.ServiceFactory;
import com.xjf.wemall.proxy.impl.ServiceImpl;

/**
 * @author qsy
 * @version 创建时间：2016年10月13日 下午1:31:19
 * 类说明
 */
public class MyProxy implements InvocationHandler{  
    
    // 目标对象，也就是我们主要的业务，主要目的要做什么事  
    private Object delegate;  
      
    /** 
     * 和你额外需要做得事情，进行绑定，返回一个全新的对象（写法，基本上固定的） 
     * @param delegate 
     * @return 
     */  
    public Object bind(Object delegate){  
        this.delegate = delegate;  
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(),   
                this.delegate.getClass().getInterfaces(), this);  
    }  
      
    /** 
     * 你刚才需要执行的方法，都需要通过该方法进行动态调用 
     */  
    @Override  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
        Object obj = null;  
        // 执行前置的方法  
        ServiceFactory.before();  
        // 通过反射，执行目标方法，也就是你的主要目的  
        obj = method.invoke(this.delegate, args);  
        // 执行后置的方法  
        ServiceFactory.after();  
        // 返回值给调用者  
        return obj;  
    }
    
    /** 
     * 测试类 
     * @param args 
     */  
    public static void main(String[] args) {  
        // 不启用代理  
        //Service service = new ServiceImpl();  
        // 使用代理  
        Service service = (Service)new MyProxy().bind(new ServiceImpl());  
          
        service.sayHello();  
        service.sayBye();
    }
  
}