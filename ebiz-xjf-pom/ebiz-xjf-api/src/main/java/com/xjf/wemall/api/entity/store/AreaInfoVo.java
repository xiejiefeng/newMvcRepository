/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AreaInfoVo.java
 * Author:   baowenzhou
 * Date:     2015年3月20日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.store;

import java.io.Serializable;
import java.util.List;

/**
 * 区域-实体类 <br>
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AreaInfoVo implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 6510186369629424183L;

	// 区域编码
	private String areaCode;

	// 区域名称
	private String areaName;

	// 城市编码
	private String cityCode;

	// 城市列表
	List<StoreInfoVo> storeList;

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

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public List<StoreInfoVo> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<StoreInfoVo> storeList) {
		this.storeList = storeList;
	}
}
