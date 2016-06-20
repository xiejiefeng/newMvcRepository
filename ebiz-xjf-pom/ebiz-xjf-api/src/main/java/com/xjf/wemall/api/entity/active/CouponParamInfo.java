package com.xjf.wemall.api.entity.active;

public class CouponParamInfo {
	// 行号
	private String rowNum;

	// 用户姓名
	private String userName;

	// 车享ID
	private String cxId;

	// 券模版号
	private String couponTemplateNo;

	// 券模版名称
	private String couponTempName;

	// 发放数量
	private String grantNum;

	// 投放结果(1：成功，0失败，默认为0)
	private String grantResult;

	public CouponParamInfo() {
		this.grantNum = "1";
		this.grantResult = "0";
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public String getCxId() {
		return cxId;
	}

	public void setCxId(String cxId) {
		this.cxId = cxId;
	}

	public String getCouponTemplateNo() {
		return couponTemplateNo;
	}

	public void setCouponTemplateNo(String couponTemplateNo) {
		this.couponTemplateNo = couponTemplateNo;
	}

	public String getGrantNum() {
		return grantNum;
	}

	public void setGrantNum(String grantNum) {
		this.grantNum = grantNum;
	}

	public String getGrantResult() {
		return grantResult;
	}

	public void setGrantResult(String grantResult) {
		this.grantResult = grantResult;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCouponTempName() {
		return couponTempName;
	}

	public void setCouponTempName(String couponTempName) {
		this.couponTempName = couponTempName;
	}

}
