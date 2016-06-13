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

import java.util.WeakHashMap;
/**
 * 弱引用map <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class WeakHashMapTest {
	
	public static void main(String[] arg) {
		WeakHashMap<String, String> mp = new WeakHashMap<String, String>();
		// 匿名字符串，没有其他引用
		mp.put(new String("语文"), "语文");
		mp.put(new String("数学"), "数学");
		
		// 添加系统缓存的字符串对象为Key，系统会自动保存该字符串的强引用
		mp.put("java", "java");
		
		System.out.println(mp);
		// 通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		// 通常只能看到java的
		System.out.println(mp);
	}
	
}
