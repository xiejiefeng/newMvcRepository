/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: CookieParam.java
 * Author:   baowenzhou
 * Date:     2016年03月22日 下午5:27:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.annotation;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Cookie对象参数声明<BR>
 * 
 * 需要CookieObject的方法参数上添加此annotation<BR>
 * @see com.saic.wemall.api.entity.common.CookieObject
 *
 * @author baowenzhou
 */
@Target({PARAMETER})
@Retention(RUNTIME)
public @interface CookieParam {
	
}
