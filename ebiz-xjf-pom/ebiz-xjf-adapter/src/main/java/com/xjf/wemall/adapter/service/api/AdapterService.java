/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AdapterService.java
 * Author:   wanglijun
 * Date:     2014年8月13日 下午11:22:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.service.api;

/**
 * 接口适配器服务定义 <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since 接口/模块版本] （可选）
 */
public interface AdapterService {
    
    /***
     * 
     * 功能描述: 获取接口数据无参数<br>
     * 〈功能详细描述〉
     *
     * @param clazz
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public <T> T getData(Class<T> clazz);
    
    /***
     * 
     * 功能描述: 获取接口数据有参数<br>
     * 〈功能详细描述〉
     *
     * @param clazz
     * @param requestStr
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public <T> T getData(Class<T> clazz, String requestStr);
}
