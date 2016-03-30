/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: WemallListener.java
 * Author:   wanglijun
 * Date:     2016年03月17日 下午4:20:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.listener;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



//import com.xjf.wemall.api.constant.WemallConstants;
//import com.saic.wemall.api.entity.sysreference.SysReferenceDetailRestFulVo;
import com.xjf.wemall.event.SysRefEvent;
import com.xjf.wemall.service.staticvalue.api.StaticValueService;
//import com.saic.wemall.service.staticvalue.api.StaticValueService;
//import com.saic.wemall.service.sysreference.api.SysReferenceService;

/**
 * Spring 事件加载<br>
 * 〈功能详细描述〉
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class WemallListener implements ApplicationListener<ApplicationEvent> {

	// 推送事件
	// ctx.publishEvent(new SysRefEvent(ctx, refCode, list));
	
	/** 日志类 */
	protected final Logger logger = LoggerFactory.getLogger(super.getClass());

	/** 容器名称 */
	private String ROOT_CONTEXT = "Root WebApplicationContext";

	/** 需加载至内存的大类Code */
	private String[] SYS_CODE = {"LOGIN_CHK_URL",
			"OPENTYPE", "BAIDU","CRMTEL" };

	/** 参照信息 */
//	@Autowired
//	private SysReferenceService sysReferenceService;

	/** 内存信息 */
	@Autowired
	private StaticValueService staticValueService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		// 容器初始化
		if (event instanceof ContextRefreshedEvent) {
			ContextRefreshedEvent contextRefreshedEvent = (ContextRefreshedEvent) event;
			String displayName = contextRefreshedEvent.getApplicationContext().getDisplayName();
			if (ROOT_CONTEXT.equals(displayName)) {
				this.initSysRef2Cache();
			}
		}
		// 参数加载
		if (event instanceof SysRefEvent) {
			SysRefEvent sysRefEvent = (SysRefEvent) event;
			this.reloadSysRef2Cache(sysRefEvent);
		}
	}

	/***
	 * 
	 * 功能描述:初始化数据 <br>
	 * 〈功能详细描述〉
	 * 
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private void initSysRef2Cache() {
//		List<SysReferenceDetailRestFulVo> list = null;
//		for (String code : SYS_CODE) {
//			logger.info("初始化系统参数至内存:{}", code);
//			list = sysReferenceService.querySysReferenceValueForList(code);
//			staticValueService.setSysReference(code, list);
//		}
	}

	/**
	 * 
	 * 功能描述:加载数据至内存 <br>
	 * 〈功能详细描述〉
	 *
	 * @param sysRefEvent
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private void reloadSysRef2Cache(SysRefEvent sysRefEvent) {
//		// 单一大类更新
//		if (StringUtils.isNotEmpty(sysRefEvent.getCode())) {
//			String code = sysRefEvent.getCode();
//			List<SysReferenceDetailRestFulVo> list = sysRefEvent.getDetailList();
//
//			if (ArrayUtils.contains(SYS_CODE, code)) {
//				logger.info("加载系统参数至内存:{}", code);
//				staticValueService.setSysReference(code, list);
//			}
//		}
//		// 重置所有大类
//		else if (CollectionUtils.isNotEmpty(sysRefEvent.getDetailList())) {
//			List<SysReferenceDetailRestFulVo> list = null;
//			for (String code : SYS_CODE) {
//				logger.info("加载系统参数至内存:{}", code);
//				list = sysReferenceService.querySysReferenceValueForList(code);
//				staticValueService.setSysReference(code, list);
//			}
//		}
	}
}
