/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CookieMenuInterceptor.java
 * Author:   baowenzhou
 * Date:     2016年01月21日 下午3:56:12
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.xjf.wemall.api.entity.redis.RedisVerifyVo;
import com.xjf.wemall.service.redis.api.RedisVerifyService;
import com.xjf.wemall.web.util.CookieUtil;

/**
 * 配置页面权限判断<br>
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CookieMenuInterceptor extends BaseInterceptor {

	/** 跳转验证页 */
	private static final String VERIFY_HTM = "/cookie/verify.htm";
	
	private boolean isCheck;

	/** 缓存验证 */
	@Autowired
	private RedisVerifyService redisVerifyService;

	/**
	 * 处理Request之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {

		// 不需验证
		if (!isCheck) {
			return true;
		}

		String uid = CookieUtil.getCookieByName(request, CookieUtil.VERIFY_UID);
		String code = CookieUtil.getCookieByName(request, CookieUtil.VERIFY_CODE);

		if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(code)) {
			response.sendRedirect(VERIFY_HTM);
			return false;
		}

		// 判断是否验证
		RedisVerifyVo redisVerify = new RedisVerifyVo();
		redisVerify.setUid(uid);
		redisVerify.setCode(code);
		redisVerify.setIp(request.getRemoteAddr());

		// 验证
		boolean result = redisVerifyService.verify(redisVerify);

		// 验证不通过
		if (!result) {
			response.sendRedirect(VERIFY_HTM);
			return false;
		}

		return true;
	}

	/**
	 * 处理Request方法之后但是还没有返回View之前执行，并允许处理ModelAndView对象
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println(11111);
	}
	
	@Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(22222);
    }

	public boolean isCheck() {
		return isCheck;
	}

	public void setIsCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}
	
	
}
