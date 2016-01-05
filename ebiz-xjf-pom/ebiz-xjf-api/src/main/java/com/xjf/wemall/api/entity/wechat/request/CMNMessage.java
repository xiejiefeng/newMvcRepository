/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CommonMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:22:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.xjf.wemall.api.entity.wechat.message.Message;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 普通消息抽像类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public abstract class CMNMessage extends Message{
    /** 消息id，64位整型 */
    @XStreamAlias("MsgId")
    private String msgId;

    /**
     * @return 消息id
     */
    public String getMsgId() {
        return msgId;
    }

    /**
     * @param msgId 消息id
     */
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "CommonMessage [msgId=" + msgId + ", toString()=" + super.toString() + "]";
    }
}
