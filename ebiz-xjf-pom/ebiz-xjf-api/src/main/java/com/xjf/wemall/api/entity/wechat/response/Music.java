/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Music.java
 * Author:   wanglijun
 * Date:     2014年8月20日 上午12:10:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 音乐消息响应消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Music {
    /**音乐消息：消息标题*/
    @XStreamAlias("Title")
    private String title;
    /**音乐消息：消息描述*/
    @XStreamAlias("Description")
    private String description;
    /**音乐链接:MusicURL*/
    @XStreamAlias("MusicURL")
    private String musicURL;
    /**高质量音乐链接:HQMusicUrl*/
    @XStreamAlias("HQMusicUrl")
    private String hqMusicUrl;
    /**视频消息:缩略图的媒体id。*/
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    /**
     * @return 消息标题
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
     * @return 消息标题
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description 消息标题
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * @return the musicURL 音乐链接
     */
    public String getMusicURL() {
        return musicURL;
    }
    /**
     * @param musicURL the 音乐链接
     */
    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }
    /**
     * @return the hqMusicUrl 高质量音乐链接
     */
    public String getHqMusicUrl() {
        return hqMusicUrl;
    }
    /**
     * @param hqMusicUrl 高质量音乐链接
     */
    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }
    /**
     * @return 缩略图的媒体id
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }
    /**
     * @param thumbMediaId 缩略图的媒体id
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
    
    
}
