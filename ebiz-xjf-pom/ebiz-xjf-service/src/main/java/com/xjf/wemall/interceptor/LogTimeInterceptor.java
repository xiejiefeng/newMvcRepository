/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LogTimeInterceptor.java
 * Author:   baowenzhou
 * Date:     2015年11月04日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

/**
 * 时间记录拦截器<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LogTimeInterceptor extends BaseMethodInterceptor {
	
//	/** 日志记录服务 */
//	@Autowired
//	private LogService logService;
//	
//	/** Venus服务 */
//	@Autowired
//	private VenusService venusService;
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		Method method = invocation.getMethod();
		String methodName = method.getName();
		String className = method.getDeclaringClass().getName();

//		if (method.isAnnotationPresent(LogTime.class)) {
//			long startTime = logService.logStartTime();
			
			Object ret = invocation.proceed();
			
//			logService.logEndTime(startTime, className, methodName, invocation.getArguments());
//			
			return ret;
//		} else {
//			return invocation.proceed();
//		}
	}

}
