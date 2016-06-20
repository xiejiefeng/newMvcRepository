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
package com.xjf.wemall.api.entity.useractiveresult;

import com.xjf.wemall.api.entity.base.BaseVo;

/**
 * 用户活动信息结果表Vo<br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserActiveResultVo extends BaseVo  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 活动编码
     */
    private String activeCode;

    /**
     * 车享ID
     */
    private String cxId;
   
    /**
     * 来源(4:微信 6:车享宝 7:车享汇 8:微站 9:百度)
     * 
     */
    private String sourceType;
    
    /**
     * 用户动作类型(1：分享，2：答题  必填)
     */
    private String doType;
    
    /**
     * 用户动作内容1
     */
    private String doValue1;
    
    /**
     * 用户动作内容2
     */
    private String doValue2;
    
    /**
     * 用户动作内容3
     */
    private String doValue3;
    
    /**
     * 用户动作内容4
     */
    private String doValue4;
    
    /**
     * 目标类型（例如：分享：记录微信渠道）
     */
    private String targetType;
    
    /**
     * 目标内容（例如：分享：记录OPENID）
     */
    private String targetValue;
    
    /**
     * 备注1
     */
    private String remark1;
    
    /**
     * 备注2
     */
    private String remark2;
    
    /**
     * 备注3
     */
    private String remark3;
    
    /**
     * 备注4
     */
    private String remark4;
    
    /**************************************以下是查询条件**************************************************/
    
    /**
     * 是否忽略活动编码（0：忽略，1：不忽略，默认为1）
     */
    private String ignoreActiveFlag;
    
    /**
     * 是否忽略渠道（0：忽略，1：不忽略，默认为0）
     */
    private String ignoreSourceFlag;
    
    /**
     * 是否忽略动作（0：忽略，1：不忽略，默认为0）
     */
    private String ignoreDoType;
    
    /**
     * 间隔天数（单位：天，默认为0）
     */
    private String intervalTime;
    
    /**
     * 开始行数
     */
    private String rowStart;
    
    /**
     * 查询行数
     */
    private String rowCount;
    
    /**
     * 分页sql
     */
    private String limitValue;
    
    /**
     * 用户动作内容1（UPDATE的设置数据）
     */
    private String doValue1Upd;
    
    /**
     * 用户动作内容2（UPDATE的设置数据）
     */
    private String doValue2Upd;
    
    /**
     * 用户动作内容3（UPDATE的设置数据）
     */
    private String doValue3Upd;
    
    /**
     * 用户动作内容4（UPDATE的设置数据）
     */
    private String doValue4Upd;
    
    /**
     * 备注1（UPDATE的设置数据）
     */
    private String remark1Upd;
    
    /**
     * 备注2（UPDATE的设置数据）
     */
    private String remark2Upd;
    
    /**
     * 备注3（UPDATE的设置数据）
     */
    private String remark3Upd;
    
    /**
     * 备注4（UPDATE的设置数据）
     */
    private String remark4Upd;
    
    /**
     * 逻辑删除标记（UPDATE的设置数据）
     */
    private String isDeletedUpd;
    
    public UserActiveResultVo() {
        this.ignoreActiveFlag = "1";
        this.ignoreSourceFlag = "0";
        this.ignoreDoType = "0";
        this.intervalTime = "0";
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getCxId() {
        return cxId;
    }

    public void setCxId(String cxId) {
        this.cxId = cxId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getDoType() {
        return doType;
    }

    public void setDoType(String doType) {
        this.doType = doType;
    }

    public String getDoValue1() {
        return doValue1;
    }

    public void setDoValue1(String doValue1) {
        this.doValue1 = doValue1;
    }

    public String getDoValue2() {
        return doValue2;
    }

    public void setDoValue2(String doValue2) {
        this.doValue2 = doValue2;
    }

    public String getDoValue3() {
        return doValue3;
    }

    public void setDoValue3(String doValue3) {
        this.doValue3 = doValue3;
    }

    public String getDoValue4() {
        return doValue4;
    }

    public void setDoValue4(String doValue4) {
        this.doValue4 = doValue4;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(String targetValue) {
        this.targetValue = targetValue;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3;
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4;
    }

    public String getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(String intervalTime) {
        this.intervalTime = intervalTime;
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

    public String getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
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

    public String getIgnoreDoType() {
        return ignoreDoType;
    }

    public void setIgnoreDoType(String ignoreDoType) {
        this.ignoreDoType = ignoreDoType;
    }

    public String getDoValue1Upd() {
        return doValue1Upd;
    }

    public void setDoValue1Upd(String doValue1Upd) {
        this.doValue1Upd = doValue1Upd;
    }

    public String getDoValue2Upd() {
        return doValue2Upd;
    }

    public void setDoValue2Upd(String doValue2Upd) {
        this.doValue2Upd = doValue2Upd;
    }

    public String getDoValue3Upd() {
        return doValue3Upd;
    }

    public void setDoValue3Upd(String doValue3Upd) {
        this.doValue3Upd = doValue3Upd;
    }

    public String getDoValue4Upd() {
        return doValue4Upd;
    }

    public void setDoValue4Upd(String doValue4Upd) {
        this.doValue4Upd = doValue4Upd;
    }

    public String getRemark1Upd() {
        return remark1Upd;
    }

    public void setRemark1Upd(String remark1Upd) {
        this.remark1Upd = remark1Upd;
    }

    public String getRemark2Upd() {
        return remark2Upd;
    }

    public void setRemark2Upd(String remark2Upd) {
        this.remark2Upd = remark2Upd;
    }

    public String getRemark3Upd() {
        return remark3Upd;
    }

    public void setRemark3Upd(String remark3Upd) {
        this.remark3Upd = remark3Upd;
    }

    public String getRemark4Upd() {
        return remark4Upd;
    }

    public void setRemark4Upd(String remark4Upd) {
        this.remark4Upd = remark4Upd;
    }

    public String getIsDeletedUpd() {
        return isDeletedUpd;
    }

    public void setIsDeletedUpd(String isDeletedUpd) {
        this.isDeletedUpd = isDeletedUpd;
    }
}
