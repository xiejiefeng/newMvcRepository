/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CookieUtil.java
 * Author:   wanglijun
 * Date:     2014年8月29日 上午9:52:45
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie 工具类<br>
 * 〈功能详细描述〉
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CookieUtil {
	
//	/**日志类*/
//	private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
    
    /**OPENID*/
    public static final String OPENID = "wemall_openid";
    
    /**OPEN_TYPE*/
    public static final String OPEN_TYPE = "wemall_opentype";
    
    /**车享ID*/
    public static final String CXID = "wemall_cxid";
    
    /**用户标识*/
    public static final String USER_KEY = "wemall_userkey";
    
    /**jsessionid*/
    public static final String JSESSIONID = "wemall_jsessionid=";
    
    /**location 经度*/
    public static final String LOCATION_LONGITUDE = "wemall_locationlongitude";
    
    /**location 纬度*/
    public static final String LOCATION_LATITUDE = "wemall_locationlatitude";
    
    /**SHOPPINGCATID*/
    public static final String SHOPPINGCARTID = "wemall_shoppingcartid";
    
    /**跳转页面*/
    public static final String TARGET_URL = "wemall_targeturl";
    
    /**OPENID 有效时间*/
    public static final int OPENID_MAXAGE = 365*24*3600;
    
//    /** 二进制的redis. */
//	@Autowired
//	@Qualifier("springBinaryRedisClient")
//	private IBinaryRedisClient springBinaryRedisClient;
	
//	private static CookieUtil cookieUtil;
	
//	public void setSpringBinaryRedisClient(IBinaryRedisClient springBinaryRedisClient){
//		this.springBinaryRedisClient = springBinaryRedisClient;
//	}
	
    public void init()
    {
//		cookieUtil = this;
//		cookieUtil.springBinaryRedisClient = this.springBinaryRedisClient;
    }
    
    /**
     * 设置cookie
     * 
     * @param response
     * @param name cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期 以秒为单位
     */
    public static void addCookieMaxAge(HttpServletResponse response, String name, String value) {
    	CookieUtil.addCookie(null, response, name, value, OPENID_MAXAGE);
    }

    /**
     * 设置cookie
     * 
     * @param response
     * @param name cookie名字
     * @param value cookie值
     * @param maxAge cookie生命周期 以秒为单位
     */
    public static void addCookie(HttpServletRequest request, HttpServletResponse response, 
    		String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if (maxAge > 0)
            cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
        
//        String sessionId = request.getSession().getId();
//        
//        SessionObject session = cookieUtil.springBinaryRedisClient.get(
//        		AbstractService.USERINFO_SESSION_KEY + sessionId, 
//        		new TypeReference<SessionObject>() {});
//        
//        if (session == null) {
//        	session = new SessionObject();
//        }
//        
//        switch (name) {
//        case CookieUtil.OPENID:
//        	session.setOpenId(value);
//        	break;
//        case CookieUtil.OPEN_TYPE:
//        	session.setOpenType(value);
//        	break;
//        case CookieUtil.LOCATION_LONGITUDE:
//        	session.setLongitude(value);
//        	break;
//        case CookieUtil.LOCATION_LATITUDE:
//        	session.setLatitude(value);
//        	break;
//        }
//        
//        cookieUtil.springBinaryRedisClient.setex(
//        		AbstractService.USERINFO_SESSION_KEY + sessionId, 
//        		session, TimeToLive.DAY.code());
//        logger.info("session:set to redis:{}", sessionId);
    }

    /***
     * 
     * 功能描述:根据Cookie Name 获取<br>
     * 〈功能详细描述〉
     * 
     * @param request
     * @param name
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCookieByName(HttpServletRequest request, String name) {
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            if (cookie != null) {
            	return cookie.getValue();
            }
        }
        
        // 原本就删除
//        //String sessionId = request.getSession().getId();
//        String requestUri = request.getRequestURI();
//        int idx = requestUri.indexOf(JSESSIONID);
//        if (idx == -1) {
//        	return null;
//        }
//        String sessionId = requestUri.substring(idx+JSESSIONID.length());
//        
//        SessionObject session = cookieUtil.springBinaryRedisClient.get(
//        		AbstractService.USERINFO_SESSION_KEY + sessionId, 
//        		new TypeReference<SessionObject>() {});
//        
//        logger.info("session:get from redis:{}", sessionId);
//        
//        if (session != null) {
//        	switch (name) {
//            case CookieUtil.OPENID:
//            	return session.getOpenId();
//            case CookieUtil.OPEN_TYPE:
//            	return session.getOpenType();
//            case CookieUtil.LOCATION_LONGITUDE:
//            	return session.getLongitude();
//            case CookieUtil.LOCATION_LATITUDE:
//            	return session.getLatitude();
//            }
//        }
        
        return null;
    }

    /***
     * 
     * 功能描述: 读取cookie数据<br>
     * 〈功能详细描述〉
     * 
     * @param request
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }
}
