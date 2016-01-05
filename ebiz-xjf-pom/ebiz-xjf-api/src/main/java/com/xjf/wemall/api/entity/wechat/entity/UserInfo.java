/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserInfo.java
 * Author:   wanglijun
 * Date:     2014年8月19日 下午8:12:08
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.wechat.entity;

import java.io.Serializable;

/**
 * 微信用户信息<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserInfo implements Serializable{

    /**
     */
    private static final long serialVersionUID = -3827698575686181418L; 
    /**用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。*/
    private int subscribe;
    /**用户的标识，对当前公众号唯一*/
    private String opendid;
    /**用户的昵称*/
    private String nickname;
    /**sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知*/
    private int sex;
    /**用户所在城市*/
    private String city;
    /**用户所在国家*/
    private String country;
    /**用户所在省份*/
    private String province;
    /**用户的语言，简体中文为zh_CN*/
    private String language;
    /**   用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空*/
    private String headimgurl;
    /**用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间*/
    private Long  subscribe_time;
    /**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）*/
    private String  unionid;
    /**默认构造函数*/
    public UserInfo() {
        super();
    }
    /**
     * @return the 是否订阅该公众号标识
     */
    public int getSubscribe() {
        return subscribe;
    }
    /**
     * @param subscribe 是否订阅该公众号标识
     */
    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }
    /**
     * @return  用户的标识
     */
    public String getOpendid() {
        return opendid;
    }
    /**
     * @param opendid the 用户的标识
     */
    public void setOpendid(String opendid) {
        this.opendid = opendid;
    }
    /**
     * @return the 用户的昵称
     */
    public String getNickname() {
        return nickname;
    }
    /**
     * @param nickname 用户的昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    /**
     * @return the 性别
     */
    public int getSex() {
        return sex;
    }
    /**
     * @param sex 性别
     */
    public void setSex(int sex) {
        this.sex = sex;
    }
    /**
     * @return the 用户所在城市
     */
    public String getCity() {
        return city;
    }
    /**
     * @param city 用户所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * @return   用户所在国家
     */
    public String getCountry() {
        return country;
    }
    /**
     * @param country 用户所在国家
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * @return the 用户所在省份
     */
    public String getProvince() {
        return province;
    }
    /**
     * @param province 用户所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }
    /**
     * @return the 用户的语言
     */
    public String getLanguage() {
        return language;
    }
    /**
     * @param language 用户的语言
     */
    public void setLanguage(String language) {
        this.language = language;
    }
    /**
     * @return the 用户头像
     */
    public String getHeadimgurl() {
        return headimgurl;
    }
    /**
     * @param headimgurl 用户头像
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
    /**
     * @return the 用户关注时间
     */
    public Long getSubscribe_time() {
        return subscribe_time;
    }
    /**
     * @param subscribe_time 用户关注时间
     */
    public void setSubscribe_time(Long subscribe_time) {
        this.subscribe_time = subscribe_time;
    }
    /**
     * @return the UnionID
     */
    public String getUnionid() {
        return unionid;
    }
    
    /**
     * @param UnionID
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }; 
    
    
}   
