/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: StoreInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.store;

import java.io.Serializable;

/**
 * 门店-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StoreInfoVo implements Serializable{

	private static final long serialVersionUID = -7923995967639193240L;
	
	// 门店id
	private String storeId;
	// 门店code
	private String storeNo;
	// 门店
	private String storeName;
	// 门店简介
	private String intro;	
	// 地址
	private String address;
	// 门店电话
	private String telephone;
	// 手机
	private String mobile;
	// 营业时间
	private String businesstime;
	// 横坐标
	private String localX;
	// 纵坐标
	private String localY;
	// 离我的距离
	private Double distanceFromMe;
	// 图片1
	private String image1;
	// 图片2
	private String image2;
	// 图片3
	private String image3;
	// 图片4
	private String image4;
	
	// 百度城市编码
	private String baiduCityCode;
	// 销售区域编码
	private String areaCode;
	// 销售区域名称
	private String areaName;
	
	// 省ID
	private long provinceId;
	// 省名称
	private String provinceName;
	// 市ID
	private long cityId;
	// 市名称
	private String cityName;
	// 区ID
	private long distId;
	// 区名称
	private String distName;
	
	// 门店类型
	private String storeType;
	
	/******************************530*******************************************/
	// 门店评价分数
    private String storeScore;
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBusinesstime() {
		return businesstime;
	}
	public void setBusinesstime(String businesstime) {
		this.businesstime = businesstime;
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
	public Double getDistanceFromMe() {
		return distanceFromMe;
	}
	public void setDistanceFromMe(Double distanceFromMe) {
		this.distanceFromMe = distanceFromMe;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getImage3() {
		return image3;
	}
	public void setImage3(String image3) {
		this.image3 = image3;
	}
	public String getImage4() {
		return image4;
	}
	public void setImage4(String image4) {
		this.image4 = image4;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getBaiduCityCode() {
		return baiduCityCode;
	}
	public void setBaiduCityCode(String baiduCityCode) {
		this.baiduCityCode = baiduCityCode;
	}
	public long getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(long provinceId) {
		this.provinceId = provinceId;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public long getCityId() {
		return cityId;
	}
	public void setCityId(long cityId) {
		this.cityId = cityId;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public long getDistId() {
		return distId;
	}
	public void setDistId(long distId) {
		this.distId = distId;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
    public String getStoreScore() {
        return storeScore;
    }
    public void setStoreScore(String storeScore) {
        this.storeScore = storeScore;
    }
}
