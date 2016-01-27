/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: OrderDateTimeComparator.java
 * Author:   baowenzhou
 * Date:     2015年09月15日 下午2:35:18
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.comparator;

import java.util.Comparator;

import com.xjf.wemall.api.entity.SampleVo;

/**
 *  美容卡时间排序<br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class sampleComparator implements Comparator<SampleVo>{

	// 倒序
    @Override
    public int compare(SampleVo card1, SampleVo card2) {
    	if (card1.getI() < card2.getI()) {
    		return -1;
    	} else {
    		return 1;
    	}
    }
    
}
