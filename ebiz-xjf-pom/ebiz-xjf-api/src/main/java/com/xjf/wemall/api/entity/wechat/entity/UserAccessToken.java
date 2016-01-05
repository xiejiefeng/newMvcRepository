/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserAccessToken.java
 * Author:   wanglijun
 * Date:     2014年8月26日 下午3:18:42
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.entity;

/**
 * 微信访问列表<br>
 * 通过code换取网页授权access_token
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserAccessToken {
    /***
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     */
    private String access_token;
    /**
     * access_token接口调用凭证超时时间，单位（秒）
     * */
    private Long expires_in;
    /***
     * 用户刷新access_token
     */
    private String refresh_token;
    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     * */
    private String openid;
    /**
     * 用户授权的作用域，使用逗号（,）分隔
     * */
    private String scope;   
    /***
     * 默认
     */
    public UserAccessToken() {
       super();
    }
    
    /**
     * @return 网页授权接口调用凭证
     */
    public String getAccess_token() {
        return access_token;
    }
    /**
     * @param access_token  网页授权接口调用凭证
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    /**
     * @return  接口调用凭证超时时间
     */
    public Long getExpires_in() {
        return expires_in;
    }
    /**
     * @param expires_in 接口调用凭证超时时间
     */
    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
    /**
     * @return 用户刷新access_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }
    /**
     * @param refresh_token 用户刷新access_token
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
     
    
    
    /**
     * @return 用户唯一标识
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * @param openid 用户唯一标识
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * @return  用户授权的作用域
     */
    public String getScope() {
        return scope;
    }
    /**
     * @param scope 用户授权的作用域
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "UserAccessToken [access_token=" + access_token + ", expires_in=" + expires_in + ", refresh_token="
                + refresh_token + ", opendId=" + openid + ", scope=" + scope + "]";
    }
    
    
}
