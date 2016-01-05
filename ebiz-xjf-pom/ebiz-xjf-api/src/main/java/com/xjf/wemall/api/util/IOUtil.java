/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: IOUtil.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午9:37:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.xjf.wemall.api.constant.errorCode.AdapterErrorCode;
//import com.xjf.wemall.api.exception.AdapterException;

/**
 * IO处理工具类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class IOUtil {
    
    /**
     * 日志
     * */
    protected static final Logger logger=LoggerFactory.getLogger(IOUtil.class);
    /***
     * 
     * 功能描述: 关闭InputStream流<br>
     * 〈功能详细描述〉
     *
     * @param input  输入流
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void close(InputStream input){
        if(input!=null){
            try {
                input.close();
            } catch (IOException e) {
              logger.error(e.getMessage(),e);
            }
        }
    }
    /***
     * 
     * 功能描述: 根据文件读取XML DOM对象<br>
     * 〈功能详细描述〉
     *
     * @param filePath
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static Document getDocument(String filePath){
        SAXReader reader = new SAXReader();
        Document document=null;
        try {
            document = reader.read(new File(filePath));
        } catch (DocumentException e) {
//            throw new AdapterException(AdapterErrorCode.XML_REDER, e);
        }
        return document;
    }
}
