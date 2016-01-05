/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: EntityUtils.java
 * Author:   v_daisong
 * Date:     2014年11月14日 下午2:40:53
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author v_daisong
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanUtilsExt extends BeanUtils {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BeanUtilsExt.class);

    /**
     * 修改springframe.BeanUtils。 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @param editable
     * @param ignoreProperties
     * @throws BeansException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static void copyProperties(Object source, Object target,
            Class<?> editable, String[] ignoreProperties, String[] nullProperties) throws BeansException {

        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");

        Class<?> actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class ["
                        + target.getClass().getName()
                        + "] not assignable to Editable class ["
                        + editable.getName() + "]");
            }
            actualEditable = editable;
        }
        PropertyDescriptor[] targetPds = BeanUtils
                .getPropertyDescriptors(actualEditable);
        List<String> ignoreList = (ignoreProperties != null) ? Arrays
                .asList(ignoreProperties) : null;

        List<String> nullPropertiesList = (nullProperties != null) ? Arrays
                        .asList(nullProperties) : new ArrayList<String>();        
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null
                    && (ignoreProperties == null || (!ignoreList
                            .contains(targetPd.getName())))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(
                        source.getClass(), targetPd.getName());
                if (sourcePd != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass()
                                .getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        // modify by dais 2014-10-29
                        Method targetReadMethod = targetPd.getReadMethod();
                        if (!Modifier.isPublic(targetReadMethod
                                .getDeclaringClass().getModifiers())) {
                            targetReadMethod.setAccessible(true);
                        }
                        Object targetVal = targetReadMethod.invoke(target);
                        if (targetVal != null && value == null && !nullPropertiesList.contains(targetPd.getName())) {
                            continue;
                        }
                        // end
                        Method writeMethod = targetPd.getWriteMethod();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass()
                                .getModifiers())) {
                            writeMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, value);
                    } catch (Throwable ex) {
                        throw new FatalBeanException(
                                "Could not copy properties from source to target",
                                ex);
                    }
                }
            }
        }
    }

//    /**
//     * 复制字段 功能描述: <br>
//     * 〈功能详细描述〉
//     *
//     * @param source
//     * @param target
//     * @param ignoreProperties
//     *            忽视字段
//     * @throws BeansException
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    public static void copyProperties(Object source, Object target,
//            String[] ignoreProperties) throws BeansException {
//        copyProperties(source, target, null, ignoreProperties, null);
//    }
    
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @param nullProperties 可为空字段
     * @throws BeansException
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyPropertiesEXT(Object source, Object target,
            String[] ignoreProperties, String[] nullProperties) throws BeansException {
        copyProperties(source, target, null, ignoreProperties, nullProperties);
    }
    
    /**
     * 复制字段 功能描述: <br>
     * 
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target)
            throws BeansException {
        copyProperties(source, target, null, null,null);
    }

    /**
     * 给实体设置值 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bean
     * @param propertyName
     */
    public static void setPropertyVal(Object bean, String propertyName,
            Object val) {
        PropertyDescriptor propertyDescriptor = BeanUtils
                .getPropertyDescriptor(bean.getClass(), propertyName);
        if (propertyDescriptor != null) {
            if (propertyDescriptor.getReadMethod() != null) {
                try {
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (!Modifier.isPublic(writeMethod.getDeclaringClass()
                            .getModifiers())) {
                        writeMethod.setAccessible(true);
                    }
                    writeMethod.invoke(bean, val);
                } catch (Throwable ex) {
                    LOGGER.error("反射设置bean失败,{}", ex.getMessage());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getPropertyVal(Object bean, String propertyName,
            Class<T> clazz) {
        PropertyDescriptor propertyDescriptor = getPropertyDescriptor(
                bean.getClass(), propertyName);
        if (propertyDescriptor != null) {
            if (propertyDescriptor.getReadMethod() != null) {
                try {
                    if (clazz != propertyDescriptor.getPropertyType()) {
                        throw new IllegalArgumentException("bean属性与输入的类型不符!");
                    }
                    Method readMethod = propertyDescriptor.getReadMethod();
                    if (!Modifier.isPublic(readMethod.getDeclaringClass()
                            .getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    return (T) readMethod.invoke(bean);
                } catch (Throwable ex) {
                    LOGGER.error("反射获取bean属性失败,{}", ex.getMessage(), ex);
                }
            }
        }
        return null;
    }
    /**
     * 将bean对象转化为查询map  ，过滤null值
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param sdf
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static  Map<String,Object> toQueryParamsMap(Object source,SimpleDateFormat sdf) {
        PropertyDescriptor[] sourcePds = BeanUtils.getPropertyDescriptors(source.getClass());
        Map<String,Object> map = new HashMap<String, Object>();
        if(sourcePds != null){
            for (PropertyDescriptor sourcePd : sourcePds) {
                if (sourcePd != null && sourcePd.getWriteMethod() != null && sourcePd.getReadMethod() != null) {
                    try {
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass()
                                .getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object value = readMethod.invoke(source);
                        if(value == null){
                            continue;
                        }
                        if(value instanceof Date && sdf != null){
                            value = sdf.format(value);
                            //过滤空值,由于前台不过滤空字符串.
                        }else if(value instanceof String && StringUtils.isEmpty(value.toString())){
                            continue;
                        }
                        map.put(sourcePd.getName(), value);
                    } catch (Throwable ex) {
                        throw new FatalBeanException(
                                "Could not copy properties from source to target",
                                ex);
                    }
                }
            }
        }
        return map;
    }
    
    public static Map<String, Object> transBean2Map(Object obj) {  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
                // 过滤class属性  
                if (!key.equals("class")) {// 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    map.put(key, value);  
                }  
            }  
        } catch (Exception e) {  
            LOGGER.error("transBean2Map Error " + e);  
        }  
        return map;  
    }  
    /**
     * 创建一个新的Map
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param key
     * @param value
     * @return
     */
    public static <K,V> Map<K,V> newMap(){
        return new HashMap<K,V>();
    }
    /**
     * 创建一个新的Map 并且给map赋予一个初始化一个k v
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param key
     * @param value
     * @return
     */
    public static <K,V> Map<K,V> newMap(K k,V v){
        Map<K,V> map = newMap();
        map.put(k, v);
        return map;
    }
    /**
     * 创建一个新的Map 并且给map赋予一个初始化一个k v
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param key
     * @param value
     * @return
     */
    public static  Map<String,Object> newQueryMap(String key,Object value){
        Map<String,Object> map = newMap();
        map.put(key, value);
        return map;
    }
    /**
     * 获取List 第一个元素
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param list
     * @return
     */
    public static <T> T getListFirstObject(List<T> list){
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }
    
}
