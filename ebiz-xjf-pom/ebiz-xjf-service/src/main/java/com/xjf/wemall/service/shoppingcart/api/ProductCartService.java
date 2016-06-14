/*
 * Copyright (C), 2013-2016, 上海汽车集团股份有限公司
 * FileName: ProductCartService.java
 * Author:   baowenzhou
 * Date:     2016年05月06日 下午3:25:07
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.shoppingcart.api;

import java.util.List;

import com.xjf.wemall.api.entity.carmodel.CarModelInfoVo;
import com.xjf.wemall.api.entity.shoppingcart.CartVo;
import com.xjf.wemall.api.entity.shoppingcart.ProductCartVo;

/**
 * 购物车实现接口定义类<br>
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ProductCartService {

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
//	public ProductCartVo getProductCart(String key);
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
//	public void removeProductCart(String key);
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
//	public void updateProductCart(String key, ProductCartVo productCart);
//
////	/**
////	 * 功能描述:添加服务<br>
////	 *
////	 * @param key
////	 * @param spuCode
////	 * @param productList
////	 * @param carModel
////	 * @return
////	 * @see [相关类/方法](可选)
////	 * @since [产品/模块版本](可选)
////	 */
////	public void addProductList(String key, String spuCode, List<ProductVo> productList,
////			CarModelInfoVo carModel);
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
//	public void addProductList(String key, CartVo cartVo, CarModelInfoVo carModel);
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
//	public List<ProductCartExtVo> getProductList(String key, CartVo cartVo);
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
//	public void delProductList(String key, List<Long> groupNumList);
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
//	public void delProduct(String key, long groupNum);
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
//	public void selectProductList(String groupNums, List<ProductCartExtVo> productExtList);
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
//	public OrderInfoVo calcOrderMoney(List<ProductCartExtVo> productExtList);
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
//	public List<ProductVo> convertProductList(List<ProductCartExtVo> productExtList);
}
