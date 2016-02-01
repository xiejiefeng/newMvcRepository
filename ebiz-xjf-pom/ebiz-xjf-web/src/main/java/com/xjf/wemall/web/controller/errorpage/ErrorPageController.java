/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ErrorPageController.java
 * Author:   baowenzhou
 * Date:     2014年8月25日 下午4:39:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.controller.errorpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xjf.wemall.web.controller.BaseController;

/**
 * 错误页面<br>
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
public class ErrorPageController extends BaseController {
	/***
	 * 错误页面404
	 */
	private static final String ERRORPAGE404_FTL = "/common/errorpage.ftl";

	/***
	 * 错误页面
	 */
	private static final String ERRORPAGE_FTL = "/common/error.ftl";

	/***
	 * 敬请期待页面
	 */
	private static final String COMING_SOON_FTL = "/common/comingSoon.ftl";

	/***
	 * 
	 * 功能描述:跳转404页面 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping("/errorPage404")
	public String errorPage() {
		return ERRORPAGE404_FTL;
	}

	/***
	 * 
	 * 功能描述:跳转用户错误 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping("/error")
	public String error() {
		return ERRORPAGE_FTL;
	}

	/***
	 * 
	 * 功能描述:敬请期待 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@RequestMapping("/comingSoon")
	public String comingSoon() {
		return COMING_SOON_FTL;
	}
}
