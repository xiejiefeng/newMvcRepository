/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Charset.java
 * Author:   wanglijun
 * Date:     2014年8月11日 下午10:29:40
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant;

import com.xjf.wemall.api.constant.api.Code;

/**
 * 编码类<br> 
 * UFT-8
 * GBK
 * GB2312
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum Charset implements Code<String>{
    /**编码为UTF-8*/
    UFT8("UTF-8"),
    GBK("GBK")
    ;
    /**编码值*/
    private String code;
    
     /**默认构造编码值*/
    private Charset(String code) {
        this.code = code;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String code() {
       return this.code;
    }
    
}
