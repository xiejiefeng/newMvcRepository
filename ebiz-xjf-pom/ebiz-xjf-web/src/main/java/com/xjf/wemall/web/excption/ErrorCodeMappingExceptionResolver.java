/**
 * saic APPLIANCE CHAINS.
 * Copyright (c) 2012-2012 All Rights Reserved.
 */
package com.xjf.wemall.web.excption;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.xjf.wemall.api.exception.BaseException;
//import com.ibm.framework.web.exception.util.WebAppContextUtils;
//import com.meidusa.venus.annotations.ExceptionCode;
//import com.meidusa.venus.exception.CodedException;
//import com.saic.wemall.service.sysreference.api.SysRefFieldService;
import com.xjf.wemall.api.util.WebAppContextUtils;

/**
 * 扩展 spring mvc 统一异常处理类{@link org.springframework.web.servlet.handler.SimpleMappingExceptionResolver} 的功能。在原有基础上增加了以上功能
 * 1. 实现error code到 view names 的映射 2. 根据 error code从web appliaction context 的message中找到对应的frindly message
 */

@SuppressWarnings("deprecation")
public class ErrorCodeMappingExceptionResolver extends SimpleMappingExceptionResolver {
    /**
     * DEFAULT_EXCEPTION_MESSAGE_KEY
     */
    public static final String DEFAULT_EXCEPTION_MESSAGE_KEY = "exception.defaultMessage";
    /**
     * DEFAULT_EXCEPTION_MESSAGE
     */
    public static final String DEFAULT_EXCEPTION_MESSAGE = "";
    /**
     * log
     */
    private static Logger logger = LoggerFactory.getLogger(ErrorCodeMappingExceptionResolver.class);
    /**
     * exceptionMappings
     */
    private Properties exceptionMappings;
    /**
     * errorCodeMappings
     */
    private Properties errorCodeMappings;
    /**
     * defaultErrorView
     */
    private String defaultErrorView;

    /**
     * enable or disable log function
     */
    @SuppressWarnings("unused")
    private boolean logEnable;
    
	/**参照信息*/
//    @Autowired
//    protected SysRefFieldService sysRefFieldService;

    /**
     * 重写父类SimpleMappingExceptionResolver的doResolveException方法
     * 
     * @param request 参考说明
     * @param response 参考说明
     * @param handler 参考说明
     * @param ex 参考说明
     * @return ModelAndView 返回值
     */
    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        // 如果是ajax请求，不处理
        if (null != request.getHeader("x-requested-with")
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            // 在响应头设置session状态
            response.setHeader("sessionstatus", "timeout");
            return null;
        }

        /**
         * 将非BaseException类型的异常封装为BaseException类型 以方便在determineViewName方法中填充friendly的消息message到
         * BaseException.friendlyMessage,这样在页面上就可以取到friendlyMessage
         */
        BaseException bex;
        if (!(ex instanceof BaseException)) {
//            if (CodedException.class.isAssignableFrom(ex.getClass())) {
//                bex = new BaseException(String.valueOf(((CodedException) ex).getErrorCode()), ex.getCause(),
//                        ex.getMessage());
//            } else {
//                ExceptionCode ec = ex.getClass().getAnnotation(ExceptionCode.class);
//                if (null != ec) {
//                    bex = new BaseException(String.valueOf(ec.errorCode()), ex.getCause(), ex.getMessage());
//                } else {
//                    bex = new BaseException("10000", ex, "系统正忙，请稍后再试 ");
//                }
//            }
        	bex = (BaseException) ex;
        } else {
            bex = (BaseException) ex;
        }
        
        logger.error(ex.getMessage());

