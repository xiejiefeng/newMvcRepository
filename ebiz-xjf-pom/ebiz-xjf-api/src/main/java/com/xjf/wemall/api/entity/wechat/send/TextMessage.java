/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: TextMessage.java
 * Author:   wanglijun
 * Date:     2014年8月25日 下午6:00:48
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.send;


/**
 * 发送文本消息 <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TextMessage extends Message {

    /**
     */
    private static final long serialVersionUID = 5999761580254425023L;
    /***
     * 文本消息内容对象
     */
    private Text  text;
    /**
     * 默认
     * */
    public TextMessage() {
        super();
    }
    /***
     * 
     * 功能描述: 设置消息内容<br>
     * 〈功能详细描述〉
     *
     * @param content
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void setContent(String content){
        if(this.text==null){
            this.text=new Text();
        }
        this.text.setContent(content);
    }
    /**
     * @return 文本消息内容对象
     */
    public Text getText() {
        return text;
    }
    /**
     * @param text 文本消息内容对象
     */
    public void setText(Text text) {
        this.text = text;
    }
    
    
}
