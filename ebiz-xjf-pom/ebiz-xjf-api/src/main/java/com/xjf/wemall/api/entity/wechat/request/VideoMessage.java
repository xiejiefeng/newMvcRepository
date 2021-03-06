/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: VideoMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:38:35
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频消息 <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class VideoMessage extends MediaMessage {
    /**视频消息:缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。*/
    @XStreamAlias("ThumbMediaId")
    private String thumbMediaId;
    /**
     * default
     */
    public VideoMessage() {
        super();
    }

    /**
     * @return the thumbMediaId
     */
    public String getThumbMediaId() {
        return thumbMediaId;
    }

    /**
     * @param thumbMediaId the thumbMediaId to set
     */
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }
    
    
}
