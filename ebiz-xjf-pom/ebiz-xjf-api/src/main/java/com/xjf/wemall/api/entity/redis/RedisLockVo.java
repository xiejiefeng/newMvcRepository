/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisLockVo.java
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
 * Redis锁-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RedisLockVo implements Serializable{
	
	/**
	 */
	private static final long serialVersionUID = -1952912124045719237L;
	
	// 关键字
	private String key;
	// 关键字
	private String cxId;
	// 状态
	private int status;
	// 执行开始时间
	private Long startTimeMillis;
	// 执行结束时间
	private Long endTimeMillis;
	// 错误信息
	private String errMsg;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getStartTimeMillis() {
		return startTimeMillis;
	}
	public void setStartTimeMillis(Long startTimeMillis) {
		this.startTimeMillis = startTimeMillis;
	}
	public Long getEndTimeMillis() {
		return endTimeMillis;
	}
	public void setEndTimeMillis(Long endTimeMillis) {
		this.endTimeMillis = endTimeMillis;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getCxId() {
		return cxId;
	}
	public void setCxId(String cxId) {
		this.cxId = cxId;
	}
	
}
