/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisLockServiceImpl.java
 * Author:   baowenzhou
 * Date:     2016年01月20日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xjf.wemall.redis.client.IRedisClient;
import com.xjf.wemall.api.constant.TimeToLive;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.mail.MailVo;
import com.xjf.wemall.api.entity.redis.RedisVerifyVo;
import com.xjf.wemall.api.util.DateUtil;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.api.util.StringUtil;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.mail.api.MailService;
//import com.xjf.wemall.service.mail.api.MailService;
import com.xjf.wemall.service.redis.api.RedisVerifyService;
//import com.xjf.wemall.service.sysreference.api.SysReferenceService;

@Service
public class RedisVerifyServiceImpl extends AbstractService implements RedisVerifyService {
	
    /**  字符的redis. */
    @Autowired
    @Qualifier("redisClient")
    protected IRedisClient redisClient;
    
	/**邮件服务处理*/
	@Autowired
    private MailService mailService;
//	
//	/** 参照信息 */
//	@Autowired
//	private SysReferenceService sysReferenceService;
	
    /**
	 * 功能描述: 缓存创建<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisVerify
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean create(RedisVerifyVo redisVerify) {
		if (redisVerify != null && StringUtils.isNotEmpty(redisVerify.getUid())) {
			String uid = redisVerify.getUid();
			String redisKey = this.getRedisVerifyKey(uid);
			
			redisVerify.setCode(StringUtil.getRandomString(6, StringUtil.RANDOM_NUMBER));
			redisVerify.setStatus(RedisVerifyService.RESET_VERIFY_STATUS_UNDO);
			redisVerify.setCreateTime(DateUtil.getCurrentDateTime());
			String redisValue = JSONParser.toJSONString(redisVerify);
			
			// 信息放入缓存，有效期30分钟
			redisClient.setex(redisKey, TimeToLive.HALFHOUR.code(), redisValue);
			
			return this.sendMail(redisVerify);
		}
		
		return false;
	}
	
	/**
	 * 
	 * 功能描述: 邮件发送验证码<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisVerify
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private boolean sendMail(RedisVerifyVo redisVerify) {
		MailVo mail = new MailVo();
		
		// 收件人
		String to = "165023030@qq.com";
		
		mail.setTo(to);
		
		// 主题
		StringBuilder subject = new StringBuilder();
		subject.append("配置页面验证码-");
		subject.append("uid:");
		subject.append(redisVerify.getUid());

		mail.setSubject(subject.toString());
		
		// 内容
		StringBuilder text = new StringBuilder();
		text.append("uid:");
		text.append(redisVerify.getUid());
		text.append("<br>");
		text.append("host:");
		text.append(redisVerify.getHost());
		text.append("<br>");
		text.append("ip:");
		text.append(redisVerify.getIp());
		text.append("<br>");
		text.append("code:");
		text.append(redisVerify.getCode());
		text.append("<br>");
		text.append("createTime:");
		text.append(redisVerify.getCreateTime());
		text.append("<br>");
		
		mail.setText(text.toString());
		
		return mailService.send(mail);
	}
	
	/**
	 * 
	 * 功能描述: 返回验证关键字<br>
	 * 〈功能详细描述〉
	 *
	 * @param uid
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getRedisVerifyKey(String uid) {
		StringBuilder sb = new StringBuilder();
		sb.append(COMMON_VERIFY_KEY);
		sb.append(uid);
		return sb.toString();
	}
	
	/**
	 * 
	 * 功能描述: 缓存验证<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisVerify
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean verify(RedisVerifyVo redisVerify) {
		// 对象不存在或唯一键不存在，验证失败
		if (redisVerify == null || StringUtils.isEmpty(redisVerify.getUid())) {
			return false;
		}
		
		String uid = redisVerify.getUid();
		String redisKey = this.getRedisVerifyKey(uid);
		
		// 缓存验证不存在，验证失败
		if (!redisClient.exists(redisKey)) {
			return false;
		}
		
		// 获取验证码
		RedisVerifyVo value = JSONParser.toStringObject(
				redisClient.get(redisKey), RedisVerifyVo.class);
		
		// 获取失败，验证失败
		if (value == null || StringUtils.isEmpty(value.getCode())) {
			return false;
		}
		
		String codeMatch = value.getCode().toUpperCase();
		String code = StringUtils.trimToEmpty(redisVerify.getCode()).toUpperCase();
		
		// 验证码不匹配，验证失败
		if (!codeMatch.equals(code)) {
			return false;
		}
		
		// 更新验证状态
		if (RedisVerifyService.RESET_VERIFY_STATUS_UNDO == value.getStatus()) {
//			value.setIp(redisVerify.getIp());
			value.setStatus(RedisVerifyService.RESET_VERIFY_STATUS_DONE);
			value.setVerifyTime(DateUtil.getCurrentDateTime());
			String redisValue = JSONParser.toJSONString(value);
			
			// 验证信息放入缓存，有效期一天
			redisClient.setex(redisKey, TimeToLive.DAY.code(), redisValue);
		}
		
		return true;
	}
}
