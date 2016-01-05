/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: SQLUtil.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午2:02:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

/**
 * SQL 工具类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class SQLUtil {
    /**
     * 功能描述: 生成SQLID<br>
     * 〈功能详细描述〉
     *
     * @param className 全路径className
     * @param id 
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public  static String getSQLId(String className,String id){
        StringBuilder sb=new StringBuilder(className);
        sb.append(".");
        sb.append(id);
        return sb.toString();
    }
}
