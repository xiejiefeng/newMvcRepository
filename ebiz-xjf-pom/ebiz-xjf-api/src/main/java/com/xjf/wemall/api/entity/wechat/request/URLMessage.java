/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: URLMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:26:36
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 链接请求消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class URLMessage extends CMNMessage{
    /**链接消息：消息标题*/
    @XStreamAlias("Title")
    private String title;
    /**链接消息：消息描述*/
    @XStreamAlias("Description")
    private String description;
    /**链接消息：消息链接*/
    @XStreamAlias("Url")
    private String Url;
    /**默认构造函数*/
    public URLMessage() {
       super();
    }
    /**
     * @return  消息标题
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return 消息描述
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description 消息描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the 消息链接
     */
    public String getUrl() {
        return Url;
    }
    /**
     * @param url the消息链接
     */
    public void setUrl(String url) {
        Url = url;
    }
    
    
}
