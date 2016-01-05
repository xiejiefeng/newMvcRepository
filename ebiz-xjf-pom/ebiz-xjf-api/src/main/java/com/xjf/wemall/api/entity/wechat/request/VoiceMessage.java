/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: VoiceMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:37:37
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 语音消息<br> 
 *  
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class VoiceMessage extends MediaMessage {
    /**语音消息：语音格式，如amr，speex等*/
    @XStreamAlias("Format")
    private String format;

    /**
     * default
     */
    public VoiceMessage() {
       super();
    }

    /**
     * @return 语音格式
     */
    public String getFormat() {
        return format;
    }

    /**
     * @param format语音格式
     */
    public void setFormat(String format) {
        this.format = format;
    }
    
    
}
