/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BeanUtil.java
 * Author:   wanglijun
 * Date:     2014年9月2日 上午9:21:27
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.saic.wemall.api.constant.errorCode.ServiceErrorCode;
//import com.saic.wemall.api.exception.ServiceException;


/**
 * BeanUtil<br> 
 * 用于Bean Copy
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanUtil {
    /**日志*/
    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);
    /***
     * 
     * 功能描述: 复制Bean的属性  <br>
     * 〈功能详细描述〉
     *
     * @param target
     * @param source
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copy(Object target, Object source){ 
        try {
            BeanUtils.copyProperties(target,source);
        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(),e);
            //throw new ServiceException(ServiceErrorCode.BEAN_COPY, e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(),e);
            //throw new ServiceException(ServiceErrorCode.BEAN_COPY, e);
        }
    }
}
