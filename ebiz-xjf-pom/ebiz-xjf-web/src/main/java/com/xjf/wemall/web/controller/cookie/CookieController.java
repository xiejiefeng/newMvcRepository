/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CookieController.java
 * Author:   baowenzhou
 * Date:     2015年07月01日 下午4:39:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.controller.cookie;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xjf.wemall.annotation.CookieParam;
import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.api.entity.common.CookieObject;
import com.xjf.wemall.api.entity.redis.RedisLockVo;
import com.xjf.wemall.api.entity.redis.RedisVerifyVo;
import com.xjf.wemall.api.entity.user.PointVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.JavaScriptUtil;
import com.xjf.wemall.api.util.StringUtil;
import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.service.redis.api.RedisLockService;
import com.xjf.wemall.service.redis.api.RedisVerifyService;
import com.xjf.wemall.service.redis.impl.RedisJobServiceImpl;
import com.xjf.wemall.service.redis.impl.RedisLockServiceImpl;
import com.xjf.wemall.web.controller.BaseController;
import com.xjf.wemall.web.util.CookieUtil;

/**
 * Cookie页面<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/cookie")
public class CookieController extends BaseController{
    /***
     * 首页
     */
    private static final String COOKIE_FTL="/cookie/cookie.ftl";
    
//    /***
//     * 更新缓存
//     */
//    private static final String RESET_FTL="/cookie/reset.ftl";
    
    /***
     * 验证页
     */
    private static final String VERIFY_FTL="/cookie/verify.ftl";
    
//    @Autowired
    @Resource(type=RedisLockServiceImpl.class)
    RedisLockService redisLockService;
    
    @Autowired
    RedisJobService redisJobService;
    
    /** 缓存验证 */
	@Autowired
	private RedisVerifyService redisVerifyService;

	
    /***
     *     
     * 功能描述:跳转关于我们 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/menu")
    public String index(@CookieParam CookieObject cookie, HttpServletRequest request, Model model, HttpServletResponse response,
    		@MatrixVariable(required = false) String q1, @MatrixVariable(required = false) String q2){
    	
    	// 获取Cookie对象
//    	CookieObject cookie = super.getCookie(response);
    	
    	if (StringUtils.isEmpty(cookie.getCxId())) {
    		String cxId = StringUtil.getRandomString(8, StringUtil.RANDOM_NUMBER);
    		CookieUtil.addCookieMaxAge(response, CookieUtil.CXID, cxId);
    		cookie.setCxId(cxId);
    		
    	}
    	//判断cookie中是否有openid
    	model.addAttribute("openId", cookie.getOpenId());
    	model.addAttribute("openType", cookie.getOpenType());
    	model.addAttribute("cxId", cookie.getCxId());
    	model.addAttribute("x", cookie.getLongitude());
    	model.addAttribute("y", cookie.getLatitude());
    	model.addAttribute("key", cookie.getKey());
    	
//    	SysReferenceDetailRestFulVo queryVo = new SysReferenceDetailRestFulVo();
//    	queryVo.setPkReferenceRule(WemallConstants.REFERENCE_CODE_OPENTYPE);
//    	List<SysReferenceDetailRestFulVo> list = sysReferenceService.getReferenceRedis(queryVo);
//    	Collections.sort(list, new Comparator<SysReferenceDetailRestFulVo>(){
//			@Override
//			public int compare(SysReferenceDetailRestFulVo o1, SysReferenceDetailRestFulVo o2) {
//				return o1.getReferenceName().compareTo(o2.getReferenceName());
//			}
//    	});
//    	model.addAttribute("openTypeList", list);
    	
    	StringBuffer jsParamString = new StringBuffer();

		for (int i = 0; i< 1; i++) {
			jsParamString.append("var ").append("a").append(" = \"")
					.append(i).append("\" ;");
		}
		// 混淆的JS
		model.addAttribute("serviceDescJsParamString", JavaScriptUtil.obfuscateScript(jsParamString.toString()));
		
        return COOKIE_FTL;
    }
    
    /***
     *     
     * 功能描述:跳转关于我们 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/m/{menu2}")
    public String index(HttpServletRequest request, Model model, HttpServletResponse response, @PathVariable(value = "menu2") String menu2,
    		@MatrixVariable(required = false) String[] q1, @MatrixVariable(required = false) String q2
    		,@RequestParam(required=false) String q3){
    	
    	// 获取Cookie对象
    	CookieObject cookie = super.getCookie(response);
    	
    	//判断cookie中是否有openid
    	model.addAttribute("openId", cookie.getOpenId());
    	model.addAttribute("openType", cookie.getOpenType());
    	model.addAttribute("cxId", cookie.getCxId());
    	model.addAttribute("x", cookie.getLongitude());
    	model.addAttribute("y", cookie.getLatitude());
    	model.addAttribute("key", cookie.getKey());
    	
    	StringBuffer jsParamString = new StringBuffer();

		for (int i = 0; i< 1; i++) {
			jsParamString.append("var ").append("a").append(" = \"")
					.append(i).append("\" ;");
		}
		// 混淆的JS
		model.addAttribute("serviceDescJsParamString", JavaScriptUtil.obfuscateScript(jsParamString.toString()));
		
        return COOKIE_FTL;
    }
    
//    /***
//     *     
//     * 功能描述:跳转关于我们 <br>
//     * 〈功能详细描述〉
//     *
//     * @return
//     * @see [相关类/方法](可选)
//     * @since [产品/模块版本](可选)
//     */
//    @RequestMapping("/test")
//    public String test(HttpServletRequest request, Model model){
//    	//判断cookie中是否有openid
//    	model.addAttribute("openId", this.getOpenId());
//    	model.addAttribute("openType", this.getOpenType());
//    	model.addAttribute("x", this.getLongitude());
//    	model.addAttribute("y", this.getLatitude());
//    	model.addAttribute("wx", openTypeWx);
//    	model.addAttribute("cxb", openTypeCxb);
//        return COOKIE_TEST_FTL;
//    }
    
