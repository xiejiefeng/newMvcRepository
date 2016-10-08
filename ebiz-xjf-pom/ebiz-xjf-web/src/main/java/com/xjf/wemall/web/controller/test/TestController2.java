/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ProductController.java
 * Author:   yzq
 * Date:     2014年8月21日 下午5:29:17
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.controller.test;


import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Array;
import com.xjf.wemall.annotation.NeedLogin;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.common.AjaxObject;
import com.xjf.wemall.api.util.Base64Operate;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.URLUtil;
import com.xjf.wemall.web.controller.BaseController;
import com.xjf.wemall.web.factory.BeanFactory;

/**
 * 系统参数controller<br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/test2")
public class TestController2 extends BaseController {
	@Autowired
	private BeanFactory beanFactory;
    
	@RequestMapping(value = "/init")
	public String init(HttpServletRequest request) {
		return "/test/test.ftl";
	}
	
    @RequestMapping(value = "/test")
    @ResponseBody
    public AjaxObject judgeWorkdayByInputDate(HttpServletRequest request, @RequestParam(value="inputDate", required=false) String inputDate2) {
		String inputDate = request.getParameter("inputDate");
		AjaxObject aj = new AjaxObject();
		aj.setMsg(inputDate2);
		aj.setObj(inputDate);
		return aj;
	}
    
}