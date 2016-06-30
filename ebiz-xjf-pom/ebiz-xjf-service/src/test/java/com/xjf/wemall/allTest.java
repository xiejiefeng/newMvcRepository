package com.xjf.wemall;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.iterators.LoopingIterator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.AllServiceTest;
import com.xjf.wemall.service.OutInnerClass;
import com.xjf.wemall.service.index.api.IndexService;
import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.service.redis.impl.RedisJobServiceImpl;


/**
 * Unit test for simple App.
 */
public class allTest extends AllServiceTest {
	
	
	@Test
	public void index() {
		// cat类没有public修饰，不在同一包内，不能用
//		Cat a = new Cat();
//		System.out.println(a.age);
//		a.setName("20");
//		System.out.println(a.age);
//		a.age = "30";
//		System.out.println(a.age);
		
		// 外部类
		OutInnerClass oc = new OutInnerClass();
		oc.inpo();
		// 外部类以外调用内部类
		// 先实例化内部类
		OutInnerClass.pubStaticInnerClass i = new OutInnerClass.pubStaticInnerClass();
		i.op();
//		OutInnerClass.pubInnerClass pic = oc.new pubInnerClass();
	}
	
	public static void main(String[] arg) {
		loop : for (int j =0;j<10;j++) {
			if (j == 5) {
				continue loop;
			}
			System.out.println(j);
		}
	
		
		DecimalFormat df = new DecimalFormat("0.##");
		double d = 123.12000000000000; 
		System.out.println(df.format(d));
		
		
	}

}
