/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Message.java
 * Author:   wanglijun
 * Date:     2014年8月25日 下午5:57:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.send;

import java.io.Serializable;

/**
 * 抽像类<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public  abstract class Message implements Serializable  {

    /**
     */
    private static final long serialVersionUID = 43568543361760690L;
    
    /**接收普通用户openid*/
    private String touser;
    /**消息类型*/
    private String msgtype;
    /***消息*/
    public Message() {
       super();
    }
    /**
     * @return 接收普通用户openid
     */
    public String getTouser() {
        return touser;
    }
    /**
     * @param touser 接收普通用户openid
     */
    public void setTouser(String touser) {
        this.touser = touser;
    }
    /**
     * @return 消息类型
     */
    public String getMsgtype() {
        return msgtype;
    }
    /**
     * @param msgtype 消息类型
     */
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    
    
}
