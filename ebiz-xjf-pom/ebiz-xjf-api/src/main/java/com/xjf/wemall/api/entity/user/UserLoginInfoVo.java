/*
 * Copyright (C), 2013-2014, 上海汽车集团股份有限公司
 * FileName: UserLoginInfoVo.java
 * Author:   baowenzhou
 * Date:     2015年08月27日 上午10:36:47
 * Description: //模块目的、功能描述      
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
package com.xjf.wemall.api.entity.user;

/**
 * 用户登录表单信息<br>
 * 〈功能详细描述〉
 * 
 * @author baowenzhou
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class UserLoginInfoVo {
    
	/** 手机 */
    private String mobile;
    /** 验证码 */
    private String captcha;
    /** 用户名 */
    private String userName;
    /** 密码 */
    private String password;
    
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
