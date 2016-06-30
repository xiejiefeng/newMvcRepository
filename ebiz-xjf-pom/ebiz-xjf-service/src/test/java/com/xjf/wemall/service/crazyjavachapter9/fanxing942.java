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
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

import javax.persistence.ColumnResult;

import com.xjf.wemall.comparator.treeSetComparator;
import com.xjf.wemall.service.sysTest;
import com.xjf.wemall.service.crazyjavachapter8.iterator;
import com.aps.t;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class fanxing942<L> implements Serializable{
	L b;
	
	public <T> void aa(L msg, Collection<T> a, Collection<? extends T> c) {
		
	}
	
	static <T> void fromArrayToCollection(Collection<T> a, Collection<? extends T> c) {
//		System.out.println(a[0].getClass().getName());
//		for(T o : a) {
//			c.add(o);
//		}
	}
	
	static <T, S extends T> void fromArrayToCollection2(Collection<T> a, Collection<S> c) {
//		System.out.println(a[0].getClass().getName());
//		for(T o : a) {
//			c.add(o);
//		}
	}
	
	static <L> void fromArrayToCollection3(Collection<?> a, Collection<? extends L> c) {
//		System.out.println(a[0].getClass().getName());
//		for(T o : a) {
//			c.add(o);
//		}
	}

}
