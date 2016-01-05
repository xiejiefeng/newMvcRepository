/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Image.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:57:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 媒体消息体:通过上传多媒体文件，得到的id<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Media {
    /**视频消息、语音消息、图片消息：图片消息媒体id，可以调用多媒体文件下载接口拉取数据。*/
    @XStreamAlias("MediaId")
    private String mediaId;
    

    /**
     * @return the mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId the mediaId to set
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Media [mediaId=" + mediaId + "]";
    }
}   
