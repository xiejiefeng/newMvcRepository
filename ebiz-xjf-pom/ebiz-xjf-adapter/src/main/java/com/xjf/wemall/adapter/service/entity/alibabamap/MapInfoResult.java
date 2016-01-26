/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CxjCustResult.java
 * Author:   baowenzhou
 * Date:     2015年07月01日 上午9:32:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.adapter.service.entity.alibabamap;


/**
 * 门店技师查询-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MapInfoResult extends BaseResult<MapInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364638322412086091L;
	
	private String lon;
	private String level;
	private String address;
	private String cityName;
	private String alevel;
	private String lat;
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAlevel() {
		return alevel;
	}
	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}

}
