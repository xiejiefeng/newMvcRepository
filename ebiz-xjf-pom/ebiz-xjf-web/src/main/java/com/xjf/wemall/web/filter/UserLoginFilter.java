/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: GetLoginTicketFilter.java
 * Author:   dongzejun
 * Date:     2015年6月22日 下午2:47:24
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户登入检测Filter
 *
 * @author dongzejun
 * @see javax.servlet.Filter
 */
public class UserLoginFilter implements Filter {

    // 日至记录
    protected static Logger logger = LoggerFactory.getLogger(UserLoginFilter.class);
    /** 跳转错误页 */
    private static final String ERROR_HTM = "/error/error.htm";
    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
     * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
//        String requestURI = httpRequest.getRequestURI();
//        String requestURL = httpRequest.getRequestURL().toString();
//        httpRequest.setAttribute("d", "222222");
        chain.doFilter(request, response);
        
        /***************************************** 获得所有请求参数***********************/
//        HttpServletRequest req= (HttpServletRequest) request;
//        HttpServletResponse res= (HttpServletResponse) response;
//         //获得所有请求参数名
//        Enumeration params = req.getParameterNames();
//        String sql = "";
//        while (params.hasMoreElements()) {
//            //得到参数名
//            String name = params.nextElement().toString();
//            //System.out.println("name===========================" + name + "--");
//            //得到参数对应值
//            String[] value = req.getParameterValues(name);
//            for (int i = 0; i < value.length; i++) {
//                sql = sql + value[i];
//            }
//        }
//        //System.out.println("============================SQL"+sql);
//        //有sql关键字，跳转到error.html
//        if (sqlValidate(sql)) {
//        	res.sendRedirect(ERROR_HTM);
////        	res.sendRedirect("/common/error.ftl");
//        	
//        } else {
//            chain.doFilter(request, response);
//        }
        
        return;
    }
    
    // 防止sql注入
    protected static boolean sqlValidate(String str) {
        str = str.toLowerCase();//统一转为小写
        //过滤掉的sql关键字，可以手动添加
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
                "table|from|grant|use|group_concat|column_name|" +
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

}
