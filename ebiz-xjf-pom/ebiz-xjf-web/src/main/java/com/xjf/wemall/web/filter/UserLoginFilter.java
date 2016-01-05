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
        return;
    }

    /*
     * (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

}
