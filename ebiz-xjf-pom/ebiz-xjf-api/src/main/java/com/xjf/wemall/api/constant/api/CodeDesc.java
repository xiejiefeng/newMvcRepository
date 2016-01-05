/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: CodeDesc.java
 * Author:   baowenzhou
 * Date:     2014年7月29日 下午5:54:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant.api;

/**
 * 〈一句话功能简述〉<br> 
 * 〈功能详细描述〉
 *
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface CodeDesc {
    /**
     * 功能描述: <br>
     * 获取枚举类型编码.
     *
     * @return 类型编码
     * @since [商品视图与服务/version=1]
     */
    Integer code();
    
    /**
     * 功能描述: <br>
     * 获取枚举类型字符描述.
     *
     * @return 类型字符描述
     * @since [商品视图与服务/version=1]
     */
    String desc();
}