//    /***
//	 * 
//	 * 功能描述: 设定OpenId<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
	//@RequestMapping(value = "/setCookie", method = RequestMethod.GET)
    @RequestMapping(value = "/setCookie")
	@ResponseBody
	public AjaxObject setCookie(String openId, String openType, String cxId, String x, String y, String key,
			HttpServletRequest request, HttpServletResponse response) {
    	
		AjaxObject ajaxObject = new AjaxObject();
		
		openId = openId.trim();
		openType = openType.trim();
		cxId = cxId.trim();
		x = x.trim();
		y = y.trim();

		CookieUtil.addCookieMaxAge(response, CookieUtil.OPENID, openId);
		CookieUtil.addCookieMaxAge(response, CookieUtil.OPEN_TYPE, openType);
		CookieUtil.addCookieMaxAge(response, CookieUtil.CXID, cxId);
		CookieUtil.addCookieMaxAge(response, CookieUtil.LOCATION_LONGITUDE, x);
		CookieUtil.addCookieMaxAge(response, CookieUtil.LOCATION_LATITUDE, y);
		CookieUtil.addCookieMaxAge(response, CookieUtil.USER_KEY, key);
		
		if (StringUtils.isNotEmpty(x) && StringUtils.isNotEmpty(y)) {
			PointVo point = new PointVo();
			if ("4".equals(openType)) {
				point.setUserId(openId);
			} else {
				point.setUserId(cxId);
			}
			
			point.setLongitude(Double.valueOf(x));
			point.setLatitude(Double.valueOf(y));
//			userInfoService.putLocationToCache(key, point);
		}

		return ajaxObject;
	}
    
    
    /***
	 * 
	 * 功能描述: 设定OpenId<br>
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/resetRedis", method = RequestMethod.GET)
	@ResponseBody
	public AjaxObject resetRedis(String index, HttpServletResponse response) {

		AjaxObject ajaxObject = new AjaxObject();
		
		// 获取Cookie对象
    	CookieObject cookie = super.getCookie(response);
		String cxId = cookie.getCxId();
    	
		// 缓存锁
		boolean lock = redisLockService.lock(index, cxId);
		// 未获得锁
		if (!lock) {
			// 没有抢到锁
			ajaxObject.setMsg("前次重置未结束，请稍后!");
			redisLockService.setErrorMsg(cxId);
			logger.info(cxId + ":" + "前次重置未结束，请稍后!");
			return ajaxObject;
		}
		
		String errMsg = "";
		
		if (StringUtils.isEmpty(index)) {
			index = redisJobService.REDIS_ALL;
		}
		switch(index) {
		case "shopping": // 刷新购物车缓存
//			shoppingCartService.remove(key);
			break;
		case "mail": // 刷新邮件服务
//			if (!mailService.init()) {
//				errMsg = "邮件重置失败";
//			}
			break;
		default:
			errMsg = redisJobService.resetRedis(index);
			break;
		}
		
		if (StringUtils.isEmpty(errMsg)) {
			redisLockService.complete(index);
		} else {
			redisLockService.error(index, errMsg);
		}
		
		// 需要轮询
		ajaxObject.setResult(AjaxObject.FAILD);
		ajaxObject.setMsg(redisJobService.getInProgressMsg());
		
		return ajaxObject;
	}
	
	/***
	 * 
	 * 功能描述: 设定OpenId<br>
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/getRedisResponse", method = RequestMethod.GET)
	@ResponseBody
	public AjaxObject getRedisResponse(String index, HttpServletResponse response) {
		AjaxObject ajaxObject = new AjaxObject();
		
		// 获取Cookie对象
    	CookieObject cookie = super.getCookie(response);
		String cxId = cookie.getCxId();
		
		// 如果存在错误消息
		if (redisLockService.getErrorMsg(cxId)) {
			ajaxObject.setMsg("前次重置未结束，请稍后!");
			logger.info(cxId + ":" + "前次重置未结束，请稍后!轮询");
			return ajaxObject;
		}
		
		RedisLockVo redisLock = redisLockService.getStatus(index);
		
		// 如果cxid和锁里的内容不一致
		if (redisLock != null && !cxId.equals(redisLock.getCxId())) {
			// 需要轮询
			ajaxObject.setResult(AjaxObject.FAILD);
			return ajaxObject;
		}
			
		// 锁没有，需要轮询
		if (redisLock == null) {
//			ajaxObject.setMsg("重置异常！");
//			return ajaxObject;
			// 需要轮询
			ajaxObject.setResult(AjaxObject.FAILD);
			return ajaxObject;
		}
		
		long cost = 0;
		
		switch(redisLock.getStatus()) {
		case RedisLockService.RESET_LOCK_STATUS_COMPLETE:
			cost = redisLock.getEndTimeMillis() - redisLock.getStartTimeMillis();
			redisLockService.delete(index);
			ajaxObject.setMsg("重置成功！耗时"+(cost%1000==0?cost/1000:cost/1000+1)+"秒");
			break;
		case RedisLockService.RESET_LOCK_STATUS_ERROR:
			cost = redisLock.getEndTimeMillis() - redisLock.getStartTimeMillis();
			redisLockService.delete(index);
			ajaxObject.setMsg("重置失败！耗时"+(cost%1000==0?cost/1000:cost/1000+1)+"秒;"
					+StringUtils.trimToEmpty(redisLock.getErrMsg()));
			break;
		case RedisLockService.RESET_LOCK_STATUS_INPROGRESS:
			// 需要轮询
			ajaxObject.setResult(AjaxObject.FAILD);
			ajaxObject.setMsg(redisJobService.getInProgressMsg());
			break;
		}
				
		return ajaxObject;
	}
	

	/***
	 * 
	 * 功能描述: 验证页<br>
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/verify", method = RequestMethod.GET)
	public String verify(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String uid = CookieUtil.getCookieByName(request, CookieUtil.VERIFY_UID);
		if (StringUtils.isEmpty(uid)) {
			uid = UUID.randomUUID().toString();
			CookieUtil.addCookieMaxAgeDay(response, CookieUtil.VERIFY_UID, uid);
		}
		
		model.addAttribute("uid", uid);
		
		return VERIFY_FTL;
	}
    
	/***
	 * 
	 * 功能描述: 获取Redis<br>
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/verifySend", method = RequestMethod.GET)
	@ResponseBody
	public AjaxObject verifySend(HttpServletRequest request) {
		
		AjaxObject ajaxObject = new AjaxObject();
		
		// 判断是否有唯一键
		String uid = CookieUtil.getCookieByName(request, CookieUtil.VERIFY_UID);
		if (StringUtils.isEmpty(uid)) {
			ajaxObject.setResult(AjaxObject.FAILD);
			return ajaxObject;
		}
		
		RedisVerifyVo redisVerify = new RedisVerifyVo();
		redisVerify.setUid(uid);
		redisVerify.setHost(request.getHeader("HOST"));
		redisVerify.setIp(request.getRemoteAddr());
		
		// 创建验证码
		boolean ret = redisVerifyService.create(redisVerify);
		
		if (!ret) {
			ajaxObject.setResult(AjaxObject.FAILD);
		}
		
		return ajaxObject;
	}
	
	/***
	 * 
	 * 功能描述: 获取Redis<br>
	 * 〈功能详细描述〉
	 * 
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping(value = "/verifyCheck", method = RequestMethod.GET)
	@ResponseBody
	public AjaxObject verifySend(String code, HttpServletRequest request, HttpServletResponse response) {
		
		AjaxObject ajaxObject = new AjaxObject();
		
		// 判断是否有唯一键
		String uid = CookieUtil.getCookieByName(request, CookieUtil.VERIFY_UID);
		if (StringUtils.isEmpty(uid)) {
			ajaxObject.setResult(AjaxObject.FAILD);
			return ajaxObject;
		}
		
		// 判断是否有验证码
		code = StringUtils.trimToEmpty(code);
		if (StringUtils.isEmpty(code)) {
			ajaxObject.setResult(AjaxObject.FAILD);
			return ajaxObject;
		}
		
		RedisVerifyVo redisVerify = new RedisVerifyVo();
		redisVerify.setUid(uid);
		redisVerify.setIp(request.getRemoteAddr());
		redisVerify.setCode(code);
		
		// 验证
		boolean ret = redisVerifyService.verify(redisVerify);
		
		if (!ret) {
			ajaxObject.setResult(AjaxObject.FAILD);
		} else {
			CookieUtil.addCookieMaxAgeDay(response, CookieUtil.VERIFY_CODE, code);
		}
		
		return ajaxObject;
	}
	
//	
//	/***
//	 * 
//	 * 功能描述: 设定OpenId<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/createMenu", method = RequestMethod.GET)
//	@ResponseBody
//	public AjaxObject createMenu() {
//
//		AjaxObject ajaxObject = new AjaxObject();
//		
//		String resultStr = wxMenuService.createMenuForWX();
//		if (!resultStr.contains("\"errcode\":0")) {
//			ajaxObject.setResult(AjaxObject.FAILD);
//		}
//
//		return ajaxObject;
//	}
//	
//	/***
//	 * 
//	 * 功能描述: 设定OpenId<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/resetRedis", method = RequestMethod.GET)
//	@ResponseBody
//	public AjaxObject resetRedis(String index, HttpServletResponse response) {
//
//		AjaxObject ajaxObject = new AjaxObject();
//		
//		// 获取Cookie对象
//    	CookieObject cookie = super.getCookie(response);
//		String key = cookie.getKey();
//		
//		boolean result = true;
//		
//		switch(index) {
//		case "shopping": // 刷新购物车缓存
//			shoppingCartService.remove(key);
//			break;
//		case "mail": // 刷新邮件服务
//			result = mailService.init();
//			break;
//		default:
//			result = redisJobService.resetRedis(index);
//			break;
//		}
//
//		if (!result) {
//			ajaxObject.setResult(AjaxObject.FAILD);
//			ajaxObject.setMsg("重置失败!");
//		}
//		
//		return ajaxObject;
//	}
//	
//	/***
//	 * 
//	 * 功能描述: 获取不同场景参数（Base64）<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/getParam", method = RequestMethod.GET)
//	@ResponseBody
//	public AjaxObject getParam(CustomCxbInfoVo customCxbInfo, HttpServletResponse response) {
//		
//		AjaxObject ajaxObject = new AjaxObject();
//		
//		String json = JSONParser.toJSONString(customCxbInfo);
//		json = Base64Operate.toBASE64(json);
//		json = json.replaceAll("\r\n", "");
//		ajaxObject.setObj(json);
//		
//		return ajaxObject;
//	}
//	
//	/***
//	 * 
//	 * 功能描述: 更新缓存信息<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/reset", method = RequestMethod.GET)
//	public String reset() {
//		return RESET_FTL;
//	}
//	
//	
//	/***
//	 * 
//	 * 功能描述: 更新缓存信息<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/reset_{index}", method = RequestMethod.GET)
//	@ResponseBody
//	public String resetRedis(@PathVariable String index) {
//		
//		boolean result = false;
//		String name = "";
//		
//		switch(index) {
//		case "store": // 刷新门店相关缓存
//			name = "门店相关";
//			break;
//		case "product": // 刷新服务相关缓存
//			name = "服务相关";
//			break;
//		case "carModel": // 刷新车型相关缓存
//			name = "车型相关";
//			break;
//		case "reference": // 刷新业务参照缓存
//			name = "业务参照";
//			break;
//		case "maintenance": // 刷新保养手册缓存
//			name = "保养手册";
//			break;
//		case "artificer": // 刷新技师相关缓存
//			name = "技师相关";
//			break;
//		case "sysReference": // 刷新系统参照缓存
//			name = "系统参照";
//			break;
//		}
//		
//		result = redisJobService.resetRedis(index);
//		
//		if (result) {
//			return name + "更新成功";
//		} else {
//			return name + "更新失败";
//		}
//	}
//	
//	/***
//	 * 
//	 * 功能描述: 获取Redis<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/getRedis", method = RequestMethod.GET)
//	@ResponseBody
//	public AjaxObject getRedis(String key, HttpServletResponse response) {
//		
//		AjaxObject ajaxObject = new AjaxObject();
//		
//		boolean exists = redisClient.exists(key);
//		
//		if (!exists) {
//			ajaxObject.setResult(AjaxObject.FAILD);
//			return ajaxObject;
//		}
//		
//		String type = redisClient.type(key).toUpperCase();
//		String value = "";
//
//		if ("STRING".equals(type)) {
//			value = redisClient.get(key);
//		} else if("HASH".equals(type)) {
//			value = JSONParser.toJSONString(redisClient.hgetAll(key));
//			value = value.replaceAll("\"\\[", "\\[");
//			value = value.replaceAll("\\]\"", "\\]");
//			value = value.replaceAll("\"\\{", "\\{");
//			value = value.replaceAll("\\}\"", "\\}");
//			value = value.replaceAll("\\\\\"", "\"");
//		}
//		
//		if (StringUtils.isEmpty(value)) {
//			ajaxObject.setResult(AjaxObject.FAILD);
//		} else {
//			ajaxObject.setObj(value);
//		}
//		
//		return ajaxObject;
//	}
//	
//	/***
//	 * 
//	 * 功能描述: 获取Redis<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@RequestMapping(value = "/sendMail", method = RequestMethod.GET)
//	@ResponseBody
//	public AjaxObject sendMail(MailVo mail, HttpServletResponse response) {
//		
//		AjaxObject ajaxObject = new AjaxObject();
//		
//		boolean ret = mailService.send(mail);
//		
//		if (!ret) {
//			ajaxObject.setResult(AjaxObject.FAILD);
//		}
//		
//		return ajaxObject;
//	}
    
   
	@RequestMapping(value = "/querySysReferenceForRestFul", method = RequestMethod.POST)
	public String querySysReferenceForRestFul(@RequestBody String sysReferenceDetailVo
			, HttpServletResponse response) {
		HashMap<String, Object> ajaxObject = new HashMap<String, Object>();
	
		if (StringUtils.isEmpty("")) {
			ajaxObject.put("status", "error");
			ajaxObject.put("message", "信息编码为空");
		}
        try {
        	
        	
        	response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Pragma", "No-cache");
	        response.setHeader("Cache-Control", "no-cache");
	        response.setDateHeader("Expires", 0);
			response.getWriter().write(JSONParser.toJSONString(ajaxObject));
			response.getWriter().flush();
		} catch (Exception e) {
			logger.info("querySysReferenceForRestFul error:{}", e.getMessage());
		}
        
        return null;
	}
	
	/**
	 * 获得主机IP
	 *
	 * @return String
	 */
	private boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}
	/**
	 * 获取本机ip地址，并自动区分Windows还是linux操作系统
	 * 
	 * @return String
	 */
	private String getLocalIP() {
		String sIP = "";
		InetAddress ip = null;
		try {
			// 如果是Windows操作系统
			if (isWindowsOS()) {
				ip = InetAddress.getLocalHost();
			}
			// 如果是Linux操作系统
			else {
				boolean bFindIP = false;
				Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) NetworkInterface
						.getNetworkInterfaces();
				while (netInterfaces.hasMoreElements()) {
					if (bFindIP) {
						break;
					}
					NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
					// ----------特定情况，可以考虑用ni.getName判断
					// 遍历所有ip
					Enumeration<InetAddress> ips = ni.getInetAddresses();
					while (ips.hasMoreElements()) {
						ip = (InetAddress) ips.nextElement();
						if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() // 127.开头的都是loopback地址
								&& ip.getHostAddress().indexOf(":") == -1) {
							bFindIP = true;
							break;
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null != ip) {
			sIP = ip.getHostAddress();
		}
		return sIP;
	}
	
	/**
	 * 获取IP地址的方法
	 * 
	 * @param request
	 *            请求对象
	 * @return IP地址
	 */
	private String getIpAddr(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
