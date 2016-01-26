/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BMSConnector.java
 * Author:   wanglijun
 * Date:     2014年8月11日 下午10:07:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.connector.impl.alibabamap;

import com.xjf.wemall.adapter.connector.impl.AbstractConnector;
import com.xjf.wemall.adapter.http.api.AdapterHttpHandler;
import com.xjf.wemall.adapter.http.entity.AdapterHttpResponse;
import com.xjf.wemall.adapter.http.entity.AdatperHttpRequest;
import com.xjf.wemall.api.constant.ContentType;
import com.xjf.wemall.api.exception.AdapterException;

/**
 * BMS接口连接类 <br> 
 * 用户创建BMS连接 
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapConnector extends AbstractConnector {
    
    /**HTTP 连接器*/
    private AdapterHttpHandler adapterHttpHandler;
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Object sendRequestResponse(Object object) throws AdapterException {
    	object = (object==null)?"":object;
    	logger.info("address:{}", this.getApiAddress());
        logger.info("request:{}", object.toString());
        AdatperHttpRequest request = new AdatperHttpRequest();
        request.setAddress(this.getApiAddress());
        request.setQueryString(object.toString());
        request.setContentType(ContentType.JSON_UTF8);
        AdapterHttpResponse response = adapterHttpHandler.execute(request);
        logger.info("response:{}", response.getStringResult());
        return response.getStringResult();
    }

    /**
     * @return the adapterHttpHandler
     */
    public AdapterHttpHandler getAdapterHttpHandler() {
        return adapterHttpHandler;
    }

    /**
     * @param adapterHttpHandler the adapterHttpHandler to set
     */
    public void setAdapterHttpHandler(AdapterHttpHandler adapterHttpHandler) {
        this.adapterHttpHandler = adapterHttpHandler;
    }

}
