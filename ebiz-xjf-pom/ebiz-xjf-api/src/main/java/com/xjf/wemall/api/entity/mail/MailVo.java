/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: MailVo.java
 * Author:   baowenzhou
 * Date:     2015年01月05日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.mail;

import java.util.Date;

/**
 * 微信菜单实体 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class MailVo {

	// 收件人
    private String to;
    // 主题
    private String subject;
    // 内容
    private String text;
    // 内容
    private Date sendDate;
    
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String[] getToArray() {
		String[] toArray = {};
		if (to != null && to.length() > 0) {
			toArray = to.split(";");
		}
		return toArray;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
    
}
