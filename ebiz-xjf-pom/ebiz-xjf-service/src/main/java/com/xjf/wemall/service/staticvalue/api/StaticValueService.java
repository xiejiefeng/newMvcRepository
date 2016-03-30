/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: StaticValueService.java
 * Author:   baowenzhou
 * Date:     2016年03月17日 下午5:26:14
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.staticvalue.api;

import java.util.List;
import java.util.Map;

//import com.xjf.wemall.api.entity.sysreference.SysReferenceDetailRestFulVo;

/**
 * 内存变量类<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface StaticValueService {
	
	/**
	 * 
	 * 功能描述: <br>
	 * 获取所有系统参数
	 *
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public String getAllSysReference();
	
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
//	public void setSysReference(String code, List<SysReferenceDetailRestFulVo> detailList);
	
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
	public Map<String, String> getSysReferenceMap(String code);
	
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
	public String getSysReference(String code, String detailCode);
}
