/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisJobService.java
 * Author:   baowenzhou
 * Date:     2015年12月23日 下午4:57:22
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.api;

public interface RedisJobService {
	
	/** 全部重置 */
	public final String REDIS_ALL = "all";
	
	/** 系统参照重置 */
	public final String REDIS_SYSREFERENCE = "sysReference";
	
	/** 业务参照重置 */
	public final String REDIS_REFERENCE = "reference";
	
	/** 门店重置 */
	public final String REDIS_STORE = "store";
	
	/** 服务重置 */
	public final String REDIS_PRODUCT = "product";
	
	/** 配件重置 */
	public final String REDIS_SKU = "sku";
	
	/** 车型重置 */
	public final String REDIS_CARMODEL = "carModel";

	/** 保养手册重置 */
	public final String REDIS_MAINTENANCE = "maintenance";
	
	/** 技师重置 */
	public final String REDIS_ARTIFICER = "artificer";
	
	/** 模板重置 */
	public final String REDIS_TEMPLATE = "template";
	
	/** 美容卡重置 */
	public final String REDIS_MRK = "mrk";

	/**
	 * 功能描述: 重置缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @param redisType
	 * @return 错误消息
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public String resetRedis(String redisType);
	
	/**
	 * 功能描述: 重置购物车缓存 <br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public boolean resetRedisShoppingCart();
	
	/**
	 * 
	 * 功能描述: 获取处理中信息<br>
	 * 〈功能详细描述〉
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public String getInProgressMsg();
}
