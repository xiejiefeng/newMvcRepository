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

import java.util.ArrayList;
import java.util.Collection;

import com.amap.api.location.a;

/**
 * 9.2.2从泛型类派生子类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class A1 extends Apple {
	public A1(Object info) {
		super(info);
	}

	public String getInfo() {
		return super.getInfo().toString();
	}
	
	public static void main(String[] arg) {
		Collection<String> list = new ArrayList<String>();
		
		if (list instanceof ArrayList) {
			System.out.println(1);
		}
		if (list instanceof Collection) {
			System.out.println(2);
		}
	}
}
