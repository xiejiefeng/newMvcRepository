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
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.TreeSet;
import com.xjf.wemall.comparator.treeSetComparator;
import com.thoughtworks.xstream.converters.collections.TreeSetConverter;
/**
 * 车型-实体类 <br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class tttest implements Serializable{

	public static void main(String[] arg) {
		int i  = 1;
        //类似于 i++就是 i = i+1;的这结构
       // i <<= 1;//i = i<<1  i等于i乘以2的1次方
        i <<= 2;//i = i<<2  i等于i乘以2的2次方,>>就是相除了
          System.out.println("结果是：" + i);
          
          
          i <<= 2;//i = i<<2  i等于i乘以2的2次方,>>就是相除了
          System.out.println("结果是：" + i);
	}

}
