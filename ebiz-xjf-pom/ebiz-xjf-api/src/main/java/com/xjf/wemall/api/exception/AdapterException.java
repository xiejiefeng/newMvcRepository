/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AdapterException.java
 * Author:   baowenzhou
 * Date:     2015年09月28日 下午4:14:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.exception;

import com.xjf.wemall.api.constant.errorCode.AdapterErrorCode;
import com.xjf.wemall.api.exception.BaseException;

/**
 * 接口异常处理<br> 
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AdapterException extends BaseException{

    /**
     */
    private static final long serialVersionUID = 6892794888177533754L;
    
    /**
     * 默认构造函数
     */
    public AdapterException() {
         super();
    }
    /**
     * 构造函数
     * 
     * @param errorCode 错误代码
     */
    public AdapterException(AdapterErrorCode errorCode) {
        super(errorCode.code());
    }
    
    /**
     * 构造函数
     * 
     * @param errorCode 错误代码
     * @param e
     */
    public AdapterException(AdapterErrorCode errorCode, Throwable e){
        super(errorCode.code(), e);
    }
     
}
