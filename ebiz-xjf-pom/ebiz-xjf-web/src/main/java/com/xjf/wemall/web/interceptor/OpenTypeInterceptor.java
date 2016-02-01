/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: OpenIdInterceptor.java
 * Author:   baowenzhou
 * Date:     2015年07月01日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.interceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.Base64Operate;
import com.xjf.wemall.web.util.CookieUtil;
import com.xjf.wemall.api.entity.user.PointVo;
import com.xjf.wemall.api.entity.user.CustomCxbInfoVo;
//import com.xjf.wemall.api.entity.store.AreaInfoVo;
//import com.xjf.wemall.service.store.api.StoreService;
//import com.xjf.wemall.service.user.api.UserService;
//import com.xjf.wemall.service.wechat.api.UserInfoService;

/**
 * OpenId判断<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OpenTypeInterceptor extends BaseInterceptor {
	
	private static final String USER_AGENT = "User-Agent";
	
	private static final String USER_INFO = "userInfo";
	
	/** 跳转错误页 */
    private static final String ERROR_HTM = "/error.htm";
    
//    /**用户信息获取*/
//    @Autowired
//    private UserService userService;
//    
//    /**微信用户信息获取*/
//    @Autowired
//    private UserInfoService userInfoService;
//    
//    /**门店服务*/
//    @Autowired
//    private StoreService storeService;
	
	/**
     * 处理Request之前执行
     */
	@SuppressWarnings("unchecked")
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        String url = requestUri.substring(contextPath.length());
        String query = request.getQueryString();
        String userAgent = request.getHeader(USER_AGENT);
        
        String xReqWith = request.getHeader("X-Requested-With");
        String userInfo = request.getParameter(USER_INFO);
        
        
        /*******************************获取所有传入参数START*************************************/
        Map<String, Object> map= (Map<String, Object>) request.getParameterMap();
    	
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String [] param = (String []) entry.getValue();  
			System.out.println("key= " + entry.getKey() + " and value= "
					+ param[0]);
			
