/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CustomInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月22日 上午10:33:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CustomInfoVo implements Serializable {

    /**
     */
    private static final long serialVersionUID = -502804796037460530L;
    
    // 微信号
    private String wxNo;
    
    // openId类型（4：微信，6：车享宝）
    private String openType;

    // 客户ID
    private String custId;
   
    // 客户名称
    private String custName;
    
    // 手机
    private String mobilePhone;
    
    // 车享ID
    private String cxId;
    
    // 用户账户
    private String userName;
    
	// 用户密码
    private String passwd;
    
    // 车辆信息
    private List<CarModelInfoVo> carInfo = new ArrayList<CarModelInfoVo>();
    
    public String getWxNo() {
		return wxNo;
	}

	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	public String getOpenType() {
		return openType;
	}

	public void setOpenType(String openType) {
		this.openType = openType;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCxId() {
		return cxId;
	}

	public void setCxId(String cxId) {
		this.cxId = cxId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<CarModelInfoVo> getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(List<CarModelInfoVo> carInfo) {
		this.carInfo = carInfo;
	}

}
