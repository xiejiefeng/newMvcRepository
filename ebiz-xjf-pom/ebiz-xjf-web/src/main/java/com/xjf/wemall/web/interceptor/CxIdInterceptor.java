/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CxIdInterceptor.java
 * Author:   baowenzhou
 * Date:     2015年08月18日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.URLUtil;
import com.xjf.wemall.web.util.CookieUtil;

/**
 * 车享Id判断<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CxIdInterceptor extends BaseInterceptor {

	/** 入口资源 */
	private Map<String, List<String>> entryUrls;

	/** 入口资源 */
	private Map<String, List<String>> entryDirs;

	/** 跳转验证页面 */
	private String loginUrl;

	/** native唤醒页面 */
	private String nativeUrl;

	/**
	 * @param entryUrls
	 *            入口资源
	 */
	public void setEntryUrls(Map<String, List<String>> entryUrls) {
		this.entryUrls = entryUrls;
	}

	/**
	 * @param entryUrls
	 *            入口资源
	 */
	public void setEntryDirs(Map<String, List<String>> entryDirs) {
		this.entryDirs = entryDirs;
	}

	/**
	 * @param loginUrl
	 *            跳转验证页面
	 */
	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * @param nativeUrl
	 *            native唤醒页面
	 */
	public void setNativeUrl(String nativeUrl) {
		this.nativeUrl = nativeUrl;
	}

	/**
	 * 处理Request之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		String query = request.getQueryString();

		// 用户进入方式
		String openType = CookieUtil.getCookieByName(request, CookieUtil.OPEN_TYPE);
		// 车享ID
		String cxId = CookieUtil.getCookieByName(request, CookieUtil.CXID);

		// 有车享ID
		if (StringUtils.isNotEmpty(cxId)) {
			return true;
		}

		// 获取来源配置
//		Map<String, String> openTypeMap = sysRefFieldService.openTypeMap();
		Map<String, String> openTypeMap = new HashMap<String, String>();

		// 根据链接全匹配
		String redirectUrl = this.checkUrl(url, query, openType, openTypeMap);
		if (StringUtils.isNotEmpty(redirectUrl)) {
			response.sendRedirect(redirectUrl);
			return false;
		}

		// 根据目录匹配
		redirectUrl = this.checkDir(url, query, openType, openTypeMap);
		if (StringUtils.isNotEmpty(redirectUrl)) {
			response.sendRedirect(redirectUrl);
			return false;
		}

		return true;
	}

	/**
	 * 
	 * 功能描述: 根据链接全匹配<br>
	 * 〈功能详细描述〉
	 *
	 * @param url
	 * @param query
	 * @param openType
	 * @param openTypeMap
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String checkUrl(String url, String query, String openType,
			Map<String, String> openTypeMap) {

		List<String> urls = new ArrayList<String>();
		String key = null;
		String redirectUrl = null;

		// 获取配置的来源与拦截Url对应关系
		for (Entry<String, List<String>> entryUrl : entryUrls.entrySet()) {
			key = entryUrl.getKey();
			if (openTypeMap.containsKey(key)) {
				if (openTypeMap.get(key).equals(openType)) {
					urls = entryUrl.getValue();
					break;
				}
			}
		}
		// 进入默认来源
		if (CollectionUtils.isEmpty(urls)) {
			urls = entryUrls.get(WemallConstants.REFERENCE_DETAIL_CODE_TYPE_OTHER);
		}
		// 特定页面拦截
		if (!CollectionUtils.isEmpty(urls) && urls.contains(url)) {
			redirectUrl = this.getLoginUrl(url, query, openType);
		}

		return redirectUrl;
	}

	/**
	 * 
	 * 功能描述: 根据目录匹配<br>
	 * 〈功能详细描述〉
	 *
	 * @param url
	 * @param query
	 * @param openType
	 * @param openTypeMap
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String checkDir(String url, String query, String openType,
			Map<String, String> openTypeMap) {
		List<String> dirs = new ArrayList<String>();
		String key = null;
		String redirectUrl = null;

		// 获取配置的来源与拦截Url对应关系
		for (Entry<String, List<String>> entryDir : entryDirs.entrySet()) {
			key = entryDir.getKey();
			if (openTypeMap.containsKey(key)) {
				if (openTypeMap.get(key).equals(openType)) {
					dirs = entryDir.getValue();
					break;
				}
			}
		}
		// 进入默认来源
		if (CollectionUtils.isEmpty(dirs)) {
			dirs = entryDirs.get(WemallConstants.REFERENCE_DETAIL_CODE_TYPE_OTHER);
		}
		// 特定页面拦截
		if (!CollectionUtils.isEmpty(dirs)) {
			for (String dir : dirs) {
				if (url.startsWith(dir)) {
					redirectUrl = this.getLoginUrl(url, query, openType);
					break;
				}
			}
		}

		return redirectUrl;
	}

	/**
	 * 
	 * 功能描述: 获取跳转链接<br>
	 * 〈功能详细描述〉
	 *
	 * @param url
	 * @param query
	 * @param openType
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getLoginUrl(String url, String query, String openType) {
		logger.info("cxId is empty,openType:{},url:{}", openType, url);

		StringBuilder back = new StringBuilder();
		back.append(url);
		if (StringUtils.isNotEmpty(query)) {
			back.append("?");
			back.append(query);
		}

		StringBuilder login = new StringBuilder();

		// 车享宝唤醒Native登录页面
//		if (sysRefFieldService.openTypeCxb().equals(openType)) {
//			Map<String, String> param = new HashMap<String, String>();
//			param.put(WemallConstants.BACK_REDIRECT_URL, back.toString());
//
//			login.append(nativeUrl);
//			login.append("?execType=");
//			login.append(WemallConstants.NEED_LOGIN);
//			login.append("&jsonPara=");
//			login.append(URLUtil.encode(JSONParser.toJSONString(param)));
//		}
//		// 其他跳转H5登录页面
//		else {
//			login.append(loginUrl);
//			login.append("?targetUrl=");
//			login.append(URLUtil.encode(back.toString()));
//		}

		return login.toString();
	}

	/**
	 * 处理Request方法之后但是还没有返回View之前执行，并允许处理ModelAndView对象
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
	}

	/**
	 * 在所有请求处理完成之后（也就是显示视图之后）调用。
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
	}
}
