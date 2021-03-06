package com.xjf.wemall.service.index.api;

import java.util.List;
import java.util.Map;

import com.xjf.wemall.adapter.service.entity.alibabamap.MapInfoResult;
import com.xjf.wemall.service.base.api.BaseService;

/**
 * Sevice接口
 *
 * @author baowenzhou
 */
public interface IndexService extends BaseService{
	public Map<String, String> index();
	
	public MapInfoResult mapInfo();
	
	public List<String> getRedis();
}
