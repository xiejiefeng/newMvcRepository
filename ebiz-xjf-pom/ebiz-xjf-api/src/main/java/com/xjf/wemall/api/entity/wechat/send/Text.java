/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ContentMessage.java
 * Author:   wanglijun
 * Date:     2014年8月25日 下午6:01:46
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.send;

/**
 * 文本消息内容<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Text {
    /**
     * 文本消息内容
     */
    private String content;

    /**
     * @return  文本消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content  文本消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    
}
