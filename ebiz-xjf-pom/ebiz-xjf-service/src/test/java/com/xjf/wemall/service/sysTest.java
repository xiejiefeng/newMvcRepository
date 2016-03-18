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
import com.xjf.wemall.api.entity.SampleVo;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.comparator.sampleComparator;
import com.xjf.wemall.service.index.api.IndexService;
import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.service.redis.impl.RedisJobServiceImpl;


/**
 * Unit test for simple App.
 */
public class sysTest extends AllServiceTest {
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private RedisJobService redisJobService;
	
	
	@Test
	public void index() {

		((RedisJobServiceImpl) redisJobService).setInProgressMsg("hello 世界");
		
		System.out.println(redisJobService.getInProgressMsg());
//		System.out.println(JSONParser.toJSONString(indexService.mapInfo()));
		
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
	
	@Test
	public void testStack() {
		// 以下两条语句创建了1个对象。"凤山"存储在字符串常量池中 
	    String str1 = "凤山"; 
	    String str2 = "凤山"; 
	    System.out.println(str1==str2);//true 
	     
	    //以下两条语句创建了3个对象。"天峨"，存储在字符串常量池中，两个new String()对象存储在堆内存中 
	    String str3 = new String("天峨"); 
	    String str4 = new String("天峨"); 
	    System.out.println(str3==str4);//false 
	     
	    //以下两条语句创建了1个对象。9是存储在栈内存中 
	    int i = 9; 
	    int j = 9; 
	    System.out.println(i==j);//true 
	     
	    //由于没有了装箱，以下两条语句创建了2个对象。两个1对象存储在堆内存中 
	    Integer l1 = new Integer(1); 
	    Integer k1 = new Integer(1); 
	    System.out.println(l1==k1);//false 
	    //以下两条语句创建了1个对象。1和k变量存储在栈内存中。自动装箱时对于值从127之间的值，使用一个实例。
	    Integer l = 20;//装箱 
	    Integer k = 20;//装箱 
	    System.out.println(l==k);//true 
	    //以下两条语句创建了2个对象。i1,i2变量存储在栈内存中，两个256对象存储在堆内存中 
	    Integer i1 = 256; 
	    Integer i2 = 256; 
	    System.out.println(i1==i2);//false 

		// -128~127自动装箱成Integer实例时，永远引用同一cache数组的同一数组元素
		// 每次把这个范围之外的整数自动装箱成Integer实例时，系统总是重新创建一个新的Integer实例
		Integer i3 = 127;
		Integer i4 = 127;
		System.out.println(i3==i4);//true 
		
		
		//redis中的大类小类映射数据
		Map<String, List<MailVo>> sysCodeMap = new HashMap<String, List<MailVo>>();
		MailVo mail = new MailVo();
		mail.setText("aaa");
		
		
		List<MailVo> detailCodeSet =  new ArrayList<MailVo>();
		detailCodeSet.add(mail);
		
		mail = new MailVo();
		mail.setText("aaa");
		detailCodeSet.add(mail);
		sysCodeMap.put("aa", detailCodeSet);
		
		System.out.println(JSON.toJSONString(sysCodeMap.get("aa")));//true 
		
	}
	
	@Test
	public void tt() {
		Set<Integer> aa = getCanUseCheckFlag();
		
		System.out.println(aa);
	}
	
	/**
	 * 获得所有合法的checkFlag
	 * 
	 * @return Set<Integer>
	 */
	public Set<Integer> getCanUseCheckFlag() {
		List<Integer> iL = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 1; i <= 4; i++) {
			plzh(result, "0", iL, i);
		}
		Set<Integer> set = new HashSet<Integer>(result);
		return set;
	}

	/**
	 * 排列组合
	 * 
	 * @param result
	 * @param s
	 * @param iL
	 * @param m
	 */
	private void plzh(List<Integer> result, String s, List<Integer> iL, int m) {
		List<Integer> iL2;
		String[] is = new String[]{"2","8","4","1"};
		for (int i = 0; i < is.length; i++) {
			iL2 = new ArrayList<Integer>();
			iL2.addAll(iL);
			if (!iL.contains(i)) {
				int str = Integer.parseInt(s) + Integer.parseInt(is[i]);
				iL2.add(i);
//				result.add(str);
				plzh(result, String.valueOf(str), iL2, m - 1);
			}
		}
	}
}
