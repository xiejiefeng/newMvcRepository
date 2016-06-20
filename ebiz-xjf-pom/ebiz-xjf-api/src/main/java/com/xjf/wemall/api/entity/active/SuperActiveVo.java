package com.xjf.wemall.api.entity.active;

import java.io.Serializable;

public class SuperActiveVo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 车享ID
	private String cxId;
	// 微信openId
	private String openId;
	// 设备Id
	private String equId;
	// 来源
	private String sourceType;
	// 活动编码
	private String activeCode;
	// 检查精度（0：不做任何检查，1：cxId检查，2：equId检查，4：openId检查，默认为1）
	// 若需要检查多个条件，可进行复合查询
	// 示例：cxId与equId同时检查，则checkFlag为1+2=3
	// 示例：cxId与openId同时检查，则checkFlag为1+4=5
	// 示例：cxId、openId、equId同时检查，则checkFlag为1+2+4=7
	private String checkFlag;
	// 是否忽略渠道（0：忽略，1：不忽略，默认为1）
	private String ignoreSourceFlag;
	// 是否忽略活动编码（0：忽略，1：不忽略，默认为1）
	private String ignoreActiveFlag;
	// 与或非判断(0:and，1：or 用于数据库sql操作，默认是1)
	private String andOrFlag;
	// 间隔时间（单位：天，默认为0）
	private String intervalTime;
	// 最大出现、参与次数（0为不限次数，默认为1）
	private String partTimes;
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
	/*********** 内部 *********/
	// 分区表名字
	private String tableName;
	// 分区表索引
	private String tableIndex;
	// 查询条件
	private String queryCondition;
	// 是否需要cxid(0：不需要，1:需要)
	private String needCxId;
	// 是否需要equId(0：不需要，1:需要)
	private String needEquId;
	// 是否需要openId(0：不需要，1:需要)
	private String needOpenId;
	// 预留检查位1(0：不需要，1:需要)
	private String needCkeckId1;
	// 预留检查位2(0：不需要，1:需要)
	private String needCkeckId2;
	// 预留检查位3(0：不需要，1:需要)
	private String needCkeckId3;
	// 预留检查位4(0：不需要，1:需要)
	private String needCkeckId4;
	// 预留检查位5(0：不需要，1:需要)
	private String needCkeckId5;

	public SuperActiveVo() {
		this.checkFlag = "1";
		this.ignoreSourceFlag = "1";
		this.ignoreActiveFlag = "1";
		this.needCxId = "0";
		this.needEquId = "0";
		this.needOpenId = "0";
		this.needCkeckId1 = "0";
		this.needCkeckId2 = "0";
		this.needCkeckId3 = "0";
		this.needCkeckId4 = "0";
		this.needCkeckId5 = "0";
		this.andOrFlag = "1";
		this.intervalTime = "0";
		this.partTimes = "1";
		this.cxId = "";
		this.openId = "";
		this.equId = "";
		this.ckeckId1 = "";
		this.ckeckId2 = "";
		this.ckeckId3 = "";
		this.ckeckId4 = "";
		this.ckeckId5 = "";
		this.queryCondition = "";
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

	public String getQueryCondition() {
		return queryCondition;
	}

	public void setQueryCondition(String queryCondition) {
		this.queryCondition = queryCondition;
	}

	public String getCxId() {
		return cxId;
	}

	public void setCxId(String cxId) {
		this.cxId = cxId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getEquId() {
		return equId;
	}

	public void setEquId(String equId) {
		this.equId = equId;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getActiveCode() {
		return activeCode;
	}

	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}

	public String getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(String checkFlag) {
		this.checkFlag = checkFlag;
	}

	public String getIgnoreSourceFlag() {
		return ignoreSourceFlag;
	}

	public void setIgnoreSourceFlag(String ignoreSourceFlag) {
		this.ignoreSourceFlag = ignoreSourceFlag;
	}

	public String getIgnoreActiveFlag() {
		return ignoreActiveFlag;
	}

	public void setIgnoreActiveFlag(String ignoreActiveFlag) {
		this.ignoreActiveFlag = ignoreActiveFlag;
	}

	public String getAndOrFlag() {
		return andOrFlag;
	}

	public void setAndOrFlag(String andOrFlag) {
		this.andOrFlag = andOrFlag;
	}

	public String getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(String intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getPartTimes() {
		return partTimes;
	}

	public void setPartTimes(String partTimes) {
		this.partTimes = partTimes;
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

	public String getNeedCxId() {
		return needCxId;
	}

	public void setNeedCxId(String needCxId) {
		this.needCxId = needCxId;
	}

	public String getNeedEquId() {
		return needEquId;
	}

	public void setNeedEquId(String needEquId) {
		this.needEquId = needEquId;
	}

	public String getNeedOpenId() {
		return needOpenId;
	}

	public void setNeedOpenId(String needOpenId) {
		this.needOpenId = needOpenId;
	}

	public String getNeedCkeckId1() {
		return needCkeckId1;
	}

	public void setNeedCkeckId1(String needCkeckId1) {
		this.needCkeckId1 = needCkeckId1;
	}

	public String getNeedCkeckId2() {
		return needCkeckId2;
	}

	public void setNeedCkeckId2(String needCkeckId2) {
		this.needCkeckId2 = needCkeckId2;
	}

	public String getNeedCkeckId3() {
		return needCkeckId3;
	}

	public void setNeedCkeckId3(String needCkeckId3) {
		this.needCkeckId3 = needCkeckId3;
	}

	public String getNeedCkeckId4() {
		return needCkeckId4;
	}

	public void setNeedCkeckId4(String needCkeckId4) {
		this.needCkeckId4 = needCkeckId4;
	}

	public String getNeedCkeckId5() {
		return needCkeckId5;
	}

	public void setNeedCkeckId5(String needCkeckId5) {
		this.needCkeckId5 = needCkeckId5;
	}

}
