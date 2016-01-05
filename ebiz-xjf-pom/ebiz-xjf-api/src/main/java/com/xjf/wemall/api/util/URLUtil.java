/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: URLUtil.java
 * Author:   wanglijun
 * Date:     2014年8月26日 上午11:03:30
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang3.CharEncoding;

//import com.saic.wemall.api.constant.errorCode.ServiceErrorCode;
//import com.saic.wemall.api.exception.ServiceException;

/**
 * URL工具<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final  class URLUtil {
    /***
     * 
     * 功能描述: URL参数编码<br>
     * 〈功能详细描述〉
     *
     * @param param 参数
     * @return 返回已编码参数
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static  String encode(String param){
        try {
            return URLEncoder.encode(param, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
//             throw new ServiceException(ServiceErrorCode.URL_ENCODE, e);
        	return null;
        }
    }
    
    /***
     * 
     * 功能描述: URL参数解码<br>
     * 〈功能详细描述〉
     *
     * @param param 参数
     * @return 返回已编码参数
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static  String decode(String param){
        try {
            return URLDecoder.decode(param, CharEncoding.UTF_8);
        } catch (UnsupportedEncodingException e) {
//             throw new ServiceException(ServiceErrorCode.URL_ENCODE, e);
        	return null;
        }
    }
}
