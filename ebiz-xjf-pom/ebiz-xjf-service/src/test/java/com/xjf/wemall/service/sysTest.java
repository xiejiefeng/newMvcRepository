package com.xjf.wemall.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.index.api.IndexService;

/**
 * Unit test for simple App.
 */
public class sysTest extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Test
	public void index() {
		System.out.println(JSONParser.toJSONString(indexService.mapInfo()));
		
	}

	@Test
	public void index1() {
		System.out.println("你好".hashCode());
		
		System.out.println("你不好好".hashCode());
	}
	
	@Test
	public void index2() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		
		for (int i = 0; i <= 10; i++) {
			SampleVo vo = new SampleVo();
			vo.setI(i);
			
			list.add(vo);
		}
		
		
		// 排序
		Collections.sort(list, new sampleComparator());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(JSONParser.toJSONString(list.get(i)));
		}
	}
	
}
