/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: AjaxObj.java
 * Author:   wanglijun
 * Date:     2014年8月20日 上午10:50:11
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.common;

/**
 * Ajax请求响应对象<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AjaxObject {
    /**
     * 请求成功常量
     */
    public static final int SUCCESS = 1;
    /**
     * 请求失败常量
     */
    public static final int FAILD = 0;
    /**
     * 返回结果 0表示失败 1表示成功
     */
    private int result;
    /**
     * 返回提示信息
     */
    private String msg;
    /**
     * 附加对象，用来存储一些特定的返回信息
     */
    private Object obj;
    
    private String returnUrl;

    /**
     * 构造函数
     */
    public AjaxObject() {
        result = AjaxObject.SUCCESS;
    }

    /**
     * @return result 调用结果
     */
    public int getResult() {
        return result;
    }
    /**
     * @param result 调用结果
     */
    public void setResult(int result) {
        this.result = result;
    }
    /**
     * @return msg 提示信息
     */
    public String getMsg() {
        return msg;
    }
    /**
     * @param msg 提示信息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    /**
     * @return obj 附加对象
     */
    public Object getObj() {
        return obj;
    }
    /**
     * @param obj 附加对象
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }

    /**
     * @return the returnUrl
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * @param returnUrl the returnUrl to set
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    
}
