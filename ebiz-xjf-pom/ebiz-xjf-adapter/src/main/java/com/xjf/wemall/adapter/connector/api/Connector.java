/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Connector.java
 * Author:   wanglijun
 * Date:     2014年8月11日 下午10:03:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.connector.api;

import com.xjf.wemall.api.exception.AdapterException;

/**
 *  接口连接声明类 <br> 
 *  接口连接声明类
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface Connector {
    /***
     * 
     * 功能描述: 发送请求并收响应对象
     * 〈功能详细描述〉
     *
     * @param object 请求对象
     * @return   响应对象 
     * @throws AdapterException 接口适器异常
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Object sendRequestResponse(Object object) throws AdapterException;
}
