/**
 * 
 */
package com.xjf.wemall.api.constant;

import com.xjf.wemall.api.constant.api.URLCode;

/**
 * @author wanglijun
 */
public  enum WeiXinURL implements URLCode<String> {
	/**获取access token*/
	ACCESS_TOKEN_URL ("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&"),
	/**菜单创建URL*/
	MENU_CREATE_URL  ("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="),
	/**菜单删除URL*/
	MENU_DELETE_URL  ("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="),
	/**菜单查询URL*/
	MENU_QUERY_URL   ("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="),
	/**发送客服消息:在48小时内不限制发送次数*/
	SEND_MESSAGE     ("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token="),
	/**模板消息请求*/
	TEMPLATE_URL     ("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="),
	/**二维码请求*/
	QRCODE_TICKET_URL("https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="),
	/**用户信息*/
	USER_INFO        ("https://api.weixin.qq.com/cgi-bin/user/info?access_token="),
	/**模板消息请求*/
	JSAPI_TICKET_URL ("https://api.weixin.qq.com/cgi-bin/ticket/getticket?"),
	
	/**用户获取access token*/
	USER_ACCESS_TOKEN("https://api.weixin.qq.com/sns/oauth2/access_token?"),
	/**授权用户信息*/
	OAUTH_USER_INFO  ("https://api.weixin.qq.com/sns/userinfo?access_token="),
	
	/**二维码显示*/
	SHOW_QRCODE_URL  ("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="),
	
	/**身份验证*/
	WECHAT_OAUTH     ("https://open.weixin.qq.com/connect/oauth2/authorize?"),

	/**重定向到A车站*/
	REDIRECT_URI("wxdomain/user/redirect.htm"),
	/**授权重定向*/
	AUTH_REDIRECT_URL("wxdomain/auth/redirect.htm"),
	/**授权重定向到服务项目首页*/
    SERIVCE_REDIRECT_URL("wxdomain/service/index.htm");
	
	/**URL*/
	private String url;
	
	/**默认构建函数*/
	private WeiXinURL(String url) {
		 this.url=url;
	}

	@Override
	public String URL() {
		return this.url;
	}
}
