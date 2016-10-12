package com.xjf.wemall.AOPService.helloWorld.Impl;

import org.springframework.stereotype.Component;
import com.xjf.wemall.AOPService.helloWorld.API.IIntroductionService;

@Component
public class IntroductiondService implements IIntroductionService {
	@Override  
    public void induct() {  
        System.out.println("=========introduction");  
    }  
}
