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

import java.util.HashSet;
import java.util.IdentityHashMap;


/**
 * IdentityHashMapTest <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IdentityHashMapTest {
	
	public static void main(String[] arg) {
		IdentityHashMap<String, String> mp = new IdentityHashMap<String, String>();
		
		// 连个key，equals相等，hashCode不相等
		mp.put(new String("语文"), "语文");
		mp.put(new String("语文"), "数学");
		
		mp.put("java", "93");
		mp.put("java", "94");
		
		System.out.println(mp);
		
	}
	
}
