/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Messages.java
 * Author:   wanglijun
 * Date:     2014年8月25日 下午2:38:51
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 消息列表<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("messages")
public class Messages {
    /**消息列表*/
    @XStreamAlias("list")
    private List<Message>  list;
    
    
    /**图文消息*/
    @XStreamAlias("newsMessage")
    private ImageTextMessage  newsMessage;
    
    
    /**默认*/
    public Messages() {
       super();
    }

    /**
     * @return  消息列表
     */
    public List<Message> getList() {
        return list;
    }

    /**
     * @param list  消息列表
     */
    public void setList(List<Message> list) {
        this.list = list;
    }

    /**
     * @return the newsMessage
     */
    public ImageTextMessage getNewsMessage() {
        return newsMessage;
    }

    /**
     * @param newsMessage the newsMessage to set
     */
    public void setNewsMessage(ImageTextMessage newsMessage) {
        this.newsMessage = newsMessage;
    }
}
