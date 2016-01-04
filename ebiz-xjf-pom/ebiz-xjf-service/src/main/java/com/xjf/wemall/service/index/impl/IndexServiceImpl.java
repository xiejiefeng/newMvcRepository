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

import org.springframework.stereotype.Service;

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

	@Override
	public Map<String, String> index() {
		Map<String, String> retmap = new HashMap<String, String>();
		retmap.put("1", "a");
		retmap.put("2", "b");
		return retmap;
	}


}
