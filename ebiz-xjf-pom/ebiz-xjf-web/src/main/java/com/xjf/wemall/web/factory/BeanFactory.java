/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BeanFactory.java
 * Author:   baowenzhou
 * Date:     2015年08月05日 下午3:11:55
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Bean获取
 *
 * @author baowenzhou
 */
@Component
public class BeanFactory implements ApplicationContextAware {

    // Spring的ApplicationContext
    private static ApplicationContext context;

    // 日志
    private static final Logger logger = LoggerFactory.getLogger(BeanFactory.class);

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
    	BeanFactory.context = context;
    }

    /**
     * 根据Name定义，获取指定的SpringBean对象
     * 
     * @param name
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T getBean(String name, Class<T> clazz) {
        return (T) getBean(name);
    }

    /**
     * 根据Class类型，获取指定的SpringBean对象
     *
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (Exception e) {
        	logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * 根据Name定义，获取指定的SpringBean对象
     *
     * @param name
     * @param clazz
     * @return
     */
    public static Object getBean(String name) {
        if (context.containsBean(name)) {
            return context.getBean(name);
        }
        return null;
    }
    
    /**
     * 获取当期Context容器中的全部SpringBean的名称列表
     *
     * @param clazz
     * @return
     */
    public static <T> String[] getBeanNames(Class<T> clazz) {
        return context.getBeanNamesForType(clazz);
    }

}
