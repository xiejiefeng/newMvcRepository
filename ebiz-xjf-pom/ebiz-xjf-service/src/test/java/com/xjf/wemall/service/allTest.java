package com.xjf.wemall.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.OutInnerClass.pubStaticInnerClass;
import com.xjf.wemall.service.index.api.IndexService;
import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.service.redis.impl.RedisJobServiceImpl;


/**
 * Unit test for simple App.
 */
public class allTest extends AllServiceTest {
	
	
	@Test
	public void index() {
		Cat a = new Cat();
		System.out.println(a.age);
		a.setName("20");
		System.out.println(a.age);
		a.age = "30";
		System.out.println(a.age);
		
		// 外部类
		OutInnerClass oc = new OutInnerClass();
		oc.inpo();
		
		OutInnerClass.pubStaticInnerClass psic = new OutInnerClass.pubStaticInnerClass();
		// 外部类以外调用内部类
		// 先实例化内部类
		OutInnerClass.pubInnerClass pic = oc.new pubInnerClass();
	}
	
	@Test
	public void staticInnerClassSubClass() {
		Cat a = new Cat();
		// 非静态内部类继承
		xiaoBSCat sbc = new xiaoBSCat(a);
		sbc.jiao();
		
		// 静态类继承
		xiaoStBSCat xsbc = new xiaoStBSCat();
		xsbc.jiao();
	}
	
	
	@Test
	public void index1() {
		String strTemplateNo = "[\"123\",\"456\"]";
		
		List<String> templateNoList = null;

        try {
            templateNoList = JSONParser.toStringList(strTemplateNo, String.class);
        } catch (Exception e) {
        	System.out.println("error");
        }
	}
	

}
