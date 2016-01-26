/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ServiceErrorCode.java
 * Author:   baowenzhou
 * Date:     2015年09月28日 下午5:25:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant.errorCode;

import com.xjf.wemall.api.constant.api.Code;

/**
 * 接口异常代码定义<br> 
 * 定义接口连接错误、连接成功、
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ServiceErrorCode implements Code<String>{
    HTTP_ENCODING("S000001"),
    HTTP_IO("S000002"),
    HTTP_SECURITY("S000003"),
    URL_ENCODE("S000004"),
    BEAN_COPY("S000005");
    
    /**异常CODE*/
    private String code;

    /***
     * 默认构造函数
     * @param code 代码
     */
    private ServiceErrorCode(String code){
        this.code = code;
    }
    
    /**
     * {@inheritDoc}
     */
    public String code() {
        return this.code;
    }
    
}
