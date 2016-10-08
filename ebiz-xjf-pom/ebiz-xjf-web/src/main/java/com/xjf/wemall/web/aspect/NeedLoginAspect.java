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

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.xjf.wemall.annotation.NeedLogin;
import com.xjf.wemall.annotation.NeedLoginParam;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.annotation.AnnotationVo;
import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.web.util.CookieUtil;

/**
 * 登录校验检查<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class NeedLoginAspect extends BaseAspect {

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
	@Override
	protected <T> T check(ProceedingJoinPoint joinPoint, Class<T> clazz) throws Throwable {

		// 获取链接信息
		HttpServletRequest request = super.getRequest();

		// 获取车享ID和当前渠道
		String cxId = CookieUtil.getCxId(request);
		String openType = CookieUtil.getOpenType(request);
		// 判断是否含车享ID
		if (StringUtils.isNotEmpty(cxId)) {
			return (T) joinPoint.proceed();
		}

		String longUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String shortUrl = requestUri.substring(contextPath.length());
		String query = request.getQueryString();
		if (super.excludeList.size() > 0) {
			if (excludeList.contains(shortUrl)) {
				return (T) joinPoint.proceed();
			}
		}
		
		// String value = staticValueService.getSysReference(
		// WemallConstants.REFERENCE_CODE_LOGIN_CHK_URL, url);

		// // 无需登录校验
		// if (value == null) {
		// return (T) joinPoint.proceed();
		// }

//		SysReferenceDetailRestFulVo vo = new SysReferenceDetailRestFulVo();
//		vo.setPkReferenceRule(WemallConstants.REFERENCE_CODE_LOGIN_CHK_URL);

		// vo.setReferenceCode(shortUrl);
		// List<SysReferenceDetailRestFulVo> list = sysReferenceService
		// .getReferenceRedis(vo);
		// Redis访问不到时，不重置Redis(遗弃)
//		// List<SysReferenceDetailRestFulVo> list = sysReferenceService
//		// .querySysReferenceForRestFul(vo);
//
//		// 支持带参数的非固定url逻辑
//		List<SysReferenceDetailRestFulVo> list = sysReferenceService.getReferenceRedis(vo);
//		// 无需登录校验
//		if (CollectionUtils.isEmpty(list)) {
//			return (T) joinPoint.proceed();
//		}
//		boolean loginFlag = true;
//		String value = "";
//		for (SysReferenceDetailRestFulVo srefVo : list) {
//			if (srefVo.getReferenceCode().indexOf(WemallConstants.URL_WILDCARD_CHAR) > -1) {
//				if (shortUrl
//						.startsWith(srefVo.getReferenceCode()
//								.split("\\" + WemallConstants.URL_WILDCARD_CHAR)[0])
//						&& shortUrl.endsWith(srefVo.getReferenceCode()
//								.split("\\" + WemallConstants.URL_WILDCARD_CHAR)[1])) {
//					value = srefVo.getReferenceName();
//					loginFlag = false;
//					break;
//				}
//			} else {
//				if (shortUrl.equals(srefVo.getReferenceCode())) {
//					value = srefVo.getReferenceName();
//					loginFlag = false;
//					break;
//				}
//			}
//		}
//
//		// 无需登录校验
//		if (loginFlag) {
//			return (T) joinPoint.proceed();
//		}
//
//		// value = list.get(0).getReferenceName();
//
//		boolean check = false;
//
//		// 全渠道校验
//		if ("".equals(value)) {
//			check = true;
//		}
//		// 排除项校验
//		else {
//			String[] ignoreChannel = value.split(",");
//
//			// 订单来源Map(Key-Value反转)
//			Map<String, String> map = sysRefFieldService.openTypeReverseMap();
//			String openTypeName = map.get(openType);
//
//			// 当前渠道不在忽略登录渠道
//			if (!ArrayUtils.contains(ignoreChannel, openTypeName)) {
//				check = true;
//			}
//		}
//
//		// 不校验
//		if (!check) {
//			return (T) joinPoint.proceed();
//		}

		logger.info("cxId is empty,openType:{},url:{}", openType, shortUrl);

		if (clazz.equals(String.class)) {
			String redirectUrl = this.getLoginUrl(longUrl, query, openType);
			return (T) super.redirect(redirectUrl);
		} else {
			AjaxObject ajaxObject = new AjaxObject();
			ajaxObject.setResult(AjaxObject.NOLOGIN);
			return (T) ajaxObject;
		}
	}

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
	public String checkLoginUrl2(ProceedingJoinPoint joinPoint,
			NeedLogin needLogin) throws Throwable {
		return this.checkLogin2(joinPoint, needLogin, String.class);
	}

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
	public AjaxObject checkLoginAjax2(ProceedingJoinPoint joinPoint,
			NeedLogin needLogin) throws Throwable {
		return this.checkLogin2(joinPoint, needLogin, AjaxObject.class);
	}

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
	private <T> T checkLogin2(ProceedingJoinPoint joinPoint,
			NeedLogin needLogin, Class<T> clazz) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint
				.getSignature();
		Method method = methodSignature.getMethod();
		Object[] args = joinPoint.getArgs();

		// 判断是否含NeedLogin标签
		if (needLogin == null) {
			return (T) joinPoint.proceed(args);
		}

		// 获取链接信息
		HttpServletRequest request = super.getRequest();

		// 获取车享ID和当前渠道
		String cxId = CookieUtil.getCxId(request);
		String openType = CookieUtil.getOpenType(request);

		// 判断是否含车享ID
		if (StringUtils.isNotEmpty(cxId)) {
			return (T) joinPoint.proceed(args);
		}

		String[] checkChannel = needLogin.checkChannel();
		String[] ignoreChannel = needLogin.ignoreChannel();
		boolean check = false;

		// 全渠道校验
		if (ArrayUtils.isEmpty(checkChannel)
				&& ArrayUtils.isEmpty(ignoreChannel)) {
			check = true;
		} else {
			// // 订单来源Map(Key-Value反转)
			// Map<String, String> map =
			// sysRefFieldService.openTypeReverseMap();
			// String openTypeName = map.get(openType);
			//
			// // 有必须登录渠道
			// if (ArrayUtils.isNotEmpty(checkChannel)) {
			// // 当前渠道在必须登录渠道中
			// if (ArrayUtils.contains(checkChannel, openTypeName)) {
			// check = true;
			// }
			// }
			// // 有忽略登录渠道
			// else if (ArrayUtils.isNotEmpty(ignoreChannel)) {
			// // 当前渠道不在忽略登录渠道
			// if (!ArrayUtils.contains(ignoreChannel, openTypeName)) {
			// check = true;
			// }
			// }
		}

		// 不校验
		if (!check) {
			return (T) joinPoint.proceed(args);
		}

		// 参数校验
		Annotation[][] parameterAnnotations = method.getParameterAnnotations();
		List<AnnotationVo> annotationList = new ArrayList<AnnotationVo>();
		AnnotationVo annotationVo = null;

		for (int i = 0; i < parameterAnnotations.length; i++) {
			if (args[i] instanceof String) {
				for (Annotation annotation : parameterAnnotations[i]) {
					if (annotation instanceof NeedLoginParam) {
						annotationVo = new AnnotationVo();
						annotationVo.setParamValue(args[i]);
						annotationVo.setAnnotation(annotation);
						annotationList.add(annotationVo);
						break;
					}
				}
			}
		}

		String longUrl = request.getRequestURL().toString();
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String shortUrl = requestUri.substring(contextPath.length());
		String query = request.getQueryString();

		logger.info("cxId is empty,openType:{},url:{}", openType, shortUrl);

		if (clazz.equals(String.class)) {
			String redirectUrl = this.getLoginUrl(longUrl, query, openType);
			return (T) super.redirect(redirectUrl);
		} else {
			String redirectUrl = this.getLoginUrl(needLogin.callbackUrl(), "",
					openType);
			AjaxObject ajaxObject = new AjaxObject();
			ajaxObject.setResult(AjaxObject.NOLOGIN);
			ajaxObject.setReturnUrl(redirectUrl);
			return (T) ajaxObject;
		}
	}
}