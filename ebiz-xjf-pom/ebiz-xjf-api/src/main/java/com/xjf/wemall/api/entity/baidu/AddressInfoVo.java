/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AddressInfo.java
 * Author:   baowenzhou
 * Date:     2015年3月10日 下午14:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.baidu;

/**
 * 百度地图API，详细地址信息<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AddressInfoVo {
    
	// 城市名
	private String city;
	
	// 区县名
	private String district;
	
	// 省名
	private String province;
	
	// 街道名
	private String street;
	
	// 街道门牌号
	private String street_number;
	
	// 国家名
	private String country;
		
	// 国家代码
	private String country_code;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet_number() {
		return street_number;
	}

	public void setStreet_number(String street_number) {
		this.street_number = street_number;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry_code() {
		return country_code;
	}

	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}

}
