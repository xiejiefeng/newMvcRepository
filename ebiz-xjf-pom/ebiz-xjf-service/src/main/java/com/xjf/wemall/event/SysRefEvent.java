/*
 * Copyright (C), 2013-2016, 上海汽车集团股份有限公司
 * FileName: WemallListener.java
 * Author:   wanglijun
 * Date:     2016年03月17日 下午4:20:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.event;

import java.util.List;

import org.springframework.context.ApplicationEvent;

//import com.saic.wemall.api.entity.sysreference.SysReferenceDetailRestFulVo;

public class SysRefEvent extends ApplicationEvent {
	/**
	 */
	private static final long serialVersionUID = -3208900326832567582L;
	
	// 大类Code
	private String code;
	// 子类明细
//	private List<SysReferenceDetailRestFulVo> detailList;
	
	public SysRefEvent(Object source, String code) {
		super(source);
		this.code = code;
	}
	
//	public SysRefEvent(Object source, String code, List<SysReferenceDetailRestFulVo> detailList) {
//		super(source);
//		this.code = code;
//		this.detailList = detailList;
//	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public List<SysReferenceDetailRestFulVo> getDetailList() {
//		return detailList;
//	}

//	public void setDetailList(List<SysReferenceDetailRestFulVo> detailList) {
//		this.detailList = detailList;
//	}

}
