/*

 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: BaseController.java
 * Author:   baowenzhou
 * Date:     2014年8月19日 下午8:30:20
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;









import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xjf.wemall.service.index.api.IndexService;

//import com.saic.wemall.api.entity.common.CookieObject;
//import com.saic.wemall.service.sysreference.api.SysRefFieldService;
//import com.saic.wemall.web.util.CookieUtil;

/**
 * @author baowenzhou
 *
 */
@Controller(value="baseController")
@RequestMapping("/base")
public class BaseController {
	/**
	 * 日志
	 * */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());
	
	/** TEST页面 */
	protected static final String SELECT_CAR_HTM = "/selectCar/toSelectCar.htm";
	
    @Autowired
    protected IndexService indexService;
	
	
	@RequestMapping(value="/index.htm")
	public String index(RedirectAttributes redirectAttributes
			, HttpServletRequest servletRequest
			, HttpServletResponse servletResponse
			, Model model) throws Exception {
		//redirectAttributes.addFlashAttribute("map", indexService.index());
		redirectAttributes.addAttribute("map", "abc");
		//model.addAttribute("map", "abc");
		//servletRequest.setAttribute("cccc", "3");
		//servletResponse.sendRedirect("/base/index2.json");
		return this.redirect("/base/index3.json");
		//servletRequest.getRequestDispatcher("/base/index2.json").forward(servletRequest, servletResponse);
		//servletRequest.getRequestDispatcher("https://www.baidu.com").forward(servletRequest, servletResponse);
	}
	

	@RequestMapping(value="/index2")
	@ResponseBody
	public Map<String, String> index2(@ModelAttribute("map") Map<String, String> map, HttpServletRequest servletRequest){
		System.out.println(servletRequest.getAttribute("cccc"));
		System.out.println(servletRequest.getSession().getAttribute("cccc"));
		System.out.println(servletRequest.getAttribute("d"));
		return map;
	}
	
	
	@RequestMapping(value="/index3")
	@ResponseBody
	public Vo index3(Vo v, HttpServletRequest servletRequest
			, Model model){
		return v;
	}
	
	/***
	 * 
	 * 功能描述: 统一获取Request<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	protected HttpServletRequest getRequest(){
	    HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	    return request;
	}
	
	/***
	 * 初始化数据
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAutoGrowCollectionLimit(Integer.MAX_VALUE);  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        
    }

	
	/***
	 * 
	 * 功能描述: 获取openId<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getOpenId(){
//		String openId = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.OPENID);
//		if(StringUtils.isNotEmpty(openId)){
//			return openId;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取openType<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getOpenType(){
//		String openType = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.OPEN_TYPE);
//		if(StringUtils.isNotEmpty(openType)){
//			return openType;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取经度<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getLongitude(){
//		String longitude = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.LOCATION_LONGITUDE);
//		if(StringUtils.isNotEmpty(longitude)){
//			return longitude;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取纬度<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getLatitude(){
//		String latitude = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.LOCATION_LATITUDE);
//		if(StringUtils.isNotEmpty(latitude)){
//			return latitude;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取车享ID<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getCxId(){
//		String cxId = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.CXID);
//		if(StringUtils.isNotEmpty(cxId)){
//			return cxId;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取用户标识<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getUserKey(){
//		String userKey = CookieUtil.getCookieByName(this.getRequest(), CookieUtil.USER_KEY);
//		if(StringUtils.isNotEmpty(userKey)){
//			return userKey;
//		}
		return StringUtils.EMPTY;
	}
	
	/***
	 * 
	 * 功能描述: 获取Cookie对象<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
//	protected CookieObject getCookie(HttpServletResponse response) {
//		CookieObject cookie = new CookieObject();
//		cookie.setOpenId(this.getOpenId());
//		cookie.setOpenType(this.getOpenType());
//		cookie.setCxId(this.getCxId());
//		cookie.setLongitude(this.getLongitude());
//		cookie.setLatitude(this.getLatitude());
//		cookie.setKey(this.getUserKey());
//		return cookie;
//	}
	
	/**
	 * 页面跳转
	 * 
	 * @param redirectUrl
	 * @return
	 */
	protected String redirect(String redirectUrl){
	    StringBuilder  url=new StringBuilder();
        url.append("redirect:");
//        url.append(this.getRequest().getScheme());
//        url.append("://");
//        url.append(this.getRequest().getServerName());
        url.append(redirectUrl);
        return url.toString();
	}
	
	/**
	 * 获取当前函数名
	 * 
	 * @return
	 */
	protected String getMethodName() {
		StackTraceElement[] stacktrace = Thread.currentThread().getStackTrace();  
        StackTraceElement e = stacktrace[2];  
        String methodName = e.getMethodName();  
        return methodName; 
	}
	
}