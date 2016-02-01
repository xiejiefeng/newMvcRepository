/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: RedisJobServiceImpl.java
 * Author:   baowenzhou
 * Date:     2015年12月23日 下午4:57:22
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

import com.xjf.wemall.annotation.LogTime;
import com.xjf.wemall.api.util.DateUtil;
import com.xjf.wemall.service.AbstractService;
//import com.xjf.wemall.annotation.LogTime;
//import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.redis.api.RedisClientService;
import com.xjf.wemall.service.redis.api.RedisJobCallBack;
import com.xjf.wemall.service.redis.api.RedisJobService;

@Service
public class RedisJobServiceImpl 
extends AbstractService 
implements RedisJobService {

//	@Override
//	public String resetRedis(String redisType) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public boolean resetRedisShoppingCart() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public String getInProgressMsg() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	/**门店服务*/
//    @Autowired
//	@Qualifier("storeServiceImpl")
//    private RedisClientService storeService;
//
//    /**产品信息*/
//	@Autowired
//	@Qualifier("productServiceImpl")
//    private RedisClientService productService;
//	
//	/**车型信息*/
//	@Autowired
//	@Qualifier("carModelServiceImpl")
//    private RedisClientService carModelService;
//	
//	/**消息信息 */
//	@Autowired
//	@Qualifier("replyServiceImpl")
//	private RedisClientService replyService;
//	
//	/**业务参照信息获取*/
//	@Autowired
//	@Qualifier("referenceServiceImpl")
//    private RedisClientService referenceService;
//	
//	/**保养手册信息获取*/
//	@Autowired
//	@Qualifier("maintenanceServiceImpl")
//    private RedisClientService maintenanceService;
//	
//	/**购物车信息获取*/
//	@Autowired
//	@Qualifier("shoppingCartServiceImpl")
//    private RedisClientService shoppingCartService;
//	
//	/**系统参照信息获取*/
//	@Autowired
//	@Qualifier("sysReferenceService")
//    private RedisClientService sysReferenceService;
//	
//	/**技师信息获取*/
//	@Autowired
//	@Qualifier("employeeArtificerServiceImpl")
//    private RedisClientService employeeArtificerService;
//	
//	/**配件信息获取*/
//	@Autowired
//	@Qualifier("skuServiceImpl")
//    private RedisClientService skuService;
//	
//	/**模板信息获取*/
//	@Autowired
//	@Qualifier("templateBaseServiceImpl")
//    private RedisClientService templateService;
//	
//	/**美容卡信息获取*/
//	@Autowired
//	@Qualifier("mrkServiceImpl")
//    private RedisClientService mrkService;
//	
//	/**处理中信息*/
//	private String inProgressMsg;
//	
//	@Override
//	public String getInProgressMsg() {
//		return inProgressMsg;
//	}
//
//	public void setInProgressMsg(String inProgressMsg) {
//		if (StringUtils.isNotEmpty(inProgressMsg)) {
//			logger.info(inProgressMsg);
//		}
//		this.inProgressMsg = inProgressMsg;
//	}
//
	
	/**处理中信息*/
	private String inProgressMsg;
	
	@Override
	public String getInProgressMsg() {
		return inProgressMsg;
	}

	public void setInProgressMsg(String inProgressMsg) {
		if (StringUtils.isNotEmpty(inProgressMsg)) {
			logger.info(inProgressMsg);
		}
		this.inProgressMsg = inProgressMsg;
	}
	
	@LogTime
	@Override
	public String resetRedis(String redisType) {
		
		boolean result = true;
		StringBuilder errorMsg = new StringBuilder();
		
		this.setInProgressMsg(null);
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_SYSREFERENCE.equals(redisType)) {
			// 刷新系统参照缓存
			result = this.handler("系统参照", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_REFERENCE.equals(redisType)) {
			// 刷新业务参照缓存
			result = this.handler("业务参照", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_STORE.equals(redisType)) {
			// 刷新门店相关缓存
			result = this.handler("门店信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_PRODUCT.equals(redisType)) {
			// 刷新服务相关缓存
			result = this.handler("服务信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_SKU.equals(redisType)) {
			// 刷新配件相关缓存
			result = this.handler("配件信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_CARMODEL.equals(redisType)) {
			// 刷新车型相关缓存
			result = this.handler("车型信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_MAINTENANCE.equals(redisType)) {
			// 刷新保养手册缓存
			result = this.handler("保养手册", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_ARTIFICER.equals(redisType)) {
			// 刷新技师相关缓存
			result = this.handler("技师信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		if (RedisJobService.REDIS_ALL.equals(redisType)
				|| RedisJobService.REDIS_TEMPLATE.equals(redisType)) {
			// 刷新模板相关缓存
			result = this.handler("模板信息", errorMsg, new RedisJobCallBack() {
				@Override
				public boolean invoke() {
					Long now = DateUtil.getCurrentDate().getTime();
					Long cur = new Long(0);
					while(true) {
						cur = DateUtil.getCurrentDate().getTime();
						if (cur.compareTo(now + 5000) >= 0) {
							break;
						}
					}
					return true;
				}
			});
		}
		
		this.setInProgressMsg(null);
		
		return errorMsg.toString();
	}
	
	/**
	 * 
	 * 功能描述: 重置缓存<br>
	 * 〈功能详细描述〉
	 *
	 * @param action
	 * @param errorMsg
	 * @param callback
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	private boolean handler(String action, StringBuilder errorMsg, RedisJobCallBack callback) {
		this.setInProgressMsg(action+"重置中……");
		boolean result = callback.invoke();
		if (!result) {
			errorMsg.append(action);
			errorMsg.append("重置失败;");
		}
		return result;
	}

	@Override
	public boolean resetRedisShoppingCart() {
		
		boolean result = true;
		
		// 清除购物车缓存
		logger.info("RedisJob ShoppingCart Running!");
//		result = shoppingCartService.resetRedis();
		
		return result;
	}

}
