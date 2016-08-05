package com.xjf.wemall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.AllServiceTest;
import com.xjf.wemall.service.index.api.IndexService;


/**
 * Unit test for simple App.
 */
public class pkgTest extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Test
	public void index() {
		// 不可以
//		Cat cat = new Cat();
	}
	
	// 二进制判断渠道
	public static void judge(int role) {
		if ((role & 1) == 1)
	    {
        	System.out.println(role + " 渠道1");
	    }
	    if ((role & 2) == 2)//主管权限
	    {
        	System.out.println(role + " 渠道2");
	    }
	    if ((role & 4) == 4)//管理员权限
	    {
    		System.out.println(role + " 渠道3");
	    }
	    if ((role & 8) == 8)//没有PM权限
	    {
        	System.out.println(role + " 渠道4");
	    }
	    
	}
	public static void main(String[] arg) {
		int[] a = {2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//		for (int b : a) {
//			System.out.println(Integer.toBinaryString(b));
//		}
		for (int b : a) {
			judge(b);
		}
		
	}
	
}
