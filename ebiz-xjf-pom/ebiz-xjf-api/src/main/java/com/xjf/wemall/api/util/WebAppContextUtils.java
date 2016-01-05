package com.xjf.wemall.api.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

public class WebAppContextUtils {
	/**
     * Request attribute to hold the current web application context for RequestContext usage. By default, the
     * DispatcherServlet's context (or the root context as fallback) is exposed.
     */
    public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = RequestContext.class.getName() + ".CONTEXT";

    /**
     * 
     * 功能描述: <br>
     * 获取WebApplicationContext
     * 
     * @param request 参考说明
     * @return WebApplicationContext 返回值
     */
    public static WebApplicationContext getWebApplicationContext(HttpServletRequest request) {
        WebApplicationContext webApplicationContext = (WebApplicationContext) request
                .getAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        if (webApplicationContext == null) {
            webApplicationContext = RequestContextUtils.getWebApplicationContext(request, request.getSession()
                    .getServletContext());
        }
        return webApplicationContext;
    }

    /**
     * 
     * 功能描述: <br>
     * 获取Locale
     * 
     * @param request 参考说明
     * @return Locale 返回值
     */
    public static Locale getRequestLocale(HttpServletRequest request) {
        // Determine locale to use for this RequestContext.
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        Locale tempLocale = null;
        if (localeResolver != null) {
            // Try LocaleResolver (we're within a DispatcherServlet request).
            tempLocale = localeResolver.resolveLocale(request);
        }
        return tempLocale;
    }

    /**
     * 私有的构造函数WebAppContextUtils
     */
    private WebAppContextUtils() {

    }
}
