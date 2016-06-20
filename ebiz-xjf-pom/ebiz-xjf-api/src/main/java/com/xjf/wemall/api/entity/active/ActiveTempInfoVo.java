/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ButtonInfoVo.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.active;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 活动实体 <br>
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ActiveTempInfoVo implements Serializable {

	private static final long serialVersionUID = -1158405890125055698L;

	/** 标题 */
	private String title;

	/** 模板code */
	private String tempCode;

	/** JS列表 */
	private List<ActiveItemInfoVo> jsList;

	/** CSS列表 */
	private List<ActiveItemInfoVo> cssList;

	/** BODY列表 */
	private List<ActiveItemInfoVo> bodyList;

	private Map<String, String> paramMap;

	public Map<String, String> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTempCode() {
		return tempCode;
	}

	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}

	public List<ActiveItemInfoVo> getJsList() {
		return jsList;
	}

	public void setJsList(List<ActiveItemInfoVo> jsList) {
		this.jsList = jsList;
	}

	public List<ActiveItemInfoVo> getCssList() {
		return cssList;
	}

	public void setCssList(List<ActiveItemInfoVo> cssList) {
		this.cssList = cssList;
	}

	public List<ActiveItemInfoVo> getBodyList() {
		return bodyList;
	}

	public void setBodyList(List<ActiveItemInfoVo> bodyList) {
		this.bodyList = bodyList;
	}
}
