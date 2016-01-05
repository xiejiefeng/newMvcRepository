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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amap.api.location.core.CoordinateConvert;
import com.xjf.wemall.api.entity.user.PointVo;

/**
 * 坐标转换 工具类<br>
 * 〈功能详细描述〉
 * 
 * @author yzq
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class CoordinateUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static final String BAIDU_API_URL = "http://api.map.baidu.com/ag/coord/convert?from=0&to=4&x=%f&y=%f";

	public static PointVo convertToAMapPoint(PointVo point) {
		PointVo amapPoint = null;
		try {
			// 进行坐标转换
			double[] a = {point.getLongitude(), point.getLatitude()};
			double[] b = CoordinateConvert.fromSeveralGpsToAMap(a);
			amapPoint = new PointVo(b[0], b[1]);
		} catch (Exception ex) {
			logger.error(point.toString() + ":经纬度转换为高德经纬度时出现异常"+"方法名：convertToAMapPoint");
		}
		return amapPoint;
	}
	
	public static PointVo convertToBaiduPoint(PointVo point) {
		PointVo baiduPoint = null;
		try {
			// 进行坐标转换
			baiduPoint=analyzeBaiduLocation(point);
		} catch (Exception ex) {
			logger.error(point.toString() + ":经纬度转换为百度经纬度时出现异常"+"方法名：convertToBaiduPoint");
		}
		return baiduPoint;
	}

	private static String getBaiduLocation(PointVo point)throws MalformedURLException, IOException {
		// 拼接完整调用URL
		String url = String.format(BAIDU_API_URL, point.getLongitude(), point.getLatitude());
		HttpURLConnection urlConnection = (HttpURLConnection) (new URL(url).openConnection());
		urlConnection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String lines = reader.readLine();
		reader.close();
		urlConnection.disconnect();
		return lines;
	}

	private static PointVo analyzeBaiduLocation(PointVo originalPoint) {
		
		//用于标记是否转换成功
		PointVo baiduPoint=new PointVo();
		
		try {
			String resultString = getBaiduLocation(originalPoint);
			if (resultString.startsWith("{") && resultString.endsWith("}")) {
				resultString = resultString.substring(1, resultString.length() - 2).replace("\"", "");
				String[] lines = resultString.split(",");
				for (String line : lines) {
					String[] items = line.split(":");
					if (items.length == 2) {
						if ("x".equals(items[0])) {
							baiduPoint.setLongitude(ConvertBase64(items[1]));
						}
						if ("y".equals(items[0])) {
							baiduPoint.setLatitude(ConvertBase64(items[1]));
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(originalPoint.toString() + ":经纬度转换为百度经纬度时出现异常"+"方法名：analyzeBaiduLocation");
		}
		return baiduPoint;
	}

	private static Double ConvertBase64(String str) {
		byte[] bs = Base64.decodeBase64(str);
		return Double.valueOf(new String(bs));
	}
	
}
