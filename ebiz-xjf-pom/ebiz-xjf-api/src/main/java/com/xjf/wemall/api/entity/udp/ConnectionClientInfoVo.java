package com.xjf.wemall.api.entity.udp;

/**
 * 需要保存的客户端信息
 * 
 * @author chongwenjun
 */
public class ConnectionClientInfoVo {
	// 客户端IP地址
	private String ip;
	// 客户端打洞端口
	private int port;
	// 用户名
	private String userName;
	// 最新心跳时间
	private long heartTime;

	public ConnectionClientInfoVo() {
		this.ip = "";
		this.port = 0;
		this.userName = "";
		this.heartTime = System.currentTimeMillis();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getHeartTime() {
		return heartTime;
	}

	public void setHeartTime(long heartTime) {
		this.heartTime = heartTime;
	}

}
