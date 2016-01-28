/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisVerifyVo.java
 * Author:   baowenzhou
 * Date:     2016年01月20日 上午10:18:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.redis;

import java.io.Serializable;

/**
 * Redis验证-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RedisVerifyVo implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = -1952912124045719237L;
	
	// 关键字
	private String uid;
	// 验证码
	private String code;
	// 创建时间
	private String createTime;
	// 验证时间
	private String verifyTime;
	// 状态
	private int status;
	// IP
	private String ip;
	// HOST
	private String host;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getVerifyTime() {
		return verifyTime;
	}
	public void setVerifyTime(String verifyTime) {
		this.verifyTime = verifyTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
}
