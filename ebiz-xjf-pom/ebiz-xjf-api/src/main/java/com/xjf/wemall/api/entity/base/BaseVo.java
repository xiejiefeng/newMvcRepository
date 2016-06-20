/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: BaseVo.java
 * Author:   tantun
 * Date:     2015年3月12日 下午3:34:41
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.base;

import java.util.Date;

/**
 * VO基础类
 *
 * @author tantun
 * @see java.io.Serializable
 */
public class BaseVo implements java.io.Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 6834473165049250202L;

    // ID
    protected Long id;

    // 逻辑删除标记
    protected String isDeleted;

    // 创建人ID
    protected Long createBy;

    // 创建时间
    protected Date createTime;

    // 更新者ID
    protected Long updateBy;

    // 更新时间
    protected Date updateTime;

    // 查询页面的查询条件
    private String trackedQueryCondition = null;

    // 前画面URI
    private String prevRequestURI = null;

    /**
     * 获取【ID】
     * 
     * @return ID
     */
    final public Long getId() {
        return id;
    }

    /**
     * 设定【ID】
     * 
     * @param id the id to set
     */
    final public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取【逻辑删除标记】
     * 
     * @return 逻辑删除标记
     */
    final public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设定【逻辑删除标记】
     * 
     * @param 逻辑删除标记
     */
    final public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取【创建人ID】
     * 
     * @return 创建人ID
     */
    final public Long getCreateBy() {
        return createBy;
    }

    /**
     * 设定【创建人ID】
     * 
     * @param 创建人ID
     */
    final public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取【创建时间】
     * 
     * @return 创建时间
     */
    final public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设定【创建时间】
     * 
     * @param 创建时间
     */
    final public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取【更新者ID】
     * 
     * @return 更新者ID
     */
    final public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * 设定【更新者ID】
     * 
     * @param 更新者ID
     */
    final public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取【更新时间】
     * 
     * @return 更新时间
     */
    final public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设定【更新时间】
     * 
     * @param 更新时间
     */
    final public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取【查询页面的查询条件】
     *
     * @return 查询页面的查询条件
     */
    final public String getTrackedQueryCondition() {
        return trackedQueryCondition;
    }

    /**
     * 设定【查询页面的查询条件】
     *
     * @param trackedQueryCondition 查询页面的查询条件
     */
    final public void setTrackedQueryCondition(String trackedQueryCondition) {
        this.trackedQueryCondition = trackedQueryCondition;
    }

    /**
     * 获取【前画面URI】
     *
     * @return 前画面URI
     */
    final public String getPrevRequestURI() {
        return prevRequestURI;
    }

    /**
     * 设定【前画面URI】
     *
     * @param prevRequestURI 前画面URI
     */
    final public void setPrevRequestURI(String prevRequestURI) {
        this.prevRequestURI = prevRequestURI;
    }

    
}
