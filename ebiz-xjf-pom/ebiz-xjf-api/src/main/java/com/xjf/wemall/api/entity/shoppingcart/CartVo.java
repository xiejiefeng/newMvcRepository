/*
 * Copyright (C), 2013-2016, 上海汽车集团股份有限公司
 * FileName: CartVo.java
 * Author:   baowenzhou
 * Date:     2016年05月06日 上午8:50:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.shoppingcart;

import java.io.Serializable;

/**
 * 购物车对象<br>
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CartVo implements Serializable {

	/**
	 */
	private static final long serialVersionUID = -104057261997349663L;
	
	/** 服务项目集合 */
	private String serviceCodes;

	/** SPU编码 */
	private String spuCode;
	
	/** 组号 */
	private String groupNum;
	
	/** 组号集合 */
	private String groupNums;

	public String getServiceCodes() {
		return serviceCodes;
	}

	public void setServiceCodes(String serviceCodes) {
		this.serviceCodes = serviceCodes;
	}

	public String getSpuCode() {
		return spuCode;
	}

	public void setSpuCode(String spuCode) {
		this.spuCode = spuCode;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}

	public String getGroupNums() {
		return groupNums;
	}

	public void setGroupNums(String groupNums) {
		this.groupNums = groupNums;
	}

}
