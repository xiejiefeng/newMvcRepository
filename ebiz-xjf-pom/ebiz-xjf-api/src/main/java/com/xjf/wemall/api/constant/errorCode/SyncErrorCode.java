/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: SyncErrorCode.java
 * Author:   baowenzhou
 * Date:     2015年11月09日 下午5:25:43
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant.errorCode;

import com.xjf.wemall.api.constant.api.Code;

/**
 * 同步异常代码定义<br> 
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum SyncErrorCode implements Code<String>{
	DEFAULT_ERROR(""),
	CAR_ERROR("CAR_SYC_ERROR"),
	STORE_ERROR("STORE_SYC_ERROR"),
	ARTIFICER_ERROR("ARTIFICER_SYC_ERROR"),
	SERVICE_ERROR("SERVICE_SYC_ERROR"),
	SKU_ERROR("SKU_SYC_ERROR");
    
    /**异常CODE*/
    private String code;

    /***
     * 默认构造函数
     * @param code 代码
     */
    private SyncErrorCode(String code){
        this.code = code;
    }
    
    /**
     * {@inheritDoc}
     */
    public String code() {
        return this.code;
    }
    
}
