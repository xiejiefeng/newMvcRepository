/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ArticleItem.java
 * Author:   xiejuan
 * Date:     2014年8月25日 下午2:29:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 *  回复消息<br> 
 * 〈功能详细描述〉
 *
 * @author xiejuan
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("item")
public class ArticleItem {
    /**图文消息标题 */
    @XStreamAlias("title")
    private  String title;
    
    /**图文消息描述*/
    @XStreamAlias("description")
    private  String description;
    
    /**图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200 */
    @XStreamAlias("picUrl")
    private  String picUrl;
    
    /**点击图文消息跳转链接 */
    @XStreamAlias("url")
    private  String url;
    
    
    /***
     * 默认
     */
    public ArticleItem() {
        super();
    }


    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }


    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }


    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     * @return the picUrl
     */
    public String getPicUrl() {
        return picUrl;
    }


    /**
     * @param picUrl the picUrl to set
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }


    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }


    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
