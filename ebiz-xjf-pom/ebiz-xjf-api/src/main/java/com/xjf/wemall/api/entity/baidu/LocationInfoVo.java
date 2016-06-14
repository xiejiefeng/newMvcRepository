/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LocationInfo.java
 * Author:   baowenzhou
 * Date:     2015年3月10日 下午14:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.baidu;

/**
 * 百度地图API，经纬度信息<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LocationInfoVo {
    
	// 纬度坐标
	private String lat;
	
	// 经度坐标
	private String lng;

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}
}
