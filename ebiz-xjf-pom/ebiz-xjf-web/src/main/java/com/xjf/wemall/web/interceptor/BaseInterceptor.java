/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BaseInterceptor.java
 * Author:   baowenzhou
 * Date:     2015年09月09日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//import com.saic.wemall.service.sysreference.api.SysRefFieldService;

/**
 * 拦截器基类<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {

	/** 日志 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());
	
	/**参照信息*/
//    @Autowired
//    protected SysRefFieldService sysRefFieldService;
    
    /**
	 * 获取跳转页面
	 * 
	 * @param url
	 * @param query
	 * @param response
	 * @return
	 */
    protected String getRedirectUrl(String url, String query) {
		StringBuilder sb = new StringBuilder();
		sb.append(url);
		if (StringUtils.isNotEmpty(query)) {
			sb.append("?");
			sb.append(query);
		}
		
		return sb.toString();
	}
}
