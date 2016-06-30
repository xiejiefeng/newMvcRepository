/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: LogInOut.java
 * Author:   baowenzhou
 * Date:     2016年03月11日 下午5:27:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 入出参声明<BR>
 * 
 * 需记录参数、返回值的方法或类上添加此annotation
 *
 * @author baowenzhou
 */
@Target({METHOD, FIELD, TYPE})
@Retention(RUNTIME)
public @interface LogInOut {
	/**
	 * 记录参数，默认true
	 */
	boolean in() default true;
	
	/**
	 * 记录返回值，默认true
	 */
	boolean out() default true;
}
