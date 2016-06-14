/**
 * 
 */
package com.xjf.wemall.api.constant;

import com.xjf.wemall.api.constant.api.URLCode;

/**
 * @author baowenzhou
 */
public enum BaiduURL implements URLCode<String> {
	/**根据经纬度，定位地址*/
	GEOCODER_URL("http://api.map.baidu.com/geocoder/v2/?ak=");
	
	/**URL*/
	private String url;
	
	/**默认构建函数*/
	private BaiduURL(String url) {
		 this.url=url;
	}

	@Override
	public String URL() {
		return this.url;
	}
}
