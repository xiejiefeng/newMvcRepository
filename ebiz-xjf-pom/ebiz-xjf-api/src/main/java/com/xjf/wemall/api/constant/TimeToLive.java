/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: TimeToLive.java
 * Author:   wanglijun
 * Date:     2014年7月29日 下午5:47:34
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.constant;

import java.util.HashMap;
import java.util.Map;

import com.xjf.wemall.api.constant.api.CodeDesc;

/**
 * 有效时间设置 <br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public enum TimeToLive implements CodeDesc{
    
	/** 永久 */
    PERSISTENCE(-1, "永久"),
    /** 30秒 */
    HALFMINUTE(30, "30秒"),
    /** 5分钟 */
    DEFAULT(5*60, "5分钟"),
    /** 15分钟 */
    QUARTER(15*60, "15分钟"),
    /** 30分钟 */
    HALFHOUR(30*60, "30分钟"),
    /** 1小时 */
    HOUR(60*60, "1小时"),
    /** 2小时 */
    THOUR(2*60*60, "2小时"),
    /** 1天 */
    DAY(24*60*60, "1天"),
    /** 30天 */
    MONTH(30*24*60*60, "30天");
    
    /**
     * 构造函数.
     *
     * @param code 枚举代码
     * @param display 枚举显示
     */
    private TimeToLive(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    /** 枚举代码. */
    private Integer code;
    
    /** 枚举显示. */
    private String desc;
    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String desc() {
        return this.desc;
    }
    
    private static Map<String, TimeToLive> stringToEnum = new HashMap<String, TimeToLive>();
    static {
        // Initialize map from constant name to enum constant
        for (TimeToLive value : values()) {
            stringToEnum.put(String.valueOf(value.code()), value);
        }
    }
    
    public static TimeToLive fromCode(int code) {
        return stringToEnum.get(String.valueOf(code));
    }
}
