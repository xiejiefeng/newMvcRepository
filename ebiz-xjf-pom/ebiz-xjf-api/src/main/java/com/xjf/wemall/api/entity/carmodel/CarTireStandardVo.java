/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CarTireStandardVo.java
 * Author:   baowenzhou
 * Date:     2015年12月17日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.carmodel;

import java.io.Serializable;

/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CarTireStandardVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6292908311055022209L;
   	
   	// 轮胎规格
  	private String tireStandard;
  	
  	// 是否前轮
  	private boolean isFront;
  	
  	// 是否后轮
   	private boolean isRear;

	public String getTireStandard() {
		return tireStandard;
	}

	public void setTireStandard(String tireStandard) {
		this.tireStandard = tireStandard;
	}

	public boolean isFront() {
		return isFront;
	}

	public void setFront(boolean isFront) {
		this.isFront = isFront;
	}

	public boolean isRear() {
		return isRear;
	}

	public void setRear(boolean isRear) {
		this.isRear = isRear;
	}
 	
}
