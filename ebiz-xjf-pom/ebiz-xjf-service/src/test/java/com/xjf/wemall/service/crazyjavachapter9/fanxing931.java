/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CarModelInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.crazyjavachapter9;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import com.xjf.wemall.comparator.treeSetComparator;
import com.xjf.wemall.service.crazyjavachapter8.iterator;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class fanxing931 implements Serializable{
	public void test(List<?> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public <T> void test1(List<T> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T test2(Class<T> cls) {
		System.out.println(cls.getName());
		return (T) "1";
	}
	public static void main(String[] arg) {
		fanxing931 a = new fanxing931();
		List<String> list = new ArrayList<String>();
		list.add("aaaa");
		a.test(list);
		
		a.test1(list);
		
		System.out.print(a.test2(Integer.class));
	}

}
