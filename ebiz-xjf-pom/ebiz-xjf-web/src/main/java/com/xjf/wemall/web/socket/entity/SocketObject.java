/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: SocketObject.java
 * Author:   baowenzhou
 * Date:     2016年01月19日 上午10:50:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.web.socket.entity;

/**
 * Socket对象<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SocketObject {
	
	/** 操作类型 */
    private String action;
	/** 操作内容 */
    private String value;
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
    
}
