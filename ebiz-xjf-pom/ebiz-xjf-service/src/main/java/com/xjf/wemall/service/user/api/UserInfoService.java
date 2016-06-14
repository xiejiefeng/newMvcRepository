/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserInfoService.java
 * Author:   wanglijun
 * Date:     2014年8月26日 上午11:36:49
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.service.user.api;

import com.xjf.wemall.api.entity.common.CookieObject;
import com.xjf.wemall.api.entity.store.AreaInfoVo;
import com.xjf.wemall.api.entity.user.PointVo;
import com.xjf.wemall.api.entity.user.UserAreaVo;
import com.xjf.wemall.api.entity.wechat.entity.UserInfo;

/**
 * 微信用户信息接口<br> 
 * 〈功能详细描述〉
 *
 * @author wanglijun
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface UserInfoService {
    
    /**
     * 
     * 功能描述:用户信息获取 <br>
     * 〈功能详细描述〉
     *
     * @param openId 普通用户的标识
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public UserInfo getUserInfo(String openId);
    
    /**
     * 
     * 功能描述:授权用户信息设定 <br>
     * 〈功能详细描述〉
     *
     * @param accessToken 网页授权接口调用凭证
     * @param openId 普通用户的标识
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void setOAuthUserInfo(String accessToken, String openId);
    
    /**
     * 
     * 功能描述:授权用户信息获取 <br>
     * 〈功能详细描述〉
     *
     * @param openId 普通用户的标识
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public UserInfo getOAuthUserInfo(String openId);
    
    /***
     * 
     * 功能描述:根据用户微信ID将用户地理位置存储到缓存中 <br>
     * 〈功能详细描述〉
     *
     * @param eventMessage
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void putLocationOnly(String key, PointVo point);
    
    /***
     * 
     * 功能描述:根据用户微信ID将用户地理位置存储到缓存中 <br>
     * 〈功能详细描述〉
     *
     * @param eventMessage
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void putLocationToCache(String key, PointVo point);
    
    /***
     * 
     * 功能描述:根据 <br>
     * 〈功能详细描述〉
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public PointVo getLocation(String key);
    
    /**
     * 
     * 功能描述:设定用户选择区域和门店 <br>
     * 〈功能详细描述〉
     *
     * @param key 普通用户的标识
     * @param userArea 用户选择区域和门店
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void setArea(String key, UserAreaVo userArea);
    
    /**
     * 
     * 功能描述:获取用户选择区域和门店 <br>
     * 〈功能详细描述〉
     *
     * @param key 普通用户的标识
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public UserAreaVo getArea(String key);
    
    /**
     * 
     * 功能描述:设定用户选择区域和门店 <br>
     * 〈功能详细描述〉
     *
     * @param key 普通用户的标识
     * @param areaInfo 区域信息
     * @return 微信用户信息
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public void setArea(String key, String userId, AreaInfoVo areaInfo);
    
    /**
     * 
     * 功能描述: 获取当前客户区域<br>
     * 〈功能详细描述〉
     *
     * @param key
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public String getAreaCode(String key);
    
    /**
     * 
     * 功能描述: 获取地理位置<br>
     * 〈功能详细描述〉
     *
     * @param cookie
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public PointVo getPoint(CookieObject cookie);
}
