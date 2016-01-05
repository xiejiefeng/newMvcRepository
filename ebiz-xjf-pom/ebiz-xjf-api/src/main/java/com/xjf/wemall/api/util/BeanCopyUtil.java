/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: BeanCopyUtil.java
 * Author:   tantun
 * Date:     2015年3月13日 上午11:33:23
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;

import com.xjf.wemall.api.exception.BaseException;

/**
 * bean属性复制功能，如果有异常会返回具体是哪个属性的setter方法出现异常
 *
 * @author tantun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanCopyUtil extends BeanUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCopyUtil.class);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyProps(Object source, Object target) {
        copyProps(source, target, null);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @param igonre
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyProps(Object source, Object target, String[] igonre) {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        Object methodName = null;
        // Object targetValue=null;
        // 需复制字段
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {

                try {
                    PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                    if (igonre != null) {
                        boolean jump = false;
                        // 忽略字段
                        for (int i = 0; i < igonre.length; i++) {
                            if (igonre[i] == null) {// 判空
                                continue;
                            }
                            if (targetPd.getName().equals(igonre[i])) {// 是否为忽略字段
                                LOGGER.info(targetPd.getName());
                                jump = true;
                            }
                        }
                        if (jump) {// 忽略标志
                            continue;
                        }
                    }
                    if (sourcePd != null && sourcePd.getReadMethod() != null) {// 判空
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // Check whether the value is empty, only copy the properties which are not empty
                        // targetValue=value;
                        if (value != null) {// 判空
                            Method writeMethod = targetPd.getWriteMethod();
                            methodName = writeMethod.getName();
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }

                    }
                } catch (BeansException e) {
                    e.printStackTrace();
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg);
                    throw new BaseException("beanCopyException", errMsg, e.getCause());

                } catch (SecurityException e) {
                    e.printStackTrace();
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg);
                    throw new BaseException("beanCopyException", errMsg, e.getCause());

                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg);
                    throw new BaseException("beanCopyException", errMsg, e.getCause());

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg);
                    throw new BaseException("beanCopyException", errMsg, e.getCause());

                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg);
                    throw new BaseException("beanCopyException", errMsg, e.getCause());

                }

            }
        }
    }

}
