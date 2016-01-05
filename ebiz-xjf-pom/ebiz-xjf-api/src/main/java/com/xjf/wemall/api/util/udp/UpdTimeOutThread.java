package com.xjf.wemall.api.util.udp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xjf.wemall.api.entity.udp.ConnectionClientInfoVo;

public class UpdTimeOutThread extends Thread {
	/**日志*/
    private static final Logger logger=LoggerFactory.getLogger(UpdTimeOutThread.class);

	/**
	 * 线程启动方法
	 */
	public void run() {
		logger.info("UpdTimeOutThread - checkTimeOut is running !!!");
		// UDP超时校验
		checkTimeOut();
	}

	/**
	 * UDP超时校验
	 * 
	 * @return
	 */
	public static void checkTimeOut() {
		try {
			ConnectionClientInfoVo clientInfo = null;
			while (true) {
				logger.info("UpdTimeOutThread - checkTimeOut - Thread");
				// 判断是否超时
				for (String key : UdpSystemDefine.ALLCLIENTS.keySet()) {
					logger.info("UpdTimeOutThread - checkTimeOut - " + key
							+ " -- ON LINE !");
					if (UdpSystemDefine.ALLCLIENTS.get(key) != null) {
						clientInfo = (ConnectionClientInfoVo) UdpSystemDefine.ALLCLIENTS
								.get(key);
						if (System.currentTimeMillis()
								- clientInfo.getHeartTime() > UdpSystemDefine.UDP_HEART_TIMEOUT) {// 用户不在线超时
							UdpSystemDefine.ALLCLIENTS.remove(key);
							logger.info("UpdTimeOutThread - checkTimeOut - "
									+ key + " -- OFF LINE !");
						}
					}
				}
				// 轮询等待
				Thread.sleep(UdpSystemDefine.UDP_TIMEOUT_WAITTIME);
			}
		} catch (Exception e) {
			logger.info("UpdTimeOutThread - checkTimeOut Error !!!");
			logger.info(e.getMessage());
			// 异常后自动重新启动线程
			UpdTimeOutThread updTimeOutThread = new UpdTimeOutThread();
			updTimeOutThread.start();
		}
	}
}
