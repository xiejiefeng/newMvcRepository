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

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 回复消息<br> 
 * 〈功能详细描述〉
 *
 * @author xiejuan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("newsMessage")
public class ImageTextMessage {
    /**消息名称*/
    @XStreamAlias("name")
    private  String name;
    
    /**消息类型*/
    @XStreamAlias("msgType")
    private  String msgType;
    
    /**图文消息个数，限制为10条以内*/
    @XStreamAlias("articleCount")
    private  String articleCount;
    
    /**多条图文消息信息，默认第一个item为大图,注意，如果图文数超过10，则将会无响应*/
    @XStreamAlias("articles")
    private  List<ArticleItem> articles;
    
    /***
     * 默认
     */
    public ImageTextMessage() {
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
     * @return the articleCount
     */
    public String getArticleCount() {
        return articleCount;
    }
    /**
     * @param articleCount the articleCount to set
     */
    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }
    /**
     * @return the articles
     */
    public List<ArticleItem> getArticles() {
        return articles;
    }
    /**
     * @param articles the articles to set
     */
    public void setArticles(List<ArticleItem> articles) {
        this.articles = articles;
    }
   
}   
