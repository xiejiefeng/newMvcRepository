/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ShoppingCartServiceImpl.java
 * Author:   wanglijun
 * Date:     2014年9月3日 下午3:30:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.shoppingcart.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjf.wemall.api.constant.TimeToLive;
//import com.xjf.wemall.api.constant.UserFlg;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
import com.xjf.wemall.api.entity.common.CookieObject;
//import com.xjf.wemall.api.entity.order.OrderInfoVo;
import com.xjf.wemall.api.entity.shoppingcart.ShoppingCartVo;
import com.xjf.wemall.api.entity.store.StoreInfoVo;
import com.xjf.wemall.api.entity.user.CustomInfoVo;
import com.xjf.wemall.api.util.DateUtil;
//import com.xjf.wemall.service.carmodel.api.CarModelService;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.shoppingcart.api.ShoppingCartService;
//import com.xjf.wemall.service.store.api.StoreService;
//import com.xjf.wemall.service.user.api.UserService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ShoppingCartServiceImpl extends AbstractService implements ShoppingCartService {
//
//	/** 门店服务 */
//	@Autowired
//	private StoreService storeService;
//
//	/** 用户服务 */
//	@Autowired
//	private UserService userService;
//
//	/** 车型服务 */
//	@Autowired
//	private CarModelService carModelService;
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public void updateShoppingCart(String key, ShoppingCartVo shoppingCart) {
//		if (StringUtils.isNotEmpty(key)) {
//			redisClientService.set(this.getKey(key), shoppingCart, TimeToLive.DAY);
//		}
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public void remove(String key) {
//		if (StringUtils.isNotEmpty(key)) {
//			redisClientService.del(this.getKey(key));
//		}
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public ShoppingCartVo getShoppingCart(String key) {
//		ShoppingCartVo shoppingCart = new ShoppingCartVo();
//		if (StringUtils.isNotEmpty(key)) {
//			shoppingCart = redisClientService.get(this.getKey(key), ShoppingCartVo.class);
//			if (shoppingCart == null) {
//				shoppingCart = new ShoppingCartVo();
//				shoppingCart.setSessionId(key);
//				this.updateShoppingCart(key, shoppingCart);
//			}
//		}
//		return shoppingCart;
//	}
//
//	/***
//	 * 
//	 * 功能描述: <br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @param key
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	private String getKey(String key) {
//		StringBuilder builder = new StringBuilder(SHOPPINGCART_KEY);
//		builder.append(key);
//		return builder.toString();
//	}
//
//	/**
//	 * 功能描述:更新 购物车<br>
//	 *
//	 * @param cookie
//	 *            Cookie对象
//	 * @param customParam
//	 *            客户信息
//	 * @param carModelParam
//	 *            车辆信息
//	 * @param storeParam
//	 *            门店信息
//	 * @param orderParam
//	 *            订单信息
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void updateShoppingCart(CookieObject cookie, CustomInfoVo customParam,
//			CarModelInfoVo carModelParam, StoreInfoVo storeParam, OrderInfoVo orderParam) {
//
//		String key = cookie.getKey();
//		String cxId = cookie.getCxId();
//		String openId = cookie.getOpenId();
//		String openType = cookie.getOpenType();
//
//		ShoppingCartVo shoppingCart = this.getShoppingCart(key);
//
//		// 保存客户信息
//		if (customParam != null) {
//			CustomInfoVo custom = shoppingCart.getCustomInfo();
//			if (custom != null) {
//				if (StringUtils.isNotEmpty(customParam.getCustName())) {
//					custom.setCustName(customParam.getCustName());
//				}
//				// custom.setMobilePhone(customParam.getMobilePhone());
//				custom.setWxNo(openId);
//				custom.setCxId(cxId);
//				custom.setOpenType(openType);
//				shoppingCart.setCustomInfo(custom);
//			}
//		}
//
//		// 保存车辆信息
//		if (carModelParam != null) {
//			CarModelInfoVo carModel = shoppingCart.getCarModelInfo();
//			if (carModel != null) {
//				if (StringUtils.isNotEmpty(carModelParam.getPlates())) {
//					carModel.setPlates(carModelParam.getPlates());
//				}
//				shoppingCart.setCarModelInfo(carModel);
//			}
//		}
//
//		// 保存门店信息
//		if (storeParam != null) {
//			StoreInfoVo store = shoppingCart.getStoreInfo();
//			if (store == null) {
//				store = storeService.getStoreInfoById(storeParam.getStoreId());
//			}
//			shoppingCart.setStoreInfo(store);
//		}
//
//		// 保存到店时间
//		if (orderParam != null) {
//			OrderInfoVo order = shoppingCart.getOrderInfo();
//			if (order != null) {
//				// 无快速下单项目
//				if (WemallConstants.FLG_NO.equals(order.getFastFlg())) {
//					order.setOrderDate(orderParam.getOrderDate());
//				}
//				// 快速下单，预约日期为当天
//				else {
//					order.setOrderDate(DateUtil.formatDate(DateUtil.getCurrentDate(),
//							DateUtil.FORMAT_DATE_DEFAULT));
//				}
//
//				order.setTimeFlag(orderParam.getTimeFlag());
//				order.setPayStatus(orderParam.getPayStatus());
//				shoppingCart.setOrderInfo(order);
//			}
//		}
//
//		this.updateShoppingCart(key, shoppingCart);
//	}
//
//	/**
//	 * 
//	 * 功能描述: 获取客户信息<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param shoppingCart
//	 * @param cxId
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public CustomInfoVo getCustomInfo(ShoppingCartVo shoppingCart, String cxId) {
//		// 获取用户信息
//		CustomInfoVo customInfo = shoppingCart.getCustomInfo();
//		if (customInfo == null || StringUtils.isEmpty(customInfo.getCxId())) {
//			if (StringUtils.isNotEmpty(cxId)) {
//				// 用户信息
//				customInfo = userService.queryUserInfo(cxId, UserFlg.CAR);
//			}
//
//			if (customInfo == null) {
//				customInfo = new CustomInfoVo();
//			}
//
//			// 用户信息放入购物车
//			shoppingCart.setCustomInfo(customInfo);
//		}
//
//		return customInfo;
//	}
//
//	/**
//	 * 
//	 * 功能描述: 获取车辆信息<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param shoppingCart
//	 * @param customInfo
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public CarModelInfoVo getCarModelInfo(ShoppingCartVo shoppingCart, CustomInfoVo customInfo) {
//		// 获取车辆信息
//		CarModelInfoVo carModelInfo = shoppingCart.getCarModelInfo();
//		if (carModelInfo == null) {
//			List<CarModelInfoVo> carModelList = customInfo.getCarInfo();
//			if (carModelList != null && carModelList.size() == 1) {
//				carModelInfo = customInfo.getCarInfo().get(0);
//			}
//		}
//
//		if (carModelInfo != null) {
//			// 设定车型名称
//			carModelInfo = carModelService.setCarName(carModelInfo);
//			shoppingCart.setCarModelInfo(carModelInfo);
//		}
//
//		return carModelInfo;
//	}
//	
//	/**
//	 * 
//	 * 功能描述: 获取车辆信息<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param shoppingCart
//	 * @param customInfo
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public CarModelInfoVo getCarModelInfo(ShoppingCartVo shoppingCart) {
//		// 获取车辆信息
//		CarModelInfoVo carModelInfo = shoppingCart.getCarModelInfo();
//		if (carModelInfo != null) {
//			// 设定车型名称
//			carModelInfo = carModelService.setCarName(carModelInfo);
//			shoppingCart.setCarModelInfo(carModelInfo);
//		}
//
//		return carModelInfo;
//	}
//
//	/**
//	 * 
//	 * 功能描述: 获取订单信息<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param shoppingCart
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public OrderInfoVo getOrderInfo(ShoppingCartVo shoppingCart) {
//		OrderInfoVo orderInfo = shoppingCart.getOrderInfo();
//		if (orderInfo == null) {
//			orderInfo = new OrderInfoVo();
//		}
//
//		// 订单信息放入购物车
//		shoppingCart.setOrderInfo(orderInfo);
//
//		return orderInfo;
//	}
//
//	@Override
//	public boolean resetRedis() {
//		logger.info("清除购物车缓存!");
//
//		try {
//			// super.removeRedisByKeys(SHOPPINGCART_KEY+"*");
//			redisClientService.patternDel(SHOPPINGCART_KEY + "*");
//		} catch (Exception ex) {
//			logger.error(super.getStackTrace(ex));
//			return false;
//		}
//
//		return true;
//	}
}
