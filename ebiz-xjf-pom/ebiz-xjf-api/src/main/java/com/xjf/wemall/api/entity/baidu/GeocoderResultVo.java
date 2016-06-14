/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: GeocoderResult.java
 * Author:   baowenzhou
 * Date:     2015年3月10日 下午14:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.baidu;

/**
 * 百度地图API，定位信息<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class GeocoderResultVo {
	
	// 经纬度信息
	private LocationInfoVo location;
	
	// 结构化地址信息
	private String formatted_address;
	
	// 所在商圈信息
	private String business;
	
	// 详细地址
	private AddressInfoVo addressComponent;
	
	// 城市代码
	private String cityCode;

	public LocationInfoVo getLocation() {
		return location;
	}

	public void setLocation(LocationInfoVo location) {
		this.location = location;
	}

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public AddressInfoVo getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressInfoVo addressComponent) {
		this.addressComponent = addressComponent;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
