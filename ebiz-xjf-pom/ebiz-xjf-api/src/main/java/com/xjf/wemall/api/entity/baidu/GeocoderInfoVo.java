/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Geocoder.java
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
public class GeocoderInfoVo {
	
	// 微信openId 或 车享Id
	private String userId;
    
	// 结果状态值
	private String status;
	
	// 定位信息
	private GeocoderResultVo result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GeocoderResultVo getResult() {
		return result;
	}

	public void setResult(GeocoderResultVo result) {
		this.result = result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
