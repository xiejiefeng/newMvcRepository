package com.xjf.wemall.web.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

//import com.saic.wemall.service.redis.api.RedisClientService;

public class RedisJob {
	// log4j日志
	private static final Logger logger = LoggerFactory.getLogger(RedisJob.class);
//	
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
	
	/**
	 * 执行刷新缓存任务
	 */
	public void execute() {
//		// 刷新系统参照缓存
//		logger.info("RedisJob SysReference Running!");
//		sysReferenceService.resetRedis();
//		// 刷新业务参照缓存
//		logger.info("RedisJob Reference Running!");
//		referenceService.resetRedis();
//		// 刷新门店相关缓存
//		logger.info("RedisJob Store Running!");
//		storeService.resetRedis();
//		// 刷新服务相关缓存
//		logger.info("RedisJob Product Running!");
//		productService.resetRedis();
//		// 刷新车型相关缓存
//		logger.info("RedisJob CarModel Running!");
//		carModelService.resetRedis();
//		// 刷新保养手册缓存
//		logger.info("RedisJob Maintenance Running!");
//		maintenanceService.resetRedis();
//		// 刷新技师相关缓存
//		logger.info("RedisJob Artificer Running!");
//		employeeArtificerService.resetRedis();
//		// 清除购物车缓存
//		logger.info("RedisJob ShoppingCart Running!");
//		shoppingCartService.resetRedis();
//		// 刷新消息相关缓存
//		logger.info("RedisJob Reply Running!");
//		replyService.resetRedis();
	}
}
