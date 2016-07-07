/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AnnotationVo.java
 * Author:   baowenzhou
 * Date:     2016年3月16日 下午14:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.annotation;

import java.lang.annotation.Annotation;

/**
 * 登录参数<br>
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AnnotationVo {

	// 参数值
	private Object paramValue;

	// 注解类
	private Annotation annotation;

	public Object getParamValue() {
		return paramValue;
	}

	public void setParamValue(Object paramValue) {
		this.paramValue = paramValue;
	}

	public Annotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}

}
