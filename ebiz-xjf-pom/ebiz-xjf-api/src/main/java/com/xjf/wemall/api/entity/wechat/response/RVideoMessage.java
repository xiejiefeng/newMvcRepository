/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ResponseMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午10:18:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import java.util.ArrayList;
import java.util.List;

import com.xjf.wemall.api.entity.wechat.message.Message;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频响应消息内容<br>
 * 〈功能详细描述〉
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class RVideoMessage extends Message {
    /** 通过上传多媒体文件，得到的id */
    @XStreamAlias("Voice")
    private List<Video> videos = new ArrayList<Video>();

    /**
     * @return the videos 视频消息体
     */
    public List<Video> getVideos() {
        return videos;
    }

    /**
     * @param videos the videos 视频消息体
     */
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "RMediaMessage [toString()=" + super.toString() + "]";
    }

}
