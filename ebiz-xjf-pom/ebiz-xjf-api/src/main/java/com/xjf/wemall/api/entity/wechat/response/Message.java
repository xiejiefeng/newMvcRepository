/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ReplyMessage.java
 * Author:   wanglijun
 * Date:     2014年8月25日 下午2:29:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 回复消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("message")
public class Message {
    /**消息名称*/
    @XStreamAlias("name")
    private  String name;
    /**消息类型*/
    @XStreamAlias("msgType")
    private  String msgType;
    /**消息内容*/
    @XStreamAlias("content")
    private  String content;
    /***
     * 默认
     */
    public Message() {
        super();
    }
    /**
     * @return 消息名称
     */
    public String getName() {
        return name;
    }
    /**
     * @param name 消息名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return the 消息名称
     */
    public String getMsgType() {
        return msgType;
    }
    /**
     * @param msgType 消息名称
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
    /**
     * @return 消息内容
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}   
