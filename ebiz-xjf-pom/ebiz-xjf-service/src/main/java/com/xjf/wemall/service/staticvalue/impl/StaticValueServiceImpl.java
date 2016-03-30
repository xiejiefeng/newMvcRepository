/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: StaticValueServiceImpl.java
 * Author:   baowenzhou
 * Date:     2016年03月17日 下午5:26:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.staticvalue.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

//import com.xjf.wemall.api.entity.sysreference.SysReferenceDetailRestFulVo;
import com.xjf.wemall.api.util.JSONParser;
import com.xjf.wemall.service.AbstractService;
import com.xjf.wemall.service.staticvalue.api.StaticValueService;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class StaticValueServiceImpl extends AbstractService implements StaticValueService {

	private static Map<String, Map<String, String>> sysReferenceMap = new HashMap<String, Map<String, String>>();

	/**
	 * 
	 * 功能描述: <br>
	 * 获取所有系统参数
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public String getAllSysReference() {
		return JSONParser.toJSONString(sysReferenceMap);
	}

	/**
	 * 
	 * 功能描述: <br>
	 * 设定系统参数
	 *
	 * @param code
	 * @param detailList
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
//	@Override
//	public synchronized void setSysReference(String code,
//			List<SysReferenceDetailRestFulVo> detailList) {
//
//		Map<String, String> map = new HashMap<String, String>();
//
//		if (CollectionUtils.isNotEmpty(detailList)) {
//			for (SysReferenceDetailRestFulVo detail : detailList) {
//				map.put(detail.getReferenceCode(), detail.getReferenceName());
//			}
//		}
//
//		sysReferenceMap.put(code, map);
//	}

	/**
	 * 
	 * 功能描述: <br>
	 * 根据大类Code获取系统参数
	 *
	 * @param code
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public Map<String, String> getSysReferenceMap(String code) {
		return sysReferenceMap.get(code);
	}

	/**
	 * 
	 * 功能描述: <br>
	 * 根据大类Code、小类DetailCode获取系统参数
	 *
	 * @param code
	 * @param detailCode
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	@Override
	public String getSysReference(String code, String detailCode) {
		Map<String, String> map = sysReferenceMap.get(code);
		if (map != null) {
			return map.get(detailCode);
		}
		return null;
	}

}