        // Expose ModelAndView for chosen error view.
        String viewName = determineViewName(bex, request);
        if (viewName != null) {
            // Apply HTTP status code for error views, if specified.
            // Only apply it if we're processing a top-level request.
            Integer statusCode = determineStatusCode(request, viewName);
            if (statusCode != null) {
                applyStatusCodeIfPossible(request, response, statusCode);
            }
            
//            request.setAttribute("tongji", sysRefFieldService.baiduTj());
//            request.setAttribute("crmTel", sysRefFieldService.crmTel());
            
            return getModelAndView(viewName, bex, request);
        } else {
            return null;
        }
    }

    /**
     * 重写SimpleMappingExceptionResolver.determineViewName方法 保留原有的 exception class 到 view names 的映射的逻辑 增加了error code到
     * view names 映射的逻辑
     * 
     * @param ex 参考说明
     * @param request 参考说明
     * @return String 返回值
     */
    protected String determineViewName(Exception ex, HttpServletRequest request) {
        String viewName = null;
        String codeViewName = null;
        String classViewName = null;
        // Check for specific exception mappings.
        if (this.exceptionMappings != null) {
            classViewName = findMatchingViewName(this.exceptionMappings, ex);
        }

        if (this.errorCodeMappings != null) {
            codeViewName = findMatchingViewNameByErrorCode(this.errorCodeMappings, ex);
        }

        if (null != classViewName) {
            viewName = classViewName;
        } else if (null != codeViewName) {
            viewName = codeViewName;
        }

        // Return default error view else, if defined.
        if (viewName == null && this.defaultErrorView != null) {
            if (logger.isDebugEnabled()) {
                logger.debug("Resolving to default view '" + this.defaultErrorView + "' for exception of type ["
                        + ex.getClass().getName() + "]");
            }
            viewName = this.defaultErrorView;
        }

        /**
         * 填充friendly的消息message,以提供页面显示
         */
        this.fillFriendlyExceptionMessage(ex, request);

        return viewName;
    }

    /**
     * 重写父类的方法， 将封装在BaseException里的cause异常提出 ,用个这个cause异常来匹配 exceptionMappings属性里配置的异常类型
     * 
     * protected int getDepth(String exceptionMapping, Exception ex) { Exception cause = ex; if (ex instanceof
     * BaseException) { cause = (Exception) ((BaseException) ex).getMostSpecificCause(); } return
     * super.getDepth(exceptionMapping, cause); }
     */

    /**
     * * 查找配置属性errorCodeMappings, 根据异常的error code查找到view name
     * 
     * @param errorCodeMappings 参考说明
     * @param ex 参考说明
     * @return String 返回值
     */
    protected String findMatchingViewNameByErrorCode(Properties errorCodeMappings, Exception ex) {
        if (!(ex instanceof BaseException)) {
            return null;
        }

        String errorCode = ((BaseException) ex).getCode();
        if (null == errorCode) {
            return null;
        }

        for (Enumeration<?> names = errorCodeMappings.propertyNames(); names.hasMoreElements();) {
            String codes = (String) names.nextElement();
            String viewName = errorCodeMappings.getProperty(codes);

            String[] codeArray = codes.split(",");
            for (String code : codeArray) {
                if (code.trim().equalsIgnoreCase(errorCode.trim())) {
                    return viewName;
                }
            }
        }
        return null;
    }

    /**
     * 填充frindly message到异常对象ex
     * 
     * @param ex 参考说明
     * @param request 参考说明
     */
    protected void fillFriendlyExceptionMessage(Exception ex, HttpServletRequest request) {
        BaseException bex;
        if (ex instanceof BaseException) {
            bex = (BaseException) ex;
        } else {
            bex = new BaseException(ex);
        }

        bex.setFriendlyMessage(bex.getFriendlyMessage());
    }

    /**
     * 从web应用上下文的message 资源中找到异常对应的friendly message 若异常包含code则根据code找message,若不包含code则根据异常类型找message
     * 根据code找message的时候，如果没有找到，则看BaseException构造的时候是否传入了defaultFriendlyMessage参数
     * 如果传入了就用defaultFriendlyMessage作为message，如果没有传入则用全局的key为exception.defaultMessage的message
     * 
     * @param ex 参考说明
     * @param locale 参考说明
     * @param request 参考说明
     * @return String 返回值
     */
    protected String getFriendlyExceptionMessage(BaseException ex, Locale locale, HttpServletRequest request) {
        // 取出web应用上下文
        WebApplicationContext webAppContext = WebAppContextUtils.getWebApplicationContext(request);

        // 取全局缺省异常消息
        String defaultGlobalMessage = webAppContext.getMessage(DEFAULT_EXCEPTION_MESSAGE_KEY, null,
                DEFAULT_EXCEPTION_MESSAGE, locale);
        String message = defaultGlobalMessage;

        String code = ex.getCode();
        // 有异常code
        if (StringUtils.hasText(code)) {
            Object[] args = ex.getMessageArgs();
            String userDefaultMessage = ex.getDefaultFriendlyMessage();
            // defaultFriendlyMessage一个异常时传递的defaultMessage参数

            if (StringUtils.hasText(userDefaultMessage)) {
                message = webAppContext.getMessage(code, args, userDefaultMessage, locale);
            } else {
                message = webAppContext.getMessage(code, args, defaultGlobalMessage, locale);
            }
        } else {
            /**
             * 无异常code,根据异常类名查找匹配的message
             */
//            Throwable tr = ex.getMostSpecificCause();
//            String exClassName = tr.getClass().getName();
//            message = webAppContext.getMessage(exClassName, null, defaultGlobalMessage, locale);
        	String exClassName = ex.getClass().getName();
			message = webAppContext.getMessage(exClassName, null, defaultGlobalMessage, locale);
        }
        return message;
    }

    /**
     * Set the log category for warn logging. The name will be passed to the underlying logger implementation through
     * Commons Logging, getting interpreted as log category according to the logger's configuration.
     * <p>
     * Default is no warn logging. Specify this setting to activate warn logging into a specific category.
     * Alternatively, override the {@link #logException} method for custom logging.
     * 
     * @see org.apache.commons.logging.LogFactory#getLog(String)
     * @see org.apache.log4j.Logger#getLogger(String)
     * @see java.util.logging.Logger#getLogger(String)
     * 
     *      public void setWarnLogCategory(String loggerName) { this.errorLogger = LoggerFactory.getLogger(loggerName);
     *      }
     */

    /**
     * Log the given exception at warn level, provided that warn logging has been activated through the
     * {@link #setWarnLogCategory "warnLogCategory"} property.
     * <p>
     * Calls {@link #buildLogMessage} in order to determine the concrete message to log. Always passes the full
     * exception to the logger.
     * 
     * @param ex the exception that got thrown during handler execution
     * @param request current HTTP request (useful for obtaining metadata)
     * @see #setWarnLogCategory
     * @see #buildLogMessage
     * @see org.apache.commons.logging.Log#warn(Object, Throwable)
     * 
     *      protected void logException(Exception ex, HttpServletRequest request) { if (logEnable && this.errorLogger !=
     *      null && this.errorLogger.isErrorEnabled()) { this.errorLogger.error(buildLogMessage(ex, request)); }
     * 
     *      if(null!= exceptionHandleSetting && exceptionHandleSetting.isMqOutputEnable()){
     *      this.publishExceptionToMQEvent(ex,request); }
     * 
     *      }
     */

    /**
     * 构建完整的异常日志消息,消息格式如下： [Root Exception]: xxxx... [Root Exception Message]: xxxx... [Root Exception throwed on]:
     * xxxx... Line: xxx... [Full Stack trace]: xxxx....
     * 
     * protected String buildLogMessage(Exception ex, HttpServletRequest request) { StringBuilder logMsgSb = new
     * StringBuilder();
     * 
     * logMsgSb.append(CommonExceptionUtils.getMostSpecificCauseMessageInfo(ex)) .append(LINE_SEPARATOR)
     * .append("[Full Stack trace]:").append(LINE_SEPARATOR) .append(CommonExceptionUtils.getExceptionStackTrace(ex));
     * 
     * return logMsgSb.toString(); }
     */

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param logEnable 参考说明
     */
    public void setLogEnable(boolean logEnable) {
        this.logEnable = logEnable;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param errorCodeMappings 参考说明
     */
    public void setErrorCodeMappings(Properties errorCodeMappings) {
        this.errorCodeMappings = errorCodeMappings;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param exceptionMappings 参考说明
     */
    public void setExceptionMappings(Properties exceptionMappings) {
        this.exceptionMappings = exceptionMappings;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param defaultErrorView 参考说明
     */
    public void setDefaultErrorView(String defaultErrorView) {
        this.defaultErrorView = defaultErrorView;
    }
}