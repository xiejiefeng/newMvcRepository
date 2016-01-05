/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: Video.java
 * Author:   wanglijun
 * Date:     2014年8月20日 上午12:06:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 视频消息体<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Video extends Media {
    
    /**视频消息：消息标题*/
    @XStreamAlias("Title")
    private String title;
    /**视频消息：消息描述*/
    @XStreamAlias("Description")
    private String description;
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
    
    
    
}
