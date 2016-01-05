/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: TextMessage.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午11:24:44
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.response;

import com.xjf.wemall.api.entity.wechat.message.Message;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 文本请求消息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@XStreamAlias("xml")
public class RTextMessage extends Message{
    /**文本消息:文本消息内容 */
    @XStreamAlias("Content")
    private String context; 
    /**默认*/
    public RTextMessage() {
      super();
    }
    
    /**
     * @return 文本消息内容
     */
    public String getContext() {
        return context;
    }
    /**
     * @param context 文本消息内容
     */
    public void setContext(String context) {
        this.context = context;
    }
}
