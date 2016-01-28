/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisJobCallBack.java
 * Author:   baowenzhou
 * Date:     2016年01月20日 下午1:16:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.redis.api;

/**
 * RedisJob回调  <br> 
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface RedisJobCallBack {
	
	/**
     * 
     * 功能描述: 回调方法<br>
     * 〈功能详细描述〉
     * 
     * @throws Exception 
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public boolean invoke();
	

}
