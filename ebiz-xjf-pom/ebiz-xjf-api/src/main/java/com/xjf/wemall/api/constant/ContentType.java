/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ContentType.java
 * Author:   baowenzhou
 * Date:     2015年09月28日 上午11:33:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant;

import com.xjf.wemall.api.constant.api.Code;

/**
 * HTTP 请求头信息<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum ContentType implements Code<String> {
    SOAP_XML_UTF8("application/soap+xml;charset=UTF-8"),
    DEFAULT_FORM("application/x-www-form-urlencoded"),
    SOAP_XML_GBK("application/soap+xml;charset=GBK"),
    JSON_UTF8("application/json;charset=UTF-8");

    /**请求头类型*/
    private String code;
    
    private ContentType(String code){
        this.code=code;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String code() {
        return this.code;
    }
}
