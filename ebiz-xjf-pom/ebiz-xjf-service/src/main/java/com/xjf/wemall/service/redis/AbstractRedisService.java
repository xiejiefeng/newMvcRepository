/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AbstractRedisServiceImpl.java
 * Author:   baowenzhou
 * Date:     2015年08月07日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xjf.wemall.redis.client.IBinaryRedisClient;
import com.xjf.wemall.redis.client.IRedisClient;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.redis.api.RedisClientService;
import com.xjf.wemall.api.constant.TimeToLive;

public abstract class AbstractRedisService extends AbstractService implements RedisClientService {
	
	/**日志类*/
	private final Logger redisLogger = LoggerFactory.getLogger(AbstractRedisService.class);

	/**  二进制的redis. */
    @Autowired
    @Qualifier("springBinaryRedisClient")
    protected IBinaryRedisClient binaryRedisClient;
    /**  字符的redis. */
    @Autowired
    @Qualifier("redisClient")
    protected IRedisClient redisClient;
	
    /**
     * 获取Redis
     * 
     * @param key
     * @param type
     * @return
     */
	protected <T> T getRedis(String key, TypeReference<T> type) {
		T result = binaryRedisClient.get(key, type);
		return this.getRedis(key, result);
	}
	
	/**
     * 获取Redis
     * 
     * @param key
     * @param clazz
     * @return
     */
	protected <T> T getRedis(String key, Class<T> clazz) {
		T result = binaryRedisClient.get(key, clazz);
		return this.getRedis(key, result);
	}
	
	/**
     * 获取Redis
     * 
     * @param key
     * @param value
     * @return
     */
	@SuppressWarnings("rawtypes")
	private <T> T getRedis(String key, T value) {
		if (value instanceof Collection) {
			if (!CollectionUtils.isEmpty((Collection) value)) {
				redisLogger.info("Get redis:{}", key);
				return value;
			}
		} else if (value instanceof Map) {
			if (!CollectionUtils.isEmpty((Map) value)) {
				redisLogger.info("Get redis:{}", key);
				return value;
			}
		} else {
			if (value != null) {
				redisLogger.info("Get redis:{}", key);
				return value;
			}
		}
		return null;
	}
	
	/**
     * 获取Redis列表
     * 
     * @param key
     * @param type
     * @return
     */
	protected <T> List<T> getRedisByKeys(String keys, TypeReference<T> type) {
		Set<String> set = redisClient.keys(keys);
		List<T> list = new ArrayList<T>();
		for(String key : set) {
			list.add(this.getRedis(key, type));
		}
		return list;
	}
	
	/**
     * 获取Redis列表
     * 
     * @param key
     * @param type
     * @return
     */
	protected <T> List<T> getRedisByKeys(String keys, Class<T> clazz) {
		Set<String> set = redisClient.keys(keys);
		List<T> list = new ArrayList<T>();
		for(String key : set) {
			list.add(this.getRedis(key, clazz));
		}
		return list;
	}
	
	/**
	 * 设定Redis
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
	protected <T> void setRedis(String key, T value, int time) {
		redisLogger.info("Set redis:{}, {}", key, time+"秒");
		if (time == TimeToLive.PERSISTENCE.code()) {
			binaryRedisClient.set(key, value);
		} else {
			binaryRedisClient.setex(key, value, time);
		}
	}
	
	/**
	 * 设定Redis
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
	protected <T> void setRedis(String key, T value, TimeToLive time) {
		redisLogger.info("Set redis:{}, {}", key, time.desc());
		if (time.code() == TimeToLive.PERSISTENCE.code()) {
			binaryRedisClient.set(key, value);
		} else {
			binaryRedisClient.setex(key, value, time.code());
		}
	}
	
	/**
	 * 设定Redis
	 * 
	 * @param key
	 * @param value
	 * @param time
	 */
	protected <T> void setRedis(String key, T value) {
		redisLogger.info("Set redis:{}, {}", key, TimeToLive.PERSISTENCE.desc());
		binaryRedisClient.set(key, value);
	}
	
	/**
	 * 清除Redis
	 * 
	 * @param key
	 */
	protected void removeRedis(String key) {
		redisLogger.info("Remove redis:{}", key);
		binaryRedisClient.remove(key);
	}
	
	/**
	 * 清除Redis<br>
	 * 根据模糊Key清除
	 * 
	 * @param key
	 */
	protected void removeRedisByKeys(String keys) {
		redisLogger.info("Remove redis:{}", keys);
		Set<String> list = redisClient.keys(keys);
		for(String key : list) {
			this.removeRedis(key);
		}
	}
	
