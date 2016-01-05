/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: SQLUtil.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午2:02:33
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.util;

import com.xjf.wemall.api.entity.user.PointVo;

/**
 * 计算距离 工具类<br>
 * 〈功能详细描述〉
 * 
 * @author yzq
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class DistanceUtil {

	// 地球半径
	private static final Double EARTHADIUS = 6370996.81;

	// 根据坐标计算距离
	public static Double calculateDistance(PointVo point1, PointVo point2) {
		Double distance = 0d;

		Double point1Lng = getLoop(point1.getLongitude(), -180d, 180d);
		Double point1Lat = getRange(point1.getLatitude(), -74d, 74d);
		Double point2Lng = getLoop(point2.getLongitude(), -180d, 180d);
		Double point2Lat = getRange(point2.getLatitude(), -74d, 74d);

		Double x1 = degreeToRad(point1Lng);
		Double y1 = degreeToRad(point1Lat);
		Double x2 = degreeToRad(point2Lng);
		Double y2 = degreeToRad(point2Lat);

		distance = EARTHADIUS * Math.acos((Math.sin(y1) * Math.sin(y2) + Math.cos(y1) * Math.cos(y2) * Math.cos(x2 - x1)));

		return distance;
	}

	// 将经度调整为给定范围之间
	private static Double getLoop(Double longitude, Double rangeLowerLimit,
			Double rangehigherLimit) {
		while (longitude.compareTo(rangehigherLimit) > 0) {
			longitude -= rangehigherLimit - rangeLowerLimit;
		}
		while (longitude.compareTo(rangeLowerLimit) < 0) {
			longitude += rangehigherLimit - rangeLowerLimit;
		}
		return longitude;
	}

	// 将纬度调整为给定范围之间
	private static Double getRange(Double latitude, Double rangeLowerLimit,
			Double rangehigherLimit) {
		if (rangeLowerLimit != null) {
			latitude = Math.max(latitude, rangeLowerLimit);
		}
		if (rangehigherLimit != null) {
			latitude = Math.min(latitude, rangehigherLimit);
		}
		return latitude;
	}

	private static Double degreeToRad(Double degree) {
		return Math.PI * degree / 180;
	}
	
}
