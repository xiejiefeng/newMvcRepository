/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CacheErrorCode.java
 * Author:   wanglijun
 * Date:     2014年8月1日 下午3:31:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant.errorCode;

import com.xjf.wemall.api.constant.api.Code;

/**
 * 缓存错误代码定义<br> 
 * 异常错误代码有：EC00001,缓存的KEY不 能为空
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum CacheErrorCode implements Code<String>{
    KEY_IS_NULL("C000001"),
    TARGET_NOTFOUND("C000002"),
    PARAMETER_NOTFOND("C000003"),
    TYPE_ERROR("C000004"),
    CACHE_REFERENCE_NULL("C000005");
    
    /**错误代码*/
    private String code;
    
    /***
     * 
     * @param code 错误（异常）代码
     */
    private CacheErrorCode(String code){
        this.code=code;
    }
    
    /**
     * {@inheritDoc} 错误（异常）代码
     */
    @Override
    public String code() {
        return this.code;
    }
    
}
