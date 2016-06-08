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
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class linkedst implements Serializable{

	public static void main(String[] arg) {
		LinkedList<String> link = new LinkedList<String>();
		link.offer("a");
		link.offer("b");
		link.offer("c");
		link.offer("d");
		link.offer("e");
		link.offer("f");
	
		Iterator<String> it = link.iterator();
		
		while(it.hasNext()) {
			String book = (String)it.next();
			System.out.println(book);
		}
	}

}
