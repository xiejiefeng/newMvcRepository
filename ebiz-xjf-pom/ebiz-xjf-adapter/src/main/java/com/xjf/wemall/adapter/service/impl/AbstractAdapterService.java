/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AbstractAdapterService.java
 * Author:   wanglijun
 * Date:     2014年8月13日 下午11:28:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjf.wemall.adapter.connector.api.Connector;
import com.xjf.wemall.adapter.service.api.AdapterService;
import com.xjf.wemall.api.util.JSONParser;

/**
 *  接口适配服务抽像类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class AbstractAdapterService implements AdapterService{
    /**日志类*/
    protected final Logger logger = LoggerFactory.getLogger(super.getClass());
    /**连接器*/
    private Connector connector;

    /***
     * default
     */
    public AbstractAdapterService() {
        super();
    }
    
    /**
     * @return  接口连接器
     */
    public Connector getConnector() {
        return connector;
    }
    /**
     * @param connector 接口连接器
     */
    public void setConnector(Connector connector) {
        this.connector = connector;
    }
    
    /**
     * {@inheritDoc}
     */
    public <T> T getData(Class<T> clazz){
    	return this.getData(clazz, null);
    }
    
    /**
     * {@inheritDoc}
     */
    public <T> T getData(Class<T> clazz, String requestStr){
    	Connector connector = this.getConnector();
    	long connectorStartTime = System.currentTimeMillis();
    	//调用网站接口并返回json报文
    	String jsonStr = (String)connector.sendRequestResponse(requestStr);
    	long callCostTime = System.currentTimeMillis()-connectorStartTime;
    	logger.info("External system processing time:{}", callCostTime);
     
    	return JSONParser.toStringObject(jsonStr,clazz);
    }
}
