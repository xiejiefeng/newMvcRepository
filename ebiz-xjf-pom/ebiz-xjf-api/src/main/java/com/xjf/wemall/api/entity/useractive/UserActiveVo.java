/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: SysReferenceDetailVo.java
 * Author:   xiejiefeng
 * Date:     2015年10月8日 上午10:50:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.useractive;

import java.util.List;

import com.xjf.wemall.api.entity.base.BaseVo;

/**
 * 用户对应活动活跃信息表Vo<br>
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserActiveVo extends BaseVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 分区表名字
	private String tableName;
	// 分区表索引
	private String tableIndex;
	// 活动编码
	private String activeCode;
	// openID
	private String openId;
	// 车享ID
	private String cxId;
	// 设备ID
	private String equId;
	// 来源
	private String sourceType;
	// 预留检查位1
	private String ckeckId1;
	// 预留检查位2
	private String ckeckId2;
	// 预留检查位3
	private String ckeckId3;
	// 预留检查位4
	private String ckeckId4;
	// 预留检查位5
	private String ckeckId5;

	/************************************** 以下是查询条件 **************************************************/
	// 开始行数
	private String rowStart;
	// 查询行数
	private String rowCount;
	// 活动附加内容
	private List<?> addInfoList;
	// 活动编码集合
	private List<?> codeList;
	// 活动编码前缀
	private String prefixActiveCode;

//	public UserActiveVo() {
//		// 分区表名字
//		this.tableName = "";
//		// 分区表索引
//		this.tableIndex = "";
//		// 活动编码
//		this.activeCode = "";
//		// openID
//		this.openId = "";
//		// 车享ID
//		this.cxId = "";
//		// 设备ID
//		this.equId = "";
//		// 来源
//		this.sourceType = "";
//		// 预留检查位1
//		this.ckeckId1 = "";
//		// 预留检查位2
//		this.ckeckId2 = "";
//		// 预留检查位3
//		this.ckeckId3 = "";
//		// 预留检查位4
//		this.ckeckId4 = "";
//		// 预留检查位5
//		this.ckeckId5 = "";
//	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getCxId() {
		return cxId;
	}

	public void setCxId(String cxId) {
		this.cxId = cxId;
	}

	public String getEquId() {
		return equId;
	}

	public void setEquId(String equId) {
		this.equId = equId;
	}

	public String getCkeckId1() {
		return ckeckId1;
	}

	public void setCkeckId1(String ckeckId1) {
		this.ckeckId1 = ckeckId1;
	}

	public String getCkeckId2() {
		return ckeckId2;
	}

	public void setCkeckId2(String ckeckId2) {
		this.ckeckId2 = ckeckId2;
	}

	public String getCkeckId3() {
		return ckeckId3;
	}

	public void setCkeckId3(String ckeckId3) {
		this.ckeckId3 = ckeckId3;
	}

	public String getCkeckId4() {
		return ckeckId4;
	}

	public void setCkeckId4(String ckeckId4) {
		this.ckeckId4 = ckeckId4;
	}

	public String getCkeckId5() {
		return ckeckId5;
	}

	public void setCkeckId5(String ckeckId5) {
		this.ckeckId5 = ckeckId5;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getRowStart() {
		return rowStart;
	}

	public void setRowStart(String rowStart) {
		this.rowStart = rowStart;
	}

	public String getRowCount() {
		return rowCount;
	}

	public void setRowCount(String rowCount) {
		this.rowCount = rowCount;
	}

	public List<?> getAddInfoList() {
		return addInfoList;
	}

	public void setAddInfoList(List<?> addInfoList) {
		this.addInfoList = addInfoList;
	}

	public List<?> getCodeList() {
		return codeList;
	}

	public void setCodeList(List<?> codeList) {
		this.codeList = codeList;
	}

	public String getPrefixActiveCode() {
		return prefixActiveCode;
	}

	public void setPrefixActiveCode(String prefixActiveCode) {
		this.prefixActiveCode = prefixActiveCode;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableIndex() {
		return tableIndex;
	}

	public void setTableIndex(String tableIndex) {
		this.tableIndex = tableIndex;
	}

}
