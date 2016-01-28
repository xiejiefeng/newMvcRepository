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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xjf.wemall.redis.client.IRedisClient;
import com.xjf.wemall.api.constant.TimeToLive;
//import com.xjf.wemall.api.constant.TimeToLive;
import com.xjf.wemall.api.entity.redis.RedisLockVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.redis.api.RedisLockService;

@Service
public class RedisLockServiceImpl extends AbstractService implements RedisLockService {

	/**静默期(30秒)*/
	private static final int expireSecond = 30 * 1000;
	
    /**  字符的redis. */
    @Autowired
    @Qualifier("redisClient")
    protected IRedisClient redisClient;
	
    /**
	 * 功能描述: 设置缓存锁<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public boolean lock(String redisType) {
		String redisKey = this.getRedisLockKey(redisType);
		String redisValue = this.initRedisLock(redisType);
		
		// 获取刷新缓存锁
		if (redisClient.setnx(redisKey, redisValue) == 1) {
			// 超时时间默认5分钟
			redisClient.expire(redisKey, TimeToLive.DEFAULT.code());
			return true;
		}
		else {
			RedisLockVo redisLock = this.getRedisLock(redisKey);
			
			if (redisLock != null) {
				Long endTimeMillis = redisLock.getEndTimeMillis();
				// 尚未结束
				if (redisLock.getEndTimeMillis() == null) {
					return false;
				}
				
				// 判断结束后超时时间
				long currentTimeMillis = System.currentTimeMillis();
				if (currentTimeMillis < endTimeMillis + expireSecond) {
					return false;
				}
			}
			
			// 重新设定缓存锁,超时时间默认5分钟
			redisClient.setex(redisKey, TimeToLive.DEFAULT.code(), redisValue);
			
			return true;
		}
	}

	/**
	 * 
	 * 功能描述: 初始化缓存锁<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String initRedisLock(String redisType) {
		RedisLockVo redisLock = new RedisLockVo();
		redisLock.setKey(redisType);
		redisLock.setStatus(RedisLockService.RESET_LOCK_STATUS_INPROGRESS);
		redisLock.setStartTimeMillis(System.currentTimeMillis());
		return JSONParser.toJSONString(redisLock);
	}
	
	/**
	 * 
	 * 功能描述: 返回锁关键字<br>
	 * 〈功能详细描述〉
	 *
	 * @param key
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private String getRedisLockKey(String redisType) {
		StringBuilder sb = new StringBuilder();
		sb.append(COMMON_RESET_LOCK_KEY);
//		sb.append(redisType.toUpperCase());
		return sb.toString();
	}
	
	/**
	 * 
	 * 功能描述: 获取缓存锁<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisKey
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private RedisLockVo getRedisLock(String redisKey) {

		RedisLockVo redisLock = null;
		if (redisClient.exists(redisKey)) {
			redisLock = JSONParser.toStringObject(
					redisClient.get(redisKey), RedisLockVo.class);
		}
		return redisLock;
	}
	
	/**
	 * 
	 * 功能描述: 关闭缓存锁-成功<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public void complete(String redisType) {
		this.closeRedisLock(redisType, RedisLockService.RESET_LOCK_STATUS_COMPLETE, null);
	}
	
	/**
	 * 
	 * 功能描述: 关闭缓存锁-失败<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @param errMsg
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public void error(String redisType, String errMsg) {
		this.closeRedisLock(redisType, RedisLockService.RESET_LOCK_STATUS_ERROR, errMsg);
	}
	
	/**
	 * 
	 * 功能描述: 关闭缓存锁<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @param status
	 * @param errMsg
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private void closeRedisLock(String redisType, int status, String errMsg) {
		String redisKey = this.getRedisLockKey(redisType);

		RedisLockVo redisLock = this.getRedisLock(redisKey);
		
		if (redisLock != null) {
			redisLock.setErrMsg(errMsg);
			redisLock.setStatus(status);
			redisLock.setEndTimeMillis(System.currentTimeMillis());
			// 重新设定缓存锁,超时时间默认30秒
			redisClient.setex(redisKey, TimeToLive.HALFMINUTE.code(), JSONParser.toJSONString(redisLock));
		}
	}

	/**
	 * 
	 * 功能描述: 获取缓存锁状态<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public RedisLockVo getStatus(String redisType) {
		String redisKey = this.getRedisLockKey(redisType);

		RedisLockVo redisLock = this.getRedisLock(redisKey);
		
		return redisLock;
	}
	
	/**
	 * 
	 * 功能描述: 删除缓存锁状态<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public void delete(String redisType) {
		String redisKey = this.getRedisLockKey(redisType);

		if (redisClient.exists(redisKey)) {
			redisClient.del(redisKey);
		}
	}
}
