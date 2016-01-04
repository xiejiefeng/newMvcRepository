/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BaseMethodInterceptor.java
 * Author:   baowenzhou
 * Date:     2015年11月04日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 方法拦截器基类<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class BaseMethodInterceptor implements MethodInterceptor {
	
	/**日志类*/
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());
}
