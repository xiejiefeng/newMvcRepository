/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CxjBaseResult.java
 * Author:   baowenzhou
 * Date:     2015年07月01日 上午9:32:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.service.entity.alibabamap;

import java.io.Serializable;

/**
 * 业务系统基础-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BaseResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4727291037637625274L;
	
	/**
	 * 成功
	 */
	public static final String STATUS_SUCCESS = "success";
	
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 消息
	 */
	private String message;
	/**
	 * 内容
	 */
	private T content;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public T getContent() {
		return content;
	}
	public void setContent(T content) {
		this.content = content;
	}
	
}