//			if (this.sqlValidate(param[0])) {
//				response.sendRedirect(ERROR_HTM);
//				return false;
//			}
		}
		/*******************************获取所有传入参数END*************************************/
		
		/*******************************AJAX请求头START*************************************/
		if ("XMLHttpRequest".equals(xReqWith)) {
			System.out.println("ajax");
		} else {
			System.out.println("not ajax");
		}
		/*******************************AJAX请求头END*************************************/
		
		
        // 有参数(第一次进入)
    	if (StringUtils.isNotEmpty(userInfo)) {
    		if (!this.fromByParam(request, response, userInfo, requestUri, query, userAgent)) {
    			return false;
    		}
    	}
        
        // 来自微信
    	if (userAgent.contains("MicroMessenger")) {
//    		if (!this.fromWx(request, response, requestUri, url, query)) {
//    			return false;
//    		}
    	}
    	
    	// 无参数
    	{
    		if (!this.fromOther(request, response, requestUri, query, userAgent)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
	
	// 防止sql注入
	//效验
    protected static boolean sqlValidate(String str) {
        str = str.toLowerCase();//统一转为小写
        //过滤掉的sql关键字，可以手动添加
//        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
//                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
//                "table|from|grant|use|group_concat|column_name|" +
//                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
//                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";
        String badStr = "select";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    
	/**
	 * 有参数(第一次进入)
	 * 
	 * @param request
	 * @param response
	 * @param userInfo
	 * @param requestUri
	 * @param query
	 * @return
	 */
	private boolean fromByParam(HttpServletRequest request, HttpServletResponse response, 
			String userInfo, String requestUri, String query, String userAgent) throws Exception {
		logger.info("url:{},query:{},userAgent:{}", requestUri, query, userAgent);
		logger.info("before userInfo is {}", userInfo);
		String user = Base64Operate.fromBASE64(userInfo);
		logger.info("after userInfo is {}", user);
		
		CustomCxbInfoVo customCxbInfo = JSONParser.toStringObject(user, CustomCxbInfoVo.class);
		
		if (customCxbInfo != null) {
			
			String key = this.getKey(customCxbInfo, request, response);
			String areaName = customCxbInfo.getCityName();
			String localX = customCxbInfo.getLocalX();
			String localY = customCxbInfo.getLocalY();

			// 定位城市
			if (StringUtils.isNotEmpty(areaName)) {
				areaName = areaName.replace("市", "");
//				AreaInfoVo areaInfo = storeService.getAreaByAreaName(areaName);
//				userInfoService.setArea(key, customCxbInfo.getUserId(), areaInfo);
			}
			
			// 定位经纬度
			if (StringUtils.isNotEmpty(localX)
					&& StringUtils.isNotEmpty(localY)) {
				Double dLocalX = Double.valueOf(customCxbInfo.getLocalX());
				Double dLocalY = Double.valueOf(customCxbInfo.getLocalY());
				
				if (dLocalX != 0 && dLocalY != 0) {
	    			PointVo point = new PointVo();
	    			point.setUserId(customCxbInfo.getUserId());
	    			point.setLongitude(dLocalX);
	    			point.setLatitude(dLocalY);
	    			
	    			// 有城市，不定位城市
	    			if (StringUtils.isNotEmpty(areaName)) {
//	    				userInfoService.putLocationOnly(key, point);
	    			}
	    			// 无城市，需定位城市
	    			else {
//		    			userInfoService.putLocationToCache(key, point);
	    			}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(USER_INFO);
			sb.append("=");
			sb.append(userInfo);
			query = query.replace(sb.toString(), "");
			
			String redirectUrl = this.getRedirectUrl(requestUri, query);
			response.sendRedirect(redirectUrl);
			return false;
		}
		
		response.sendRedirect(ERROR_HTM);
		return false;
	}
	
	/**
	 * 获取用户标识
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	private String getKey(CustomCxbInfoVo customCxbInfo, HttpServletRequest request, HttpServletResponse response) {
		
		// 来源
//		Map<String, String> sourceMap = sysRefFieldService.sourceMap();
//		Map<String, String> openTypeMap = sysRefFieldService.openTypeMap();
		
		Map<String, String> sourceMap = new HashMap<String, String>();
		sourceMap.put("0", "CXJ");
		sourceMap.put("1", "CXH");
		sourceMap.put("2", "CXB");
		
		Map<String, String> openTypeMap = new HashMap<String, String>();
		openTypeMap.put("CXJ", "4");
		openTypeMap.put("CXB", "6");
		openTypeMap.put("CXH", "7");
		openTypeMap.put("MZ", "8");
		openTypeMap.put("BAIDU", "9");
		
		String openType = openTypeMap.get(sourceMap.get(customCxbInfo.getSourceType()));
		openType = StringUtils.trimToEmpty(openType);
		CookieUtil.addCookieMaxAge(response, CookieUtil.OPEN_TYPE, openType);
		
		// 车享ID
		String cxId = customCxbInfo.getUserId();
		cxId = StringUtils.trimToEmpty(cxId);
		CookieUtil.addCookieMaxAge(response, CookieUtil.CXID, cxId);
		
		String openId = customCxbInfo.getOpenId();
		openId = StringUtils.trimToEmpty(openId);
		CookieUtil.addCookieMaxAge(response, CookieUtil.OPENID, openId);
		
		// 用户标识
		String key = CookieUtil.getCookieByName(request, CookieUtil.USER_KEY);
		// 根据不同场景，设定用户标识
		key = this.getUserKey(key, openType, openId);
		CookieUtil.addCookieMaxAge(response, CookieUtil.USER_KEY, key);
		
		return key;
	}
	
	/**
	 * 根据不同场景，设定用户标识
	 * 
	 * @param key
	 * @param openType
	 * @param openId
	 * @return
	 */
	private String getUserKey(String key, String openType, String openId) {
		// 车享家
		if ("4".equals(openType)) {
			if (StringUtils.isEmpty(openId)) {
				key = UUID.randomUUID().toString();
			} else {
				key = StringUtils.trimToEmpty(openId);
			}
		} 
		// 车享汇
		else if ("7".equals(openType)) {
			if (StringUtils.isEmpty(key)) {
				key = UUID.randomUUID().toString();
			} else if(key.equals(openId)) {
				key = UUID.randomUUID().toString();
			}
		}
		// 车享宝
		else {
			if (StringUtils.isEmpty(key)) {
				key = UUID.randomUUID().toString();
			}
		}
		return key;
	}
	
	/**
	 * 来自微信
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private boolean fromWx(HttpServletRequest request, HttpServletResponse response, 
			String requestUri, String url, String query) throws Exception {
		String openType = CookieUtil.getCookieByName(request, CookieUtil.OPEN_TYPE);
		String openId = CookieUtil.getCookieByName(request, CookieUtil.OPENID);
		String cxId = CookieUtil.getCookieByName(request, CookieUtil.CXID);
		
		// 车享jia
		if ("4".equals(openType) || StringUtils.isEmpty(openType)) {
			// 无OpenId
			if (StringUtils.isEmpty(openId)) {
				logger.info("from wx");
				
				String redirectUrl = this.getRedirectUrl(url, query);
				
				request.getRequestDispatcher("/oAuth/index.htm?callbackUrl="
						+ Base64Operate.toBASE64(redirectUrl)+"&base64=1").forward(request, response);
				return false;
			}
			
			// 无车享Id
			if (StringUtils.isEmpty(cxId)) {
				cxId = "10002355";
				// 根据openId获取车享Id
				if (StringUtils.isNotEmpty(cxId)) {
		    		CookieUtil.addCookieMaxAge(response, CookieUtil.CXID, cxId);
		    		
		    		String redirectUrl = this.getRedirectUrl(requestUri, query);
		    		response.sendRedirect(redirectUrl);
		    		return false;
		    	}
			}
		}
		
		return true;
	}
	
	/**
	 * 无参数
	 * 
	 * @param request
	 * @param response
	 * @param requestUri
	 * @param query
	 * @return
	 */
	private boolean fromOther(HttpServletRequest request, HttpServletResponse response, 
			String requestUri, String query, String userAgent) throws Exception {
		
		String openId = CookieUtil.getCookieByName(request, CookieUtil.OPENID);
        String openType = CookieUtil.getCookieByName(request, CookieUtil.OPEN_TYPE);
        String key = CookieUtil.getCookieByName(request, CookieUtil.USER_KEY);
        
        if(StringUtils.isEmpty(openType) || StringUtils.isEmpty(key)) {
        	logger.info("from other");
			logger.info("openType:{},key:{}", openType, key);
			logger.info("url:{},query:{},userAgent:{}", requestUri, query, userAgent);

        	// 判断cookie是否有OpenType
            if(StringUtils.isEmpty(openType)) {
    			CookieUtil.addCookieMaxAge(response, CookieUtil.OPEN_TYPE, "8");
            }
    		
    		// 判断用户标识是否存在
    		if (StringUtils.isEmpty(key)) {
    			// 根据不同场景，设定用户标识
    			key = this.getUserKey(key, openType, openId);
    			CookieUtil.addCookieMaxAge(response, CookieUtil.USER_KEY, key);
    		}
    		
			String redirectUrl = this.getRedirectUrl(requestUri, query);
			response.sendRedirect(redirectUrl);
			return false;
        }
        
        // 车享汇时，检查openId
        if (openType.equals("7")) {
        	if (StringUtils.isEmpty(openId)) {
    			logger.info("url:{},query:{},userAgent:{}", requestUri, query, userAgent);
            	logger.info("车享汇，openId为空！");			
    			response.sendRedirect(ERROR_HTM);
    			return false;
        	}
        }
        
    	return true;
	}
	
	/**
     * 处理Request方法之后但是还没有返回View之前执行，并允许处理ModelAndView对象
     */
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }
}
