/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: LogServiceImpl.java
 * Author:   baowenzhou
 * Date:     2015-11-05 上午10:42:56
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.mail.impl;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.xjf.wemall.annotation.LogTime;
import com.xjf.wemall.api.constant.Charset;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.constant.api.Code;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.util.DateUtil;
import com.xjf.wemall.service.mail.api.MailService;
//import com.xjf.wemall.service.sysreference.api.SysReferenceService;

/**
 * 邮件服务实体类<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class MailServiceImpl implements MailService {
	
	/**日志类*/
	protected final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);
	
	private JavaMailSenderImpl mailSender;
	
	private Map<String, String> mailMap;
	
//	/** 参照信息 */
//	@Autowired
//	private SysReferenceService sysReferenceService;
	
	/**
	 * 
	 * 功能描述: 初始化邮件配置<br>
	 * 〈功能详细描述〉
	 *
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public boolean init() {
		
		logger.info("邮件初始化");
		
//		mailMap = sysReferenceService
//				.querySysReferenceValueForMap(WemallConstants.REFERENCE_CODE_MAIL);
//		
//		if (MapUtils.isEmpty(mailMap)) {
//			logger.error("邮件错误：无配置");
//			return false;
//		}
//		
//		String host = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_HOST);
//		if (StringUtils.isEmpty(host)) {
//			logger.error("邮件错误：无主机");
//			return false;
//		}
//		
//		String username = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_USERNAME);
//		if (StringUtils.isEmpty(username)) {
//			logger.error("邮件错误：无用户名");
//			return false;
//		}	
//		
//		String password = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_PASSWORD);
//		if (StringUtils.isEmpty(password)) {
//			logger.error("邮件错误：无密码");
//			return false;
//		}
		
		mailSender = new JavaMailSenderImpl();
		mailSender.setDefaultEncoding(Charset.UFT8.code());
		mailSender.setHost("smtp.126.com");
		mailSender.setUsername("xiejiefeng333@126.com");
		mailSender.setPassword("Xjf860908");
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		javaMailProperties.setProperty("mail.smtp.timeout", "25000");
		mailSender.setJavaMailProperties(javaMailProperties);
		
		return true;
	}
	
	/**
	 * 
	 * 功能描述: 邮件发送<br>
	 * 〈功能详细描述〉
	 *
	 * @param mail
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public boolean send(MailVo mail) {

		try {
			if (mailMap == null || mailSender == null) {
				if(!this.init()) {
					return false;
				}
			}
			
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message);
			
//			String from = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_FROM);
			String from = "xiejiefeng333@126.com";
			if (StringUtils.isEmpty(from)) {
				logger.error("邮件错误：无发件人");
				return false;
			}
			
			if (ArrayUtils.isEmpty(mail.getToArray())) {
				logger.error("邮件错误：无收件人");
				return false;
			}
			
			if (StringUtils.isEmpty(mail.getSubject())) {
				logger.error("邮件错误：无主题");
				return false;
			}
			
			if (StringUtils.isEmpty(mail.getText())) {
				logger.error("邮件错误：无内容");
				return false;
			}
			
			messageHelper.setFrom(from);
			messageHelper.setTo(mail.getToArray());
			messageHelper.setSubject(mail.getSubject());
			messageHelper.setText(mail.getText(), true);
			if (mail.getSendDate() != null) {
				messageHelper.setSentDate(mail.getSendDate());
			}
			
			mailSender.send(message);			
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * 
	 * 功能描述: 邮件发送-数据同步<br>
	 * 〈功能详细描述〉
	 *
	 * @param code
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@LogTime
	@Override
	public boolean sendLog(Code<String> code) {
//		if (mailMap == null || mailSender == null) {
//			if(!this.init()) {
//				return false;
//			}
//		}
//		
//		// 邮件内容
//		Map<String, String> msgMap = sysReferenceService
//				.querySysReferenceValueForMap(WemallConstants.REFERENCE_CODE_MSG);
//		
//		// 发送日时
//		String sendTime = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_SEND_TIME);
//		Date sendDateTime = null;
//		if (StringUtils.isNotEmpty(sendTime)) {
//			sendDateTime = DateUtil.parseCurrentDateTime(sendTime);
//		}
//		
//		// 发件人
//		String to = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_TO);
//		
//		// 主题
//		String subject = mailMap.get(WemallConstants.REFERENCE_DETAIL_CODE_MAIL_SUBJECT);
//		
//		MailVo mail = new MailVo();
//		mail.setTo(to);
//		mail.setSubject(subject);
//		mail.setSendDate(sendDateTime);
//		mail.setText(msgMap.get(code.code()));
//		
//		return this.send(mail);
		return false;
	}
}
