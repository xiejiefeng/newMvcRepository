/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisLockService.java
 * Author:   baowenzhou
 * Date:     2016年01月20日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.api;

import com.xjf.wemall.api.entity.redis.RedisLockVo;

public interface RedisLockService {
	
	/**缓存刷新-未找到*/
	public static final int RESET_LOCK_STATUS_NULL = -1;
	
	/**缓存刷新-执行中*/
	public static final int RESET_LOCK_STATUS_INPROGRESS = 0;
	
	/**缓存刷新-完成*/
	public static final int RESET_LOCK_STATUS_COMPLETE = 1;
	
	/**缓存刷新-错误*/
	public static final int RESET_LOCK_STATUS_ERROR = 2;
	
	/**
	 * 功能描述: 设置缓存锁<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean lock(String redisType);
	
	/**
	 * 
	 * 功能描述: 关闭缓存锁-成功<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public void complete(String redisType);
	
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
	public void error(String redisType, String errMsg);
	
	/**
	 * 
	 * 功能描述: 获取缓存锁状态<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public RedisLockVo getStatus(String redisType);
	
	/**
	 * 
	 * 功能描述: 删除缓存锁状态<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public void delete(String redisType);
}
