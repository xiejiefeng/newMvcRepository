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
public class fanxing941 implements Serializable{
	static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		System.out.println(a[0].getClass().getName());
//		for(T o : a) {
//			c.add(o);
//		}
	}
	public static void main(String[] arg) {
		Object[] oa = new Object[100];
		oa[0]="1";
		Collection<Object> co = new ArrayList<>();
		// 下面代码中T代表Object类型
		fromArrayToCollection(oa, co);
		
		String[] sa = new String[100];
		sa[0]="1";
		Collection<String> cs = new ArrayList<>();
		// 下面代码中T代表String类型
		fromArrayToCollection(sa, cs);
		
		// 下面代码中T代表Object类型
		fromArrayToCollection(sa, co);
		
		Integer[] ia = new Integer[100];
		ia[0]=1;
		Float[] fa = new Float[100];
		fa[0]=1.1F;
		Number[] na = new Number[100];
		na[0] = 100L;
		Collection<Number> cn = new ArrayList<>();
		// 下面代码中T代表Number类型
		fromArrayToCollection(ia, cn);
		// 下面代码中T代表Number类型
		fromArrayToCollection(fa, cn);
		// 下面代码中T代表Number类型
		fromArrayToCollection(na, cn);
		// 下面代码中T代表Object类型
		fromArrayToCollection(na, co);
		
		// 下面代码中T代表String类型，但na是一个Number数组，
		// 因为Number既不是String类型，
		// 也不是它的子类，所以出现编译错误
//		fromArrayToCollection(na, cs);
	}

}
