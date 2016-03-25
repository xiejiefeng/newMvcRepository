/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: NeedLoginAspect.java
 * Author:   baowenzhou
 * Date:     2016年03月10日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.aspect;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;

import com.xjf.wemall.annotation.NeedLogin;
//import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.URLUtil;
import com.xjf.wemall.web.controller.BaseController;

/**
 * 登录校验检查<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NeedLoginAspect extends BaseAspect {

	/** 跳转验证页面 */
	private final String loginUrl = "/user/login-fast.htm";

	/** native唤醒页面 */
	private final String nativeUrl = "/cxb/initCxbNat.htm";
	
	/**
	 * 
	 * 功能描述: <br>
	 * 〈功能详细描述〉
	 *
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@SuppressWarnings("unchecked")
	private <T> T checkLogin(ProceedingJoinPoint joinPoint, NeedLogin needLogin, Class<T> clazz) throws Throwable {
//		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//		NeedLogin needLogin = methodSignature.getMethod().getAnnotation(NeedLogin.class);
		Object[] args = joinPoint.getArgs();

		// 判断是否含NeedLogin标签
		if (needLogin == null) {
			return (T) joinPoint.proceed(args);
		}

		// 获取车享ID和当前渠道
		String cxId = super.getCxId();
		String openType = super.getOpenType();

		// 判断是否含车享ID
		if (StringUtils.isNotEmpty(cxId)) {
			return (T) joinPoint.proceed(args);
		}

		String[] checkChannel = needLogin.checkChannel();
		String[] ignoreChannel = needLogin.ignoreChannel();
		boolean check = false;

		// 全渠道校验
		if (ArrayUtils.isEmpty(checkChannel) && ArrayUtils.isEmpty(ignoreChannel)) {
			check = true;
		} else {
			// 订单来源Map(Key-Value反转)
//			Map<String, String> map = sysRefFieldService.openTypeReverseMap();
			Map<String, String> map = new HashMap<String, String>();
			String openTypeName = map.get(openType);

			// 有必须登录渠道
			if (ArrayUtils.isNotEmpty(checkChannel)) {
				// 当前渠道在必须登录渠道中
				if (ArrayUtils.contains(checkChannel, openTypeName)) {
					check = true;
				}
			}
			// 有忽略登录渠道
			else if (ArrayUtils.isNotEmpty(ignoreChannel)) {
				// 当前渠道不在忽略登录渠道
				if (!ArrayUtils.contains(ignoreChannel, openTypeName)) {
					check = true;
				}
			}
		}

		// 不校验
		if (!check) {
			return (T) joinPoint.proceed(args);
		}

		// 获取链接信息
		HttpServletRequest request = super.getRequest();
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		String query = request.getQueryString();
		
		logger.info("cxId is empty,openType:{},url:{}", openType, url);
		
		if (clazz.equals(String.class)) {
			String redirectUrl = this.getLoginUrl(url, query, openType);
			return (T) super.redirect(redirectUrl);
		} else {
			String redirectUrl = this.getLoginUrl(needLogin.callbackUrl(), "", openType);
			AjaxObject ajaxObject = new AjaxObject();
			ajaxObject.setResult(AjaxObject.NOLOGIN);
			ajaxObject.setReturnUrl(redirectUrl);
			return (T) ajaxObject;
		}
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
		
		StringBuilder back = new StringBuilder();
		back.append(url);
		if (StringUtils.isNotEmpty(query)) {
			back.append("?");
			back.append(query);
		}

		StringBuilder login = new StringBuilder();

		// 车享宝唤醒Native登录页面
//		if (sysRefFieldService.openTypeCxb().equals(openType)) {
		if (StringUtils.equals(login.toString(), openType)) {
			Map<String, String> param = new HashMap<String, String>();
//			param.put(WemallConstants.BACK_REDIRECT_URL, back.toString());

			login.append(nativeUrl);
			login.append("?execType=");
//			login.append(WemallConstants.NEED_LOGIN);
			login.append("&jsonPara=");
			login.append(URLUtil.encode(JSONParser.toJSONString(param)));
		}
		// 其他跳转H5登录页面
		else {
			login.append(loginUrl);
			login.append("?targetUrl=");
			login.append(URLUtil.encode(back.toString()));
		}

		return login.toString();
	}
}