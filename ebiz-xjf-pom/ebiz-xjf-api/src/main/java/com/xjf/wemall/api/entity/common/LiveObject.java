/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LiveObject.java
 * Author:   baowenzhou
 * Date:     2014-12-26 上午9:10:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Live800在线平台返回对象<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class LiveObject {

	/**
	 * 从微信公众平台API获取到的凭证
	 */
	private String access_token;

	/**
	 * 凭证有效时间，单位：秒
	 */
	private Long expires_in;

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
	public void success(String accessToken, Long expiresIn) {
		this.access_token = accessToken;
		this.expires_in = expiresIn;
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
	 * @return the access_token
	 */
	public String getAccess_token() {
		return access_token;
	}

	/**
	 * @param access_token
	 *            the access_token to set
	 */
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	/**
	 * @return the expires_in
	 */
	public Long getExpires_in() {
		return expires_in;
	}

	/**
	 * @param expires_in
	 *            the expires_in to set
	 */
	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
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
