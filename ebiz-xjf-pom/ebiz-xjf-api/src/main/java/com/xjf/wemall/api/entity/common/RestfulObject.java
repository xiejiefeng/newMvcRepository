/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RestfulObject.java
 * Author:   baowenzhou
 * Date:     2015-07-07 上午9:10:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * restful返回对象<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RestfulObject {

	/**
	 * 错误代码
	 */
	private Integer errcode;

	/**
	 * 错误代码
	 */
	private String errmsg;

	
	/**
	 * 功能描述: 成功返回<br>
	 * 〈功能详细描述〉
	 *
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public void success(String errmsg) {
		this.errcode = 0;
		this.errmsg = errmsg;
	}
	
	/**
	 * 功能描述: 错误返回<br>
	 * 〈功能详细描述〉
	 *
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public void faild(String errmsg) {
		this.errcode = -1;
		this.errmsg = errmsg;
	}

	/**
	 * @return the errcode
	 */
	public Integer getErrcode() {
		return errcode;
	}

	/**
	 * @param errcode
	 *            the errcode to set
	 */
	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	/**
	 * @return the errmsg
	 */
	public String getErrmsg() {
		return errmsg;
	}

	/**
	 * @param errmsg
	 *            the errmsg to set
	 */
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
