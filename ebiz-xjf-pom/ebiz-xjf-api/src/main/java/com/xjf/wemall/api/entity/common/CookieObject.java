/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CookieObject.java
 * Author:   baowenzhou
 * Date:     2015年08月14日 上午10:50:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.common;

/**
 * Cookie对象<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CookieObject {
	
	/** 微信4/车享宝6/车享汇7 */
    private String openType;
	/** 微信openId */
    private String openId;
    /** 车享ID */
    private String cxId;
    /** 经度 */
    private String longitude;
    /** 纬度 */
    private String latitude;
    /** 客户标识 */
    private String key;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public String getCxId() {
		return cxId;
	}

	public void setCxId(String cxId) {
		this.cxId = cxId;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
