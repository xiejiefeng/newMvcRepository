/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LogVenusInterceptor.java
 * Author:   baowenzhou
 * Date:     2016年03月11日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

import com.xjf.wemall.annotation.LogInOut;
import com.xjf.wemall.api.util.JSONParser;

/**
 * Venus记录拦截器<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LogInOutInterceptor extends BaseMethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Method method = invocation.getMethod();
		String methodName = method.getName();
		Class<?> clazz = method.getDeclaringClass();
		String className = clazz.getName();

		// 获取标签类
		LogInOut logInOut = method.getAnnotation(LogInOut.class);
		if (logInOut == null) {
			// 类上的标签
			logInOut = method.getDeclaringClass().getAnnotation(LogInOut.class);
		}

		if (logInOut == null) {
			return invocation.proceed();
		}

		if (logInOut.in()) {
			logger.info("class:{}, method:{}, param:{}", className, methodName,
					JSONParser.toJSONString(invocation.getArguments()));
		}

		Object ret = invocation.proceed();

		if (logInOut.out()) {
			logger.info("class:{}, method:{}, return:{}", className, methodName,
					JSONParser.toJSONString(ret));
		}

		return ret;
	}

}
