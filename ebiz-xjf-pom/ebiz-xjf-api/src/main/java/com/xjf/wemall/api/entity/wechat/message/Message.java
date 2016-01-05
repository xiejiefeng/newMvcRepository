/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Message.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午10:01:17
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 消息抽像类<br> 
 * 消息抽像类
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class Message {
    /**接收微信号：接收消息为：开发者账号，发送消息为：用户账号*/
    @XStreamAlias("ToUserName")
    protected String toUserName;
    /**发送方帐号：接收消息为：用户账号，发送消息为：开发者账号*/
    @XStreamAlias("FromUserName")
    protected String fromUserName;
    /**消息创建时间 （整型）*/
    @XStreamAlias("CreateTime")
    protected Long createTime;
    /**消息类型*/
    @XStreamAlias("MsgType")
    protected String msgType;
    /**
     * @return 接收微信号
     */
    public String getToUserName() {
        return toUserName;
    }
    /**
     * @param toUserName 接收微信号
     */
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }
    /**
     * @return the 发送方帐号
     */
    public String getFromUserName() {
        return fromUserName;
    }
    /**
     * @param fromUserName  发送方帐号
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
    /**
     * @return the  消息创建时间 
     */
    public Long getCreateTime() {
        return createTime;
    }
    /**
     * @param createTime 消息创建时间 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
    /**
     * @return 消息类型
     */
    public String getMsgType() {
        return msgType;
    }
    /**
     * @param msgType 消息类型
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Message [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
                + ", msgType=" + msgType + "]";
    }
    
    
}
