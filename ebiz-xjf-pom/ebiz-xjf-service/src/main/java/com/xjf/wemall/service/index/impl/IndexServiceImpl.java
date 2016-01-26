/*
 * Copyright (C), 2013-2015, 上海汽车集团股份有限公司
 * FileName: BaseServiceImpl.java
 * Author:   dongzejun
 * Date:     2015年5月4日 下午8:35:38
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.index.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.xjf.wemall.adapter.service.api.AdapterService;
import com.xjf.wemall.adapter.service.entity.alibabamap.MapInfo;
import com.xjf.wemall.adapter.service.entity.alibabamap.MapInfoResult;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.service.base.impl.BaseServiceImpl;
import com.xjf.wemall.service.index.api.IndexService;

/**
 * Sevice基类处理
 *
 * @author baowenzhou
 * @see com.saic.ebiz.cxj.service.IBaseService
 */
@Service
public class IndexServiceImpl extends BaseServiceImpl implements IndexService {

	@Autowired
	@Qualifier("adapterMap")
	private AdapterService adapterMap;
	
	@Override
	public Map<String, String> index() {
		Map<String, String> retmap = new HashMap<String, String>();
		retmap.put("1", "a");
		retmap.put("2", "b");
		
		
		return retmap;
	}

	@Override
	public MapInfoResult mapInfo() {
		MapInfo map = new MapInfo();
		map.setA("苏州市");
		
		// 调用车享家接口推送消息
		String requestStr = JSONParser.toJSONString(map);
		MapInfoResult mapInfo = adapterMap
				.getData(MapInfoResult.class, requestStr);
		
		return mapInfo;
	}

	

}
