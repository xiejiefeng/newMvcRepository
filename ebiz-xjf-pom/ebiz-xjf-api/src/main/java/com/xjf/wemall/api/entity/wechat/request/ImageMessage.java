/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ImageMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:36:52
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 图片消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class ImageMessage {
    /**图片消息：图片链接*/
    @XStreamAlias("PicUrl")
    private String picUrl;

    /**
     * 默认构造函数
     */
    public ImageMessage() {
        super();
    }

    /**
     * @return 图片链接
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * @param picUrl 图片链接
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
    
    
}
