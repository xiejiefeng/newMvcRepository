package com.xjf.wemall.redis.client;

import redis.clients.jedis.Jedis;

/**
 * 
 * @author v_pinzhao
 * 
 * @param <R> 泛型对象
 */
public interface CallBack<R> {

    /**
     * 执行回调方法，调用jedis的实例，返回相应操作的结果。 R为返回值，可能为String, Object等
     * 
     * @param jedis cache object
     * @return result
     */
    R invoke(Jedis jedis);
}

