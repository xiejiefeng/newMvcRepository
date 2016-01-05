/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserAreaVo.java
 * Author:   baowenzhou
 * Date:     2015年3月19日 下午14:44:03
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.user;

/**
 * 用户选择区域和门店<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserAreaVo {
	
	// 微信openId 或 车享Id
	private String userId;
    
	// 区域代码
	private String areaCode;
	
	// 区域名称
	private String areaName;
	
	// 门店代码
	private String storeNo;
	
	// 门店名称
	private String storeName;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName==null?"":areaName.replace("市", "");
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
