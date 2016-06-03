/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CarModelInfoVo.java
 * Author:   baowenzhou
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.crazyjavachapter8;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.xjf.wemall.api.util.JSONParser;

/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class iterator implements Serializable{

	public static void main(String[] arg) {
//		Collection books = new HashSet<String>();
		List books = new ArrayList<String>();
		books.add("1");
		books.add("2");
		books.add("11");
		books.add("12");
		
		Iterator it = books.iterator();
		
//		while(it.hasNext()) {
//			String book = (String)it.next();
//			System.out.println(book);
//			if ("2".equals(book)) {
//				it.remove();
//			}
//			book = "4";
//		}

//		for(int i = 0; i<books.size(); i++) {
//			String book = (String) books.get(i);
//			System.out.println(book);
//			if ("2".equals(book)) {
//				books.remove(i);
//			}
//			book = "4";
//		}
		System.out.println(books);
		
		
		Map<String, Object> main = new HashMap<String, Object>();
		main.put("areaCode", "6");
		
		Map<String, Object> cityCoupon = new HashMap<String,Object>();
		
		// 上海
		List<Map<String, Object>> cityCouponInfoList = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest001");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest010");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest011");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		
		cityCoupon.put("6", cityCouponInfoList);
		
		// 全国
		cityCouponInfoList = new ArrayList<Map<String,Object>>();
		
		cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest100");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest101");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		cityCouponInfo = new HashMap<String,Object>();
		cityCouponInfo.put("couponTemplateNo", "601601apptest111");
		cityCouponInfo.put("distExport", "CXJ_APP");
		cityCouponInfo.put("grantNum", "1");
		cityCouponInfoList.add(cityCouponInfo);
		
		
		cityCoupon.put("*", cityCouponInfoList);
		
		main.put("couponInfo", cityCoupon);
		System.out.println(JSONParser.toJSONString(cityCoupon));
		System.out.println(JSONParser.toJSONString(main));
		
	}

}
