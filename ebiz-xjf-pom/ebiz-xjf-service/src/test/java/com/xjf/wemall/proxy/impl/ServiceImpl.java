package com.xjf.wemall.proxy.impl;

import com.xjf.wemall.proxy.api.Service;

/**
 * @author qsy
 * @version 创建时间：2016年10月13日 下午1:23:55
 * 类说明
 */
public class ServiceImpl implements Service{  
	  
	@Override  
    public void sayHello() {
        System.out.println("Hello world!");
    }
  
    @Override  
    public void sayBye() {
        System.out.println("Bye bye!");
    }
}