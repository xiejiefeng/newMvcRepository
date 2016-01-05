/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CarModelInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.carmodel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CarModelInfoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6292908311055022209L;

	// 车辆Id
	private String carId;
	// 车辆名称
	private String carName;
	// 车牌
    private String plates;
    
    // 厂家ID
    private String venderId;
    // 厂家
    private String venderName;
    // 品牌ID
    private String brandId;
    // 品牌首字母
    private String brandAlpha;
    // 品牌名称
    private String brandName;
    // 车系ID
    private String seriesId;
    // 车系ID
    private String seriesName;
    // 车型
    private String mouldId;
    // 车型
    private String mouldName;
    // 排量ID
    private String outputId;
    // 排量
    private String outputName;
    // 进气方式ID
    private String iomodeId;
    // 进气方式
    private String iomodeName;
    // 开始年份
    private String startYear;
    // 结束年份
    private String endYear;
    
    // 车型等级
    private String carLevel;
    // 年产
    private String carYear;
    
    // 2015/11/30 新增项目
    // MDM售后车型id
 	private String mdmId;
 	// 品牌Logo地址
  	private String logoUrl;
	// MDM车辆资产ID
  	private String assetId;
  	
  	// 是否认证（0：非认证 1：认证）
   	private String isVerificated;
   	
   	// 前轮胎规格
  	private String frontTireStandard;
  	// 后轮胎规格
  	private String rearTireStandard;
 	
 	// 子属性
 	private List<CarModelInfoVo> subCarModelList;
 	
 	// 轮胎规格列表
  	private Collection<CarTireStandardVo> tireStandardList;
 	
 	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getPlates() {
		return plates;
	}
	public void setPlates(String plates) {
		this.plates = plates;
	}
	public String getVenderId() {
		return venderId;
	}
	public void setVenderId(String venderId) {
		this.venderId = venderId;
	}
	public String getVenderName() {
		return venderName;
	}
	public void setVenderName(String venderName) {
		this.venderName = venderName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandAlpha() {
		return brandAlpha;
	}
	public void setBrandAlpha(String brandAlpha) {
		this.brandAlpha = brandAlpha;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSeriesId() {
		return seriesId;
	}
	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}
	public String getSeriesName() {
		return seriesName;
	}
	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}
	public String getMouldId() {
		return mouldId;
	}
	public void setMouldId(String mouldId) {
		this.mouldId = mouldId;
	}
	public String getMouldName() {
		return mouldName;
	}
	public void setMouldName(String mouldName) {
		this.mouldName = mouldName;
	}
	public String getOutputId() {
		return outputId;
	}
	public void setOutputId(String outputId) {
		this.outputId = outputId;
	}
	public String getOutputName() {
		return outputName;
	}
	public void setOutputName(String outputName) {
		this.outputName = outputName;
	}
	public String getIomodeId() {
		return iomodeId;
	}
	public void setIomodeId(String iomodeId) {
		this.iomodeId = iomodeId;
	}
	public String getIomodeName() {
		return iomodeName;
	}
	public void setIomodeName(String iomodeName) {
		this.iomodeName = iomodeName;
	}
	public String getStartYear() {
		return startYear;
	}
	public void setStartYear(String startYear) {
		this.startYear = startYear;
	}
	public String getEndYear() {
		return endYear;
	}
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	public String getCarLevel() {
		return carLevel;
	}
	public void setCarLevel(String carLevel) {
		this.carLevel = carLevel;
	}
	public String getCarYear() {
		return carYear;
	}
	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}
	public String getMdmId() {
		return mdmId;
	}
	public void setMdmId(String mdmId) {
		this.mdmId = mdmId;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getAssetId() {
		return assetId;
	}
	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}
	public List<CarModelInfoVo> getSubCarModelList() {
		return subCarModelList;
	}
	public void setSubCarModelList(List<CarModelInfoVo> subCarModelList) {
		this.subCarModelList = subCarModelList;
	}
	public String getIsVerificated() {
		return isVerificated;
	}
	public void setIsVerificated(String isVerificated) {
		this.isVerificated = isVerificated;
	}
	public String getFrontTireStandard() {
		return frontTireStandard;
	}
	public void setFrontTireStandard(String frontTireStandard) {
		this.frontTireStandard = frontTireStandard;
	}
	public String getRearTireStandard() {
		return rearTireStandard;
	}
	public void setRearTireStandard(String rearTireStandard) {
		this.rearTireStandard = rearTireStandard;
	}
	public Collection<CarTireStandardVo> getTireStandardList() {
		return tireStandardList;
	}
	public void setTireStandardList(Collection<CarTireStandardVo> tireStandardList) {
		this.tireStandardList = tireStandardList;
	}

}
