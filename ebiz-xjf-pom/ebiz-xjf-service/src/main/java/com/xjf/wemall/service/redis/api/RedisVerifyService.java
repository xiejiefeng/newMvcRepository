/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisVerifyService.java
 * Author:   baowenzhou
 * Date:     2016年01月21日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.api;

import com.xjf.wemall.api.entity.redis.RedisVerifyVo;

public interface RedisVerifyService {
	
	/**缓存验证-未验证*/
	public static final int RESET_VERIFY_STATUS_UNDO = 0;
	
	/**缓存验证-已验证*/
	public static final int RESET_VERIFY_STATUS_DONE = 1;
	
	/**
	 * 功能描述: 缓存创建<br>
	 * 〈功能详细描述〉
	 *
	 * @param redisVerify
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean create(RedisVerifyVo redisVerify);
	
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
	public boolean verify(RedisVerifyVo redisVerify);
	
}
