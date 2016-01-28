/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisClientServiceImpl.java
 * Author:   baowenzhou
 * Date:     2015年08月07日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.impl;

import java.util.Collection;

import com.xjf.wemall.redis.client.IRedisClient;
import com.xjf.wemall.redis.client.impl.spring.SpringRedisClientImpl;
import com.xjf.wemall.redis.shard.ShardHandler;
import com.xjf.wemall.service.redis.api.RedisClientService;

public class RedisClientServiceImpl extends SpringRedisClientImpl 
	implements RedisClientService, IRedisClient {

	@Override
	public void destroy() {
		Collection<ShardHandler> allShards = sharded4Jedis.getAllShards();
        for (ShardHandler shardHandler : allShards) {
            shardHandler.destroy();
        }
	}

	@Override
	public boolean resetRedis() {
		return false;
	}

	@Override
	public boolean resetRedis(String cxId) {
		return false;
	}

}
