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

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class myString extends Object {
	private static ArrayList<String> myList = new ArrayList<String>();
	private String value;
	private int hash;
	
	public myString(String value, int hash) {
		if (myList.contains(value)) {
			for (String a: myList) {
				if (a.equals(value)) {
					this.value = a;
				}
			}
		} else {
			this.value = value;
			myList.add(value);
		}
		this.hash = hash;
	}
	
	@Override
	public int hashCode() {
		return this.hash;
	}

	@Override
	public boolean equals(Object str) {
		if (str == this) {
			return true;
		} else if(str != null && str.getClass() == myString.class && ((myString)str).hash == this.hash) {
			return true;
		}
		return false;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
