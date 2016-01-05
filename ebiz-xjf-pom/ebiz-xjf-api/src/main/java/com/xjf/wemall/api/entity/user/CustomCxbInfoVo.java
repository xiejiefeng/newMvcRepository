/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CustomCxbInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月22日 上午10:33:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.user;

import java.io.Serializable;

/**
 * 车享宝用户信息<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustomCxbInfoVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -502804796037460530L;
    
    // 车享ID
    private String userId;
    // 客户名称
    private String custName;
    // 手机
    private String mobilePhone;
    // 经度
    private String localX;
    // 纬度
    private String localY;
    // 来源(-1：M站 0：车享家 1：车享汇 2：车享宝)
    private String sourceType;
    // 城市
    private String cityName;
    // openid
    private String openId;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getLocalX() {
		return localX;
	}
	public void setLocalX(String localX) {
		this.localX = localX;
	}
	public String getLocalY() {
		return localY;
	}
	public void setLocalY(String localY) {
		this.localY = localY;
	}
	public String getSourceType() {
		return sourceType;
	}
	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}

}
