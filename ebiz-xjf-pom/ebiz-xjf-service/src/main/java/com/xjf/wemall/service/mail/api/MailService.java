/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LogService.java
 * Author:   baowenzhou
 * Date:     2015-11-05 上午10:38:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.mail.api;

import com.xjf.wemall.api.constant.api.Code;
import com.xjf.wemall.api.entity.mail.MailVo;

/**
 * 邮件服务<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface MailService {

	/**
	 * 
	 * 功能描述: 初始化邮件配置<br>
	 * 〈功能详细描述〉
	 *
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean init();
	
	/**
	 * 
	 * 功能描述: 邮件发送<br>
	 * 〈功能详细描述〉
	 *
	 * @param mail
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean send(MailVo mail);
	
	/**
	 * 
	 * 功能描述: 邮件发送-数据同步<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean sendLog(Code<String> code);
}
