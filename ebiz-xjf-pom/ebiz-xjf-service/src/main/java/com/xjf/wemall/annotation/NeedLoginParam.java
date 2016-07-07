/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: NeedLoginParam.java
 * Author:   baowenzhou
 * Date:     2016年03月10日 下午5:27:08
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
 * 必须登录说明声明<BR>
 * 
 * 需校验的方法上添加此annotation，支持Ajax提交<BR>
 * 注意：
 * Ajax判断时，需指定回调页面;
 * <BR>
 * 必须登录渠道、忽略登录渠道都为空时，全渠道校验<BR>
 * 必须登录渠道有时，判断当前渠道是在此中，在则校验，不在则不校验<BR>
 * 必须登录渠道空时，忽略登录渠道有时，判断当前渠道是在此中，在则不校验，不在则校验<BR>
 *
 * @author baowenzhou
 */
@Target({PARAMETER})
@Retention(RUNTIME)
public @interface NeedLoginParam {
	
	/**
	 * 必须登录渠道<br>
	 */
	String[] checkParam() default {};
	/**
	 * 忽略登录渠道<br>
	 */
	String[] ignoreParam() default {};
	
}
