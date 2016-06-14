/*
 * Copyright (C), 2013-2016, 上海汽车集团股份有限公司
 * FileName: ProductCartServiceImpl.java
 * Author:   baowenzhou
 * Date:     2016年05月06日 下午3:30:25
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.shoppingcart.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjf.wemall.api.constant.TimeToLive;
import com.xjf.wemall.api.constant.WemallConstants;
import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
//import com.xjf.wemall.api.entity.order.OrderInfoVo;
//import com.xjf.wemall.api.entity.product.ProductCartExtVo;
//import com.xjf.wemall.api.entity.product.ProductVo;
import com.xjf.wemall.api.entity.shoppingcart.CartVo;
import com.xjf.wemall.api.entity.shoppingcart.ProductCartVo;
import com.xjf.wemall.api.util.BeanUtil;
//import com.xjf.wemall.comparator.ProductCartComparator;
import com.xjf.wemall.service.AbstractService;
//import com.xjf.wemall.service.order.api.PreorderBookService;
//import com.xjf.wemall.service.product.api.ProductService;
import com.xjf.wemall.service.shoppingcart.api.ProductCartService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ProductCartServiceImpl extends AbstractService implements ProductCartService {
	private void a(){
		
	}
//
//	/** 提交服务 */
//	@Autowired
//	private PreorderBookService preorderBookService;
//
//	/** 产品信息 */
//	@Autowired
//	private ProductService productService;
//
//	/**
//	 * 功能描述:从缓存更新购物车信息<br>
//	 *
//	 * @param key
//	 * @param shoppingCart
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public void updateProductCart(String key, ProductCartVo productCart) {
//		if (StringUtils.isNotEmpty(key)) {
//			redisClientService.set(this.getKey(key), productCart, TimeToLive.MONTH);
//		}
//	}
//
//	/***
//	 * 
//	 * 功能描述:从缓存删除购物车信息<br>
//	 * 〈功能详细描述〉
//	 * 
//	 * @param key
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public void removeProductCart(String key) {
//		if (StringUtils.isNotEmpty(key)) {
//			redisClientService.del(this.getKey(key));
//		}
//	}
//
//	/***
//	 * 
//	 * 功能描述: 从缓存获取购物车信息<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param key
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	@Override
//	public ProductCartVo getProductCart(String key) {
//		ProductCartVo productCart = new ProductCartVo();
//		if (StringUtils.isNotEmpty(key)) {
//			productCart = redisClientService.get(this.getKey(key), ProductCartVo.class);
//			if (productCart == null) {
//				productCart = new ProductCartVo();
//				productCart.setCartId(key);
//				this.updateProductCart(key, productCart);
//			}
//		}
//		return productCart;
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
//		StringBuilder builder = new StringBuilder(PRODUCTCART_KEY);
//		builder.append(key);
//		return builder.toString();
//	}
//
//	/**
//	 * 
//	 * 功能描述: 获取组号<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	private long getGroupSeq() {
//		// int groupSeq = productCart.getGroupSeq();
//		// List<ProductCartExtVo> productList = productCart.getProductList();
//		//
//		// int groupSeqNew;
//		// if (groupSeq == Integer.MAX_VALUE ||
//		// CollectionUtils.isEmpty(productList)) {
//		// groupSeqNew = 1;
//		// } else {
//		// groupSeqNew = groupSeq++;
//		// }
//		//
//		// if (CollectionUtils.isNotEmpty(productList)) {
//		// boolean jump;
//		// while (true) {
//		// jump = true;
//		//
//		// for (ProductCartExtVo product : productList) {
//		// // 存在相同则递增
//		// if (groupSeqNew == product.getGroupNum()) {
//		// groupSeqNew++;
//		// jump = false;
//		// break;
//		// }
//		// }
//		//
//		// if (jump) {
//		// break;
//		// }
//		// }
//		// }
//		//
//		// productCart.setGroupSeq(groupSeqNew);
//		// return groupSeqNew;
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return System.currentTimeMillis();
//	}
//
//	/**
//	 * 功能描述:添加服务<br>
//	 *
//	 * @param key
//	 * @param spuCode
//	 * @param productList
//	 * @param carModel
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void addProductList(String key, String spuCode, List<ProductVo> productList,
//			CarModelInfoVo carModel) {
//
//		// ProductCartVo productCart = this.getProductCart(key);
//		// List<ProductCartExtVo> productExtListOld =
//		// productCart.getProductList();
//		// if (CollectionUtils.isEmpty(productExtListOld)) {
//		// productExtListOld = new ArrayList<ProductCartExtVo>();
//		// }
//		//
//		// if (CollectionUtils.isNotEmpty(productList)) {
//		// // 获取最新分组号
//		// long groupNum = this.getGroupSeq();
//		//
//		// // 车辆附加信息
//		// Map<String, String> addMap = new HashMap<String, String>();
//		// if (carModel != null) {
//		// addMap.put(WemallConstants.CAR_ADDINFO_PRODUCT_YEAR,
//		// carModel.getCarYear());
//		// }
//		//
//		// ProductCartExtVo productExt = null;
//		// ProductCartExtVo recommandProductOld = null;
//		//
//		// // 促销价格-组
//		// BigDecimal promotionPriceGroup = BigDecimal.ZERO;
//		// // 折后价(含支付折扣)-组
//		// BigDecimal promotionPriceAfterPayGroup = BigDecimal.ZERO;
//		//
//		// // 主服务
//		// for (ProductVo product : productList) {
//		// promotionPriceGroup =
//		// promotionPriceGroup.add(NumberUtil.toBigDecimal(product
//		// .getPromotionPrice()));
//		// promotionPriceAfterPayGroup =
//		// promotionPriceAfterPayGroup.add(NumberUtil
//		// .toBigDecimal(product.getPromotionPriceAfterPay()));
//		// }
//		//
//		// // 主服务
//		// for (ProductVo product : productList) {
//		// productExt = new ProductCartExtVo();
//		// BeanUtil.copy(productExt, product);
//		// // 设定组号
//		// // 有SPU编码时，为一组
//		// if (StringUtils.isNotEmpty(spuCode)) {
//		// productExt.setGroupNum(groupNum);
//		// productExt.setSpuCode(spuCode);
//		// }
//		// // 没有则不同组
//		// else {
//		// productExt.setGroupNum(this.getGroupSeq());
//		// }
//		//
//		// // 设定车型
//		// if (carModel != null) {
//		// productExt.setCarMdmId(carModel.getMdmId());
//		// productExt.setCarAddMap(addMap);
//		// }
//		// // 设定促销价格-组
//		// productExt.setPromotionPriceGroup(promotionPriceGroup);
//		// // 折后价(含支付折扣)-组
//		// productExt.setPromotionPriceAfterPayGroup(promotionPriceAfterPayGroup);
//		// // 默认勾选
//		// productExt.setIsSelected(WemallConstants.FLG_YES);
//		//
//		// productExtListOld.add(productExt);
//		// }
//		//
//		// // 推荐服务
//		// for (ProductVo product : productList) {
//		// // 设定推荐服务
//		// if (CollectionUtils.isNotEmpty(product.getRecommandProduct())) {
//		// for (ProductVo recommandProduct : product.getRecommandProduct()) {
//		// productExt = new ProductCartExtVo();
//		// BeanUtil.copy(productExt, recommandProduct);
//		//
//		// // 判断是否已包含推荐服务
//		// recommandProductOld = this.containsRecommand(productExtListOld,
//		// productExt.getCode());
//		//
//		// if (recommandProductOld == null) {
//		// // 是推荐服务
//		// productExt.setIsRecommand(WemallConstants.FLG_YES);
//		// // 分组
//		// productExt.setGroupNum(this.getGroupSeq());
//		// // 主服务编码
//		// productExt.getParentGroupList().add(product.getCode());
//		// // 默认不勾选
//		// productExt.setIsSelected(WemallConstants.FLG_NO);
//		//
//		// productExtListOld.add(productExt);
//		//
//		// } else {
//		// // 主服务编码
//		// recommandProductOld.getParentCodeList().add(product.getCode());
//		// }
//		// }
//		// }
//		// }
//		// }
//		//
//		// // 服务列表排序
//		// Collections.sort(productExtListOld, new ProductCartComparator());
//		//
//		// productCart.setProductList(productExtListOld);
//		// this.updateProductCart(key, productCart);
//	}
//
//	/**
//	 * 功能描述:添加服务<br>
//	 *
//	 * @param key
//	 * @param cartVo
//	 * @param carModel
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void addProductList(String key, CartVo cartVo, CarModelInfoVo carModel) {
//		ProductCartVo productCart = this.getProductCart(key);
//		List<ProductCartExtVo> productExtList = productCart.getProductList();
//		if (CollectionUtils.isEmpty(productExtList)) {
//			productExtList = new ArrayList<ProductCartExtVo>();
//		}
//
//		// 所选服务为空
//		if (StringUtils.isEmpty(cartVo.getServiceCodes())) {
//			return;
//		}
//
//		// 获取最新分组号
//		long groupNum = this.getGroupSeq();
//
//		// 车辆附加信息
//		Map<String, String> addMap = new HashMap<String, String>();
//		if (carModel != null) {
//			addMap.put(WemallConstants.CAR_ADDINFO_PRODUCT_YEAR, carModel.getCarYear());
//		}
//
//		String[] codeArr = cartVo.getServiceCodes().split(",");
//
//		ProductVo product = null;
//		ProductCartExtVo productExt = null;
//
//		for (String code : codeArr) {
//			// 服务信息(无价格)
//			product = productService.getProduct(code);
//			productExt = new ProductCartExtVo();
//
//			// 复制服务信息
//			BeanUtil.copy(productExt, product);
//
//			// 设定组号
//			// 有SPU编码时，为一组
//			if (StringUtils.isNotEmpty(cartVo.getSpuCode())) {
//				productExt.setGroupNum(groupNum);
//				productExt.setSpuCode(cartVo.getSpuCode());
//			}
//			// 没有则不同组
//			else {
//				productExt.setGroupNum(this.getGroupSeq());
//			}
//
//			// 设定车型
//			if (carModel != null) {
//				productExt.setCarMdmId(carModel.getMdmId());
//				productExt.setCarAddMap(addMap);
//			}
//
//			// 默认勾选
//			productExt.setIsSelected(WemallConstants.FLG_YES);
//
//			productExtList.add(productExt);
//		}
//
//		productCart.setProductList(productExtList);
//		this.updateProductCart(key, productCart);
//	}
//
//	/**
//	 * 功能描述:获取服务列表<br>
//	 *
//	 * @param key
//	 * @param cartVo
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public List<ProductCartExtVo> getProductList(String key, CartVo cartVo) {
//		ProductCartVo productCart = this.getProductCart(key);
//		List<ProductCartExtVo> productExtList = productCart.getProductList();
//		List<ProductCartExtVo> productExtNewList = productCart.getProductList();
//		if (CollectionUtils.isEmpty(productExtList)) {
//			productExtList = new ArrayList<ProductCartExtVo>();
//		}
//
//		long groupNum = 0;
//		long groupNumExt = 0;
//		ProductVo product = null;
//		List<ProductVo> recommandList = null;
//		ProductCartExtVo productExt = null;
//		ProductCartExtVo recommandExt = null;
//		Set<String> recommandCodeSet = new HashSet<String>();
//
//		for (int i = productExtList.size() - 1; i >= 0; i--) {
//			productExt = productExtList.get(i);
//			// for (ProductCartExtVo productExt : productExtList) {
//			groupNum = productExt.getGroupNum();
//
//			// 主服务
//			if (WemallConstants.FLG_NO.equals(productExt.getIsRecommand())) {
//				// 获取价格
//				product = productService.getProductAndRecommand(key, productExt.getCode());
//
//				// 无此服务，或无销售价格
//				if (product == null || product.getOriginalPrice() == null) {
//					// 指定组合的服务不可用
//					this.unavailProduct(productExtList, groupNum);
//
//					// 删除推荐服务的主服务组号
//					this.delRecommandProduct(productExtList, groupNum);
//				}
//				// 有价格服务
//				else {
//					// 复制服务信息
//					BeanUtil.copy(productExt, product);
//					productExt.setGroupNum(groupNum);
//
//					// 可用
//					productExt.setIsAvailable(WemallConstants.FLG_YES);
//
//					// 设定推荐服务
//					recommandList = productExt.getRecommandProduct();
//					if (CollectionUtils.isNotEmpty(recommandList)) {
//						for (ProductVo recommand : recommandList) {
//							// 保存推荐列表
//							recommandCodeSet.add(recommand.getCode());
//
//							// 判断是否已包含推荐服务
//							recommandExt = this.containsRecommand(productExtList,
//									recommand.getCode());
//
//							if (recommandExt == null) {
//								// 复制信息
//								recommandExt = new ProductCartExtVo();
//
//								BeanUtil.copy(recommandExt, recommand);
//
//								// 是推荐服务
//								recommandExt.setIsRecommand(WemallConstants.FLG_YES);
//								// 分组
//								recommandExt.setGroupNum(this.getGroupSeq());
//								// 主服务组号
//								recommandExt.getParentGroupList().add(groupNum);
//								// 默认不勾选
//								recommandExt.setIsSelected(WemallConstants.FLG_NO);
//
//								productExtList.add(recommandExt);
//
//							} else {
//								// 复制信息
//								groupNumExt = recommandExt.getGroupNum();
//								BeanUtil.copy(recommandExt, recommand);
//								recommandExt.setGroupNum(groupNumExt);
//
//								// 主服务组号
//								if (!recommandExt.getParentGroupList().contains(groupNum)) {
//									recommandExt.getParentGroupList().add(groupNum);
//								}
//							}
//						}
//					}
//				}
//			}
//		}
//
//		// 删除不适合推荐服务
//		for (int i = productExtList.size() - 1; i >= 0; i--) {
//			recommandExt = productExtList.get(i);
//			if (WemallConstants.FLG_YES.equals(recommandExt.getIsRecommand())) {
//				// 无主服务组合 或 不在推荐服务列表(无销售价格)
//				if (CollectionUtils.isEmpty(recommandExt.getParentGroupList())
//						|| !recommandCodeSet.contains(recommandExt.getCode())) {
//					productExtList.remove(recommandExt);
//				}
//			}
//		}
//
//		// 更改选择状态
//		this.selectProductList(cartVo.getGroupNums(), productExtNewList);
//
//		// 更新服务列表
//		productCart.setProductList(productExtNewList);
//		this.updateProductCart(key, productCart);
//
//		// 排序
//		Collections.sort(productExtNewList, new ProductCartComparator());
//
//		return productExtNewList;
//	}
//
//	/**
//	 * 
//	 * 功能描述: 判断是否已包含推荐服务<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param productList
//	 * @param code
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	private ProductCartExtVo containsRecommand(List<ProductCartExtVo> productList, String code) {
//		if (CollectionUtils.isNotEmpty(productList) && StringUtils.isNotEmpty(code)) {
//			for (ProductCartExtVo product : productList) {
//				// 当前服务为推荐服务
//				if (WemallConstants.FLG_YES.equals(product.getIsRecommand())) {
//					// 当前服务编码与推荐服务编码一致
//					if (product.getCode().equals(code)) {
//						return product;
//					}
//				}
//			}
//		}
//		return null;
//	}
//
//	/**
//	 * 
//	 * 功能描述: 指定组合的服务不可用<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param productList
//	 * @param parentCode
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	private void unavailProduct(List<ProductCartExtVo> productExtList, long groupNum) {
//		for (ProductCartExtVo productExt : productExtList) {
//			// 相同组合都不可用
//			if (groupNum == productExt.getGroupNum()) {
//				// 不可用
//				productExt.setIsAvailable(WemallConstants.FLG_NO);
//				// 未选中
//				productExt.setIsSelected(WemallConstants.FLG_NO);
//			}
//		}
//	}
//
//	/**
//	 * 功能描述:批量删除服务<br>
//	 *
//	 * @param key
//	 * @param groupNumList
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void delProductList(String key, List<Long> groupNumList) {
//
//		if (CollectionUtils.isEmpty(groupNumList)) {
//			return;
//		}
//
//		ProductCartVo productCart = this.getProductCart(key);
//		List<ProductCartExtVo> productExtList = productCart.getProductList();
//
//		if (CollectionUtils.isEmpty(productExtList)) {
//			return;
//		}
//
//		ProductCartExtVo productExt = null;
//
//		for (Long groupNum : groupNumList) {
//			// 删除主服务
//			for (int i = productExtList.size() - 1; i >= 0; i--) {
//				productExt = productExtList.get(i);
//				if (groupNum == productExt.getGroupNum()) {
//					this.delRecommandProduct(productExtList, groupNum);
//					productExtList.remove(productExt);
//				}
//			}
//		}
//
//		// 删除推荐服务
//		for (int i = productExtList.size() - 1; i >= 0; i--) {
//			productExt = productExtList.get(i);
//			if (WemallConstants.FLG_YES.equals(productExt.getIsRecommand())
//					&& CollectionUtils.isEmpty(productExt.getParentGroupList())) {
//				productExtList.remove(productExt);
//			}
//		}
//
//		productCart.setProductList(productExtList);
//		this.updateProductCart(key, productCart);
//	}
//
//	/**
//	 * 功能描述:删除服务<br>
//	 *
//	 * @param key
//	 * @param groupNum
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void delProduct(String key, long groupNum) {
//		List<Long> groupNumList = new ArrayList<Long>();
//		groupNumList.add(groupNum);
//		this.delProductList(key, groupNumList);
//	}
//
//	/**
//	 * 
//	 * 功能描述: 删除推荐服务的主服务组号<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param productList
//	 * @param parentCode
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	private void delRecommandProduct(List<ProductCartExtVo> productExtList, long groupNum) {
//		for (ProductCartExtVo productExt : productExtList) {
//			// 是推荐服务
//			if (WemallConstants.FLG_YES.equals(productExt.getIsRecommand())) {
//				productExt.getParentGroupList().remove(groupNum);
//			}
//		}
//	}
//
//	/**
//	 * 
//	 * 功能描述: 选中服务<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param groupNums
//	 * @param productExtList
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public void selectProductList(String groupNums, List<ProductCartExtVo> productExtList) {
//
//		if (CollectionUtils.isNotEmpty(productExtList) && StringUtils.isNotEmpty(groupNums)) {
//
//			String[] groupNumArr = groupNums.split(",");
//
//			// 全部未选择
//			boolean allUnSelected = false;
//			if (WemallConstants.FLG_NO.equals(groupNums)) {
//				allUnSelected = true;
//			}
//
//			// 有选择服务
//			for (ProductCartExtVo productExt : productExtList) {
//				if (allUnSelected) {
//					productExt.setIsSelected(WemallConstants.FLG_NO);
//				} else {
//					// 判断有无选择
//					if (ArrayUtils.contains(groupNumArr, String.valueOf(productExt.getGroupNum()))) {
//						productExt.setIsSelected(WemallConstants.FLG_YES);
//					} else {
//						productExt.setIsSelected(WemallConstants.FLG_NO);
//					}
//				}
//			}
//
//		}
//	}
//
//	/**
//	 * 
//	 * 功能描述: 计算服务价格<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param productExtList
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public OrderInfoVo calcOrderMoney(List<ProductCartExtVo> productExtList) {
//		OrderInfoVo orderInfo = new OrderInfoVo();
//
//		List<ProductVo> productList = this.convertProductList(productExtList);
//
//		if (productList.size() > 0) {
//			preorderBookService.calcOrderMoney(orderInfo, productList);
//
//			// 含非固定价格服务时，无总价
//			if (orderInfo.isHasUnFixedProduct()) {
//				orderInfo.setOrderTotalMoneyOnlineAfterPay(null);
//			}
//		}
//
//		return orderInfo;
//	}
//
//	/**
//	 * 
//	 * 功能描述: 转换服务列表<br>
//	 * 〈功能详细描述〉
//	 *
//	 * @param groupNums
//	 * @return
//	 * @see [相关类/方法](可选)
//	 * @since [产品/模块版本](可选)
//	 */
//	public List<ProductVo> convertProductList(List<ProductCartExtVo> productExtList) {
//
//		List<ProductVo> productList = new ArrayList<ProductVo>();
//
//		if (CollectionUtils.isNotEmpty(productExtList)) {
//			ProductVo product = null;
//
//			// 指定服务
//			for (ProductCartExtVo productExt : productExtList) {
//				// 判断是否选中 且是可用
//				if (WemallConstants.FLG_YES.equals(productExt.getIsSelected())
//						&& WemallConstants.FLG_YES.equals(productExt.getIsAvailable())) {
//					product = new ProductVo();
//					BeanUtil.copy(product, productExt);
//					productList.add(product);
//				}
//			}
//		}
//
//		return productList;
//	}
}
