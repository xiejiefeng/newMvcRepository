/**
 * 
 */
package com.xjf.wemall.api.entity.wechat.entity;

import java.io.Serializable;

/**
 * @author wanglijun
 *
 */
public class WeiXinValidate implements Serializable{

	/**
	 * 序列
	 */
	private static final long serialVersionUID = -3486229296498840395L;
	
	/**微信加密签名*/
	private String signature;
	/**时间戳*/
	private String timestamp;	
	/** 随机数*/
	private String nonce;	
	/**随机字符串*/
	private String echostr;
	/**
	 * @return the 微信加密签名
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 * @param signature 微信加密签名
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}
	/**
	 * @return   时间戳
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp   时间戳
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * @return 随机数
	 */
	public String getNonce() {
		return nonce;
	}
	/**
	 * @param nonce 随机数
	 */
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	/**
	 * @return the 随机字符串
	 */
	public String getEchostr() {
		return echostr;
	}
	/**
	 * @param echostr 随机字符串
	 */
	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WeiXinValidate [signature=" + signature + ", timestamp="
				+ timestamp + ", nonce=" + nonce + ", echostr=" + echostr + "]";
	}	
	
	
	
}
