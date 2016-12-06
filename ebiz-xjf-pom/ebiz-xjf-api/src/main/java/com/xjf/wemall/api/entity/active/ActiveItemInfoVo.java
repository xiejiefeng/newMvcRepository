/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: ButtonInfoVo.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午1:34:06
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.active;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动元素实体 <br> 
 * 〈功能详细描述〉
 *
 * @author xiejiefeng
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ActiveItemInfoVo implements Serializable{

    private static final long serialVersionUID = -1158405890125055698L;
    
    /**唯一标识*/
    private String code;
    
    /**路径URL*/
    private String url;
    
    /**路径URL*/
    private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}
