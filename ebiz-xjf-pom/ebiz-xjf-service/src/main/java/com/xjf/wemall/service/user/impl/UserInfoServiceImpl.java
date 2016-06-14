/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserInfoServiceImpl.java
 * Author:   wanglijun
 * Date:     2014年8月26日 下午12:47:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.user.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjf.wemall.api.constant.BaiduURL;
import com.xjf.wemall.api.constant.TimeToLive;
import com.xjf.wemall.api.constant.WeiXinURL;
import com.xjf.wemall.api.entity.baidu.GeocoderInfoVo;
import com.xjf.wemall.api.entity.common.CookieObject;
import com.xjf.wemall.api.entity.shoppingcart.ShoppingCartVo;
import com.xjf.wemall.api.entity.store.AreaInfoVo;
import com.xjf.wemall.api.entity.user.PointVo;
import com.xjf.wemall.api.entity.user.UserAreaVo;
import com.xjf.wemall.api.entity.wechat.entity.UserInfo;
import com.xjf.wemall.api.util.CoordinateUtil;
import com.xjf.wemall.api.util.HttpKit;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.shoppingcart.api.ProductCartService;
import com.xjf.wemall.service.shoppingcart.api.ShoppingCartService;
//import com.xjf.wemall.service.store.api.StoreService;
//import com.xjf.wemall.service.wechat.api.AccessTokenService;
//import com.xjf.wemall.service.wechat.api.UserInfoService;
import com.xjf.wemall.service.user.api.UserInfoService;

/**
 * 微信用户信息处理Service<br>
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
// @Cache
public class UserInfoServiceImpl extends AbstractService implements UserInfoService {

	/** 微信会话消息 */
