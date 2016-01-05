/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: XMLUtil.java
 * Author:   wanglijun
 * Date:     2014年8月14日 上午9:50:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.xjf.wemall.api.constant.Charset;
//import com.saic.wemall.api.constant.errorCode.AdapterErrorCode;
//import com.saic.wemall.api.exception.AdapterException;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XML工具 <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class XMLUtil {
    /***
     * 
     * 功能描述: 构建文档<br>
     * 〈功能详细描述〉
     *
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Document getDocument(Object obj){
        String str = obj != null ? obj.toString() : null;
        Document document = null;
        try {
            document =DocumentHelper.parseText(str);
        } catch (DocumentException e) {
//            throw new AdapterException(AdapterErrorCode.XML_REDER, e);
        }
        return document;
    }
    
    
    /**
     *  将传入xml文本转换成Java对象
     * @Title: toBean 
     * @param xmlStr
     * @param cls  xml对应的class类
     * @return T   xml对应的class类的实例对象
     * 
     * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
     */
    @SuppressWarnings("unchecked")
    public static <T> T  toBean(String xmlStr,Class<T> cls){
        
        XStream xstream=new XStream(new DomDriver(Charset.UFT8.code()));
        xstream.processAnnotations(cls);
        T obj=(T) xstream.fromXML(xmlStr);
        return obj;         
    } 
    
    /***
     * 
     * 功能描述: 把对象解析成XML文件
     * 〈功能详细描述〉
     * @param obj
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String toXml(Object obj){
        XStream xstream=new XStream(new DomDriver(Charset.UFT8.code()));
        xstream.processAnnotations(obj.getClass()); //通过注解方式的，一定要有这句话
        return xstream.toXML(obj);
    }

}
