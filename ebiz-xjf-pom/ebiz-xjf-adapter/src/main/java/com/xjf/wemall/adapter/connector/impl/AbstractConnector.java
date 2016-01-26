/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AbstractConnector.java
 * Author:   wanglijun
 * Date:     2014年8月11日 下午10:09:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.connector.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.xjf.wemall.adapter.connector.api.Connector;

/**
 * 接口抽像连接类<br>
 * 接口抽像连接类
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class AbstractConnector implements Connector {
    /** 日志类 */
    protected final Logger logger = LoggerFactory.getLogger(super.getClass());
    /**连接地址*/
    protected  String host;
    /**连接地址*/
    protected  String address;
    /**连接方法*/
    protected  String method;
    
    /**
     * @return 连接地址
     */
    public String getHost() {
        return host;
    }
    /**
     * @param host 连接地址
     */
    public void setHost(String host) {
        this.host = host;
    }
	/**
     * @return 连接地址
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param addresss 连接地址
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * @return 连接方法
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method 连接方法
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	
	/**
	 * 获取接口地址
	 * @return
	 */
	protected String getApiAddress() {
		if (!StringUtils.isEmpty(host) 
				&& !StringUtils.isEmpty(address) 
				&& !StringUtils.isEmpty(method)) {
			return host+address+method;
		} else {
			return "";
		}
	}
}