//	@Autowired
//	private AccessTokenService accessTokenService;
//
//	/** 门店服务 */
//	@Autowired
//	private StoreService storeService;

	/** 隐式购物车信息处理 */
	@Autowired
	private ShoppingCartService shoppingCartService;

	/** 显式购物车信息处理 */
	@Autowired
	private ProductCartService productCartService;

	@Override
	// @Cacheable(key=USERINFO_KEY,timeToLive=TimeToLive.DAY)
	public UserInfo getUserInfo(String openId) {
//		// 读取缓存
//		UserInfo userInfo = redisClientService.get(USERINFO_KEY + openId, UserInfo.class);
		UserInfo userInfo = null;
		if (userInfo != null) {
			return userInfo;
		}

//		StringBuilder requestURL = new StringBuilder(WeiXinURL.USER_INFO.URL());
//		requestURL.append(accessTokenService.getAccessToken());
//		requestURL.append("&openid=");
//		requestURL.append(openId);
//		requestURL.append("&lang=zh_CN");
//		String result = HttpKit.get(requestURL.toString());
//		// String result=adapterHttpHandler.get(requestURL.toString());
//		logger.info("requestURL:{},result:{}", requestURL.toString(), result);
//
//		userInfo = JSONParser.toStringObject(result, UserInfo.class);
//
//		// 放入缓存
//		redisClientService.set(USERINFO_KEY + openId, userInfo, TimeToLive.DAY);

		return userInfo;
	}

	/**
	 * 设定授权用户信息
	 */
	@Override
	public void setOAuthUserInfo(String accessToken, String openId) {
		StringBuilder requestURL = new StringBuilder(WeiXinURL.OAUTH_USER_INFO.URL());
		requestURL.append(accessToken);
		requestURL.append("&openid=");
		requestURL.append(openId);
		requestURL.append("&lang=zh_CN");
		String result = HttpKit.get(requestURL.toString());
		// String result=adapterHttpHandler.get(requestURL.toString());
		logger.info("requestURL:{},result:{}", requestURL.toString(), result);
//		redisClientService.set(USERINFO_KEY + openId,
//				JSONParser.toStringObject(result, UserInfo.class), TimeToLive.DAY);
		return;
	}

	/**
	 * 获取授权用户信息
	 */
	@Override
	public UserInfo getOAuthUserInfo(String openId) {
//		return redisClientService.get(USERINFO_KEY + openId, UserInfo.class);
		return new UserInfo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putLocationOnly(String key, PointVo point) {
		// 将用户地理位置存放到Redis
		StringBuilder builder = new StringBuilder(USER_LOCATION_KEY);
		builder.append(key);
		logger.info("LOCATION KEY:{}", builder.toString());
//		redisClientService.set(builder.toString(), point, TimeToLive.HOUR);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putLocationToCache(String key, PointVo point) {
		// 将用户地理位置存放到Redis
		StringBuilder builder = new StringBuilder(USER_LOCATION_KEY);
		builder.append(key);
		logger.info("LOCATION KEY:{}", builder.toString());
//		redisClientService.set(builder.toString(), point, TimeToLive.HOUR);

		this.putGeocoderToCache(key, point);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PointVo getLocation(String key) {
		StringBuilder builder = new StringBuilder(USER_LOCATION_KEY);
		builder.append(key);
//		return redisClientService.get(builder.toString(), PointVo.class);
		return new PointVo();
	}

	/**
	 * {@inheritDoc}
	 */
	private void putGeocoderToCache(String key, PointVo point) {
		// 将用户地理位置存放到Redis
		StringBuilder builder = new StringBuilder(USER_GEOCODER_KEY);
		builder.append(key);
		logger.info("GEOCODER KEY:{}", builder.toString());

		// 请求路径
		StringBuilder requestURL = new StringBuilder();
		requestURL.append(BaiduURL.GEOCODER_URL.URL());
//		requestURL.append(sysRefFieldService.baiduAk());
		requestURL.append("&location=");
		requestURL.append(point.getLatitude());
		requestURL.append(",");
		requestURL.append(point.getLongitude());
		requestURL.append("&output=json");
		requestURL.append("&pois=0");
		requestURL.append("&coordtype=wgs84ll");

		logger.info("url:{}", requestURL.toString());

		GeocoderInfoVo geocoderInfo = null;

		try {
			String result = HttpKit.get(requestURL.toString());
			logger.info("result:{}", result);
			geocoderInfo = JSONParser.toStringObject(result, GeocoderInfoVo.class);
			/*
			 * 0 正常 1 服务器内部错误 2 请求参数非法 3 权限校验失败 4 配额校验失败 5 ak不存在或者非法 101 服务禁用
			 * 102 不通过白名单或者安全码不对 2xx 无权限 3xx 配额错误
			 */
			if (!"0".equals(geocoderInfo.getStatus())) {
				logger.info(
						"status:{}",
						geocoderInfo.getStatus()
								+ " 参考http://developer.baidu.com/map/index.php?title=webapi/guide/webservice-geocoding");
			}
		} catch (Exception e) {
			logger.info("error:{}", e.getMessage());
			geocoderInfo = new GeocoderInfoVo();
		}

		geocoderInfo.setUserId(point.getUserId());

		this.setArea(key, geocoderInfo);

//		redisClientService.set(builder.toString(), geocoderInfo, TimeToLive.HOUR);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unused")
	private GeocoderInfoVo getGeocoder(String key) {
		StringBuilder builder = new StringBuilder(USER_GEOCODER_KEY);
		builder.append(key);
//		return redisClientService.get(builder.toString(), GeocoderInfoVo.class);
		return new GeocoderInfoVo();
	}

	/**
	 * 设定用户选择区域和门店
	 */
	@Override
	public void setArea(String key, UserAreaVo userArea) {
		StringBuilder builder = new StringBuilder(USER_AREASTORE_KEY);
		builder.append(key);
		String redisKey = builder.toString();

		// 如果城市变动时
		UserAreaVo oldUserArea = this.getArea(key);
		if (!oldUserArea.getAreaCode().equals(userArea.getAreaCode())) {
			// 清除隐式购物车已选门店、订单、服务信息
//			ShoppingCartVo shoppingCart = shoppingCartService.getShoppingCart(key);
//			shoppingCart.setStoreInfo(null);
//			shoppingCart.setOrderInfo(null);
//			shoppingCart.setProductList(null);
//			shoppingCartService.updateShoppingCart(key, shoppingCart);
//			// 清除显式购物车
//			productCartService.removeProductCart(key);
		}

//		redisClientService.set(redisKey, userArea, TimeToLive.MONTH);
	}

	/**
	 * 设定选择区域
	 */
	private void setArea(String key, GeocoderInfoVo geocoderInfo) {

		String cityCode = null;

		// 但已定位
		if (geocoderInfo != null && geocoderInfo.getResult() != null) {
			cityCode = geocoderInfo.getResult().getCityCode();
			logger.info("定位百度城市代码:{}", cityCode);
		}

		// 根据城市代码判定区域
//		AreaInfoVo areaInfo = storeService.getAreaByCityCode(cityCode);
		AreaInfoVo areaInfo = new AreaInfoVo();
		// 如果定位城市为可选城市，则返回定位城市
		// 否则不定位，返回之前选择城市
		if (StringUtils.isNotEmpty(areaInfo.getAreaCode())) {
			UserAreaVo userArea = new UserAreaVo();
			userArea.setUserId(geocoderInfo.getUserId());
			userArea.setAreaCode(areaInfo.getAreaCode());
			userArea.setAreaName(areaInfo.getAreaName());
			logger.info("定位城市:{}", userArea.getAreaName());
			this.setArea(key, userArea);
		}
	}

	/**
	 * 获取用户选择区域和门店
	 */
	@Override
	public UserAreaVo getArea(String key) {
		StringBuilder builder = new StringBuilder(USER_AREASTORE_KEY);
		builder.append(key);
		String redisKey = builder.toString();

//		UserAreaVo userArea = redisClientService.get(redisKey, UserAreaVo.class);
		UserAreaVo userArea = new UserAreaVo();
		if (userArea == null) {
			userArea = new UserAreaVo();
		}

		if (StringUtils.isEmpty(userArea.getAreaCode())) {
//			userArea.setAreaCode(sysRefFieldService.areaCodeDefault());
//			userArea.setAreaName(sysRefFieldService.areaNameDefault());
//			redisClientService.set(redisKey, userArea, TimeToLive.MONTH);
		}

		return userArea;
	}

	/**
	 * 
	 * 功能描述:设定用户选择区域和门店 <br>
	 * 〈功能详细描述〉
	 *
	 * @param key
	 *            普通用户的标识
	 * @param userId
	 *            用户Id
	 * @param areaInfo
	 *            区域信息
	 * @return 微信用户信息
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public void setArea(String key, String userId, AreaInfoVo areaInfo) {

		UserAreaVo userArea = new UserAreaVo();

		userArea.setUserId(userId);
		if (areaInfo == null || StringUtils.isEmpty(areaInfo.getAreaCode())) {
//			userArea.setAreaCode(sysRefFieldService.areaCodeDefault());
//			userArea.setAreaName(sysRefFieldService.areaNameDefault());
		} else {
			userArea.setAreaCode(areaInfo.getAreaCode());
			userArea.setAreaName(areaInfo.getAreaName());
		}
		this.setArea(key, userArea);
	}

	/**
	 * 
	 * 功能描述: 获取当前客户区域<br>
	 * 〈功能详细描述〉
	 *
	 * @param key
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public String getAreaCode(String key) {
		UserAreaVo userArea = this.getArea(key);
		String areaCode = "";

		if (userArea != null && StringUtils.isNotEmpty(userArea.getAreaCode())) {
			areaCode = userArea.getAreaCode();
		}

		return areaCode;
	}

	/**
	 * 
	 * 功能描述: 获取地理位置<br>
	 * 〈功能详细描述〉
	 *
	 * @param cookie
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public PointVo getPoint(CookieObject cookie) {
		String key = cookie.getKey();
		String cLongitude = cookie.getLongitude();
		String cLatitude = cookie.getLatitude();

		// 获取我的位置信息
		PointVo myWxPoint = null;
		PointVo myPoint = null;

		PointVo point = this.getLocation(key);
		if (point != null && point.getLongitude() != null && point.getLatitude() != null) {
			myWxPoint = new PointVo(point.getLongitude(), point.getLatitude());
			if (myWxPoint != null) {
				logger.info("定位GPS经度：{}", String.valueOf(myWxPoint.getLongitude()));
				logger.info("定位GPS纬度：{}", String.valueOf(myWxPoint.getLatitude()));
			}
			myPoint = CoordinateUtil.convertToAMapPoint(myWxPoint);
			if (myPoint != null) {
				logger.info("定位高德经度：{}", String.valueOf(myPoint.getLongitude()));
				logger.info("定位高德纬度：{}", String.valueOf(myPoint.getLatitude()));
			}
			return myPoint;
		}

		if (StringUtils.isNotEmpty(cLongitude) && StringUtils.isNotEmpty(cLatitude)) {
			myWxPoint = new PointVo(new Double(cLongitude), new Double(cLatitude));
			if (myWxPoint != null) {
				logger.info("缓存GPS经度：{}", String.valueOf(myWxPoint.getLongitude()));
				logger.info("缓存GPS纬度：{}", String.valueOf(myWxPoint.getLatitude()));
			}
			myPoint = CoordinateUtil.convertToAMapPoint(myWxPoint);
			if (myPoint != null) {
				logger.info("缓存高德经度：{}", String.valueOf(myPoint.getLongitude()));
				logger.info("缓存高德纬度：{}", String.valueOf(myPoint.getLatitude()));
			}
		}

		return myPoint;
	}
}