	/**
	 * 设定Redis-Hash
	 * 
	 * @param key
	 * @param map
	 */
	protected <T> void setHashRedis(String key, Map<String, T> map) {
		if (MapUtils.isEmpty(map)) {
			redisLogger.warn("Redis Map Empty:{}", key);
		} else {
			redisLogger.info("Set hash redis:{}, {}", key, TimeToLive.PERSISTENCE.desc());
			Map<String, String> hashmap = new HashMap<String, String>();
			for(Entry<String, T> entry : map.entrySet()) {
				hashmap.put(entry.getKey(), JSON.toJSONString(entry.getValue()));
			}
			redisClient.hmset(key, hashmap);
		}
	}
	
	/**
	 * 设定Redis-Hash
	 * 
	 * @param key
	 * @param map
	 * @param time
	 */
	protected <T> void setHashRedis(String key, Map<String, T> map, TimeToLive time) {
		redisLogger.info("Set hash redis:{}, {}", key, time.desc());
		this.setHashRedis(key, map);
		redisClient.expire(key, time.code());
	}
	
	/**
	 * 设定Redis-Hash
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	protected <T> void setHashRedis(String key, String field, String value) {
		redisLogger.info("Set hash redis:{}, {}", key, field);
		
		if (StringUtils.isNotEmpty(field)) {
			redisClient.hset(key, field, value);
		}
	}
	
	/**
	 * 设定Redis-Hash
	 * 
	 * @param key
	 * @param field
	 * @param value
	 */
	protected <T> void setHashRedis(String key, String field, T value) {
		redisLogger.info("Set hash redis:{}, {}", key, field);
		
		if (StringUtils.isNotEmpty(field)) {
			redisClient.hset(key, field, JSON.toJSONString(value));
		}
	}
	
	/**
	 * 获取Redis-Hash
	 * 
	 * @param key
	 * @param field
	 * @param type
	 */
	protected <T> T getHashRedis(String key, String field, TypeReference<T> type) {
		redisLogger.info("Get hash redis:{}, {}", key, field);
		
		if (StringUtils.isEmpty(field)) {
			return null;
		} else {
			String value = redisClient.hget(key, field);
			return JSON.parseObject(value, type);
		}
	}
	
	/**
	 * 获取Redis-Hash
	 * 
	 * @param key
	 * @param field
	 * @param clazz
	 */
	protected <T> T getHashRedis(String key, String field, Class<T> clazz) {
		redisLogger.info("Get hash redis:{}, {}", key, field);
		
		if (StringUtils.isEmpty(field)) {
			return null;
		} else {
			String value = redisClient.hget(key, field);
			return JSON.parseObject(value, clazz);
		}
	}
	
	/**
	 * 获取Redis-Hash
	 * 
	 * @param key
	 * @param type
	 */
	protected <T> Map<String, T> getAllHashRedis(String key, TypeReference<T> type) {
		redisLogger.info("Get all hash redis:{}", key);
		Map<String, String> map = redisClient.hgetAll(key);
		Map<String, T> hashmap = new HashMap<String, T>();
		for(Entry<String, String> entry : map.entrySet()) {
			hashmap.put(entry.getKey(), JSON.parseObject(entry.getValue(), type));
		}
		return hashmap;
	}
	
	/**
	 * 获取Redis-Hash
	 * 
	 * @param key
	 * @param clazz
	 */
	protected <T> Map<String, T> getAllHashRedis(String key, Class<T> clazz) {
		redisLogger.info("Get all hash redis:{}", key);
		Map<String, String> map = redisClient.hgetAll(key);
		Map<String, T> hashmap = new HashMap<String, T>();
		for(Entry<String, String> entry : map.entrySet()) {
			hashmap.put(entry.getKey(), JSON.parseObject(entry.getValue(), clazz));
		}
		return hashmap;
	}
	
	/**
	 * 判断Redis中是否存在key
	 * 
	 * @param key
	 */
	protected boolean existsRedis(String key) {
		boolean ret = redisClient.exists(key);
		
		if (!ret) {
			logger.warn("Not exists redis:{}", key);
		}
		
		return ret;
	}
	
	/**
	 * 判断Redis中是否存在key和field
	 * 
	 * @param key
	 * @param field
	 */
	protected boolean existsRedis(String key, String field) {
		boolean ret = true;
		
		if (StringUtils.isEmpty(field)) {
			ret = false;
		} else {
			ret = redisClient.hexists(key, field);
		}
		
		if (!ret) {
			logger.warn("Not exists redis:{}, {}", key, field);
		}
		
		return ret;
	}
	
	/**
	 * 获取Redis中key下所有field
	 * 
	 * @param key
	 */
	protected Set<String> getAllHashField(String key) {
		return redisClient.hkeys(key);
	}
	
	/***
     * 
     * 功能描述:销毁Redis相关线程池
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public void destroy() {
		
	}
	
	/**
	 * 功能描述: 重置消息信息缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean resetRedis() {
		return true;
	}
	
	/**
	 * 功能描述: 重置消息信息缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @param cxId
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean resetRedis(String cxId) {
		return true;
	}
}
