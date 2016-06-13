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
package com.xjf.wemall.service.crazyjavachapter8;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.TreeSet;
import com.xjf.wemall.comparator.treeSetComparator;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class tttest implements Serializable{

	public static void main(String[] arg) {
//		myString my1 = new myString("a", 1);
//		myString my2 = new myString("b", 2);
//		myString my3 = new myString("c", 3);
//		myString my4 = new myString("d", 4);
//		myString my5 = new myString("e", 1);
//		
//		System.out.println(my5.getValue());
//		System.out.println(my5.equals(my1));
//		
//		HashMap<myString, String> bb = new HashMap<myString, String>();
//		bb.put(my1, "a");
//		bb.put(my5, "e");
//		bb.put(my2, "b");
//		bb.put(my3, "c");
//		
//		System.out.println(bb);
//		
//		for(Entry<myString, String> b : bb.entrySet()) {
//			System.out.println(b.getKey().hashCode());
//			System.out.println(b.getValue());
//		}
//		
//		HashMap<String, String> cc = new HashMap<String, String>();
//		cc.put("1", "a");
//		cc.put("1", "b");
//		cc.put("1", "c");
//		for(Entry<String, String> c : cc.entrySet()) {
//			System.out.println(c.getKey());
//			System.out.println(c.getValue());
//		}
		
		
//		LinkedHashSet<String> set = new LinkedHashSet<String>();
//		set.add("2");
//		set.add("3");
//		set.add("1");
//		set.add("9");
//		set.add("7");
//
//		for(String c : set) {
//			System.out.println(c);
//		}
		
		TreeSet<String> set = new TreeSet<String>(new treeSetComparator());
		set.add("2");
		set.add("3");
		set.add("1");
		set.add("9");
		set.add("7");
		for(String c : set) {
			System.out.println(c);
		}
	}

}
