/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: InvaildParamAspect.java
 * Author:   baowenzhou
 * Date:     2016年03月10日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.web.controller.BaseController;

/**
 * 非法字符校验<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class BaseAspect extends BaseController {

	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public String checkUrl(ProceedingJoinPoint joinPoint) throws Throwable {
		return this.check(joinPoint, String.class);
	}

	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public AjaxObject checkAjax(ProceedingJoinPoint joinPoint) throws Throwable {
		return this.check(joinPoint, AjaxObject.class);
	}
	
	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@SuppressWarnings("unchecked")
	protected <T> T check(ProceedingJoinPoint joinPoint, Class<T> clazz) throws Throwable {
		return (T) joinPoint.proceed();
	}
}