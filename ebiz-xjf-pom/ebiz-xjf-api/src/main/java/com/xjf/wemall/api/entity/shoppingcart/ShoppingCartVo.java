/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ShoppingCartVo.java
 * Author:   baowenzhou
 * Date:     2014年9月3日 上午8:50:31
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
//import com.xjf.wemall.api.entity.coupon.CouponInfoVo;
//import com.xjf.wemall.api.entity.order.OrderInfoVo;
//import com.xjf.wemall.api.entity.product.ProductVo;
import com.xjf.wemall.api.entity.store.StoreInfoVo;
import com.xjf.wemall.api.entity.user.CustomInfoVo;

/**
 * 购买物车<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ShoppingCartVo implements Serializable{

    /**
     *  序列化
     */
    private static final long serialVersionUID = -6680502607710133157L;
    
    /**sessionID*/
    private String sessionId;
//    
//    /**订单信息*/
//    private OrderInfoVo orderInfo;
//    
//	/**服务信息*/
//    private List<ProductVo> productList = new ArrayList<ProductVo>();
//    
//    /**门店信息*/
//    private StoreInfoVo storeInfo;
//    
//    /**客户信息*/
//    private CustomInfoVo customInfo;
//
//    /**车辆信息*/
//    private CarModelInfoVo carModelInfo;
//    
//	/**券信息*/
//    private List<CouponInfoVo> couponList = new ArrayList<CouponInfoVo>();
    
    public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
//	
//	public OrderInfoVo getOrderInfo() {
//		return orderInfo;
//	}
//	public void setOrderInfo(OrderInfoVo orderInfo) {
//		this.orderInfo = orderInfo;
//	}
//    public List<ProductVo> getProductList() {
//		return productList;
//	}
//	public void setProductList(List<ProductVo> ProductList) {
//		this.productList = ProductList;
//	}
//	public StoreInfoVo getStoreInfo() {
//		return storeInfo;
//	}
//	public void setStoreInfo(StoreInfoVo storeInfo) {
//		this.storeInfo = storeInfo;
//	}
//	public CustomInfoVo getCustomInfo() {
//		return customInfo;
//	}
//	public void setCustomInfo(CustomInfoVo customInfo) {
//		this.customInfo = customInfo;
//	}
//    public CarModelInfoVo getCarModelInfo() {
//		return carModelInfo;
//	}
//	public void setCarModelInfo(CarModelInfoVo carModelInfo) {
//		this.carModelInfo = carModelInfo;
//	}
//	public List<CouponInfoVo> getCouponList() {
//		return couponList;
//	}
//	public void setCouponList(List<CouponInfoVo> couponList) {
//		this.couponList = couponList;
//	}
	
}
