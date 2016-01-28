/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisClientService.java
 * Author:   baowenzhou
 * Date:     2015年08月07日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.api;

public interface RedisClientService {
	
	/***
     * 
     * 功能描述:销毁Redis相关线程池
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public void destroy();
	
	/**
	 * 功能描述: 重置缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean resetRedis();
	
	/**
	 * 功能描述: 重置缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @param cxId
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean resetRedis(String cxId);
}
