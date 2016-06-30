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

/**
 * 9.2.1定义泛型接口、类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Apple<T> {
	private T info;
	public Apple(T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public static void main(String[] arg) {
		// java7 泛型的菱形语法
		Apple<String> array = new Apple<>("苹果");
		Apple<Double> array1 = new Apple<>(5.61);
		
		System.out.println(array.getInfo());
		System.out.println(array1.getInfo());
	}

}
