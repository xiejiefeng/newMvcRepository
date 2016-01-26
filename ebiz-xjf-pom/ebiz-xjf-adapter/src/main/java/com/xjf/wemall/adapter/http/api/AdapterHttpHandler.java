/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AdapterHttpClient.java
 * Author:   wanglijun
 * Date:     2014年8月11日 下午10:21:50
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.http.api;

import com.xjf.wemall.adapter.http.entity.AdapterHttpResponse;
import com.xjf.wemall.adapter.http.entity.AdatperHttpRequest;


/**
 *  HTTPClient连接适配器  <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface AdapterHttpHandler {
 
    /***
    * 
    * 功能描述: HTTPRequest请求
    * 〈功能详细描述〉
    *
    * @param request
    * @return
    * @see [相关类/方法](可选)
    * @since [产品/模块版本](可选)
    */
    public AdapterHttpResponse execute(AdatperHttpRequest request); 
    
    /***
     * 
     * 功能描述: HTTPRequest请求
     * 〈功能详细描述〉
     *
     * @param url
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
     public String get(String url); 
}
