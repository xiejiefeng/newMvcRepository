/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: LogTime.java
 * Author:   baowenzhou
 * Date:     2015年11月04日 下午5:27:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 日志执行时间声明<BR>
 * 
 * 需记录执行时间的方法上添加此annotation
 *
 * @author baowenzhou
 */
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface LogTime {

}
