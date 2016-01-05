/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ReflectionUtil.java
 * Author:   wanglijun
 * Date:     2014年8月14日 上午12:27:21
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.lang.reflect.Constructor;

/**
 *  接口适配器反射类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ReflectionUtil {
    /**
     * 新建实例 
     * @param className 类名
     * @param args      构造函数的参数
     * @return 新建的实例
     * @throws Exception
     */
    public static final Object newInstance(String className, Object[] args)
            throws Exception {
        Class<?> newoneClass = Class.forName(className);
        Class<?>[] argsClass = new Class[args.length];
        for (int i = 0, j = args.length; i < j; i++) {
            argsClass[i] = (args[i]==null?"":args[i]).getClass();
        }
        Constructor<?> cons = newoneClass.getConstructor(argsClass);
        return cons.newInstance(args);
    }
}   
