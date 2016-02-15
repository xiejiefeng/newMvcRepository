package com.xjf.wemall.service;

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
	
	@Test
	public void redis() {
		List<String> list = indexService.getRedis();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(JSONParser.toJSONString(list.get(i)));
		}
	}
	
	@Test
	public void json() {
		Map<String, Map<String,String>> json = new HashMap<String, Map<String,String>>();
		
		Map<String,String> aa = new HashMap<String,String>();
		
		aa.put("a","1");
		aa.put("b","2");
		aa.put("c","3");
		
		json.put("json", aa);
		
		System.out.println(JSONParser.toJSONString(json));
		
		int[] a = new int[] {5,3,9,8,6};
		sort(a);
	}
	
	// 冒泡
	public void sort(int[] a)
    {
        int temp = 0;
        // 第一轮把最大的移上去
        for (int i = a.length - 1; i > 0; --i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (a[j + 1] < a[j])
                {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    
                }
                
                System.out.println(a[0] + " " + a[1]+ " " + a[2]+ " " + a[3]+ " " + a[4]);
            }
        }
    }
	
}
