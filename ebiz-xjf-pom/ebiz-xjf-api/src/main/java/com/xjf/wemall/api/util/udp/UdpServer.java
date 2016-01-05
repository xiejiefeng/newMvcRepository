package com.xjf.wemall.api.util.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.xml.ws.ServiceMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.xjf.wemall.api.entity.udp.ConnectionClientInfoVo;

/**
 * UDP服务端
 * 
 * @author yzq
 * 
 */
@Service
public class UdpServer extends Thread {
    
	/**日志*/
    private static final Logger logger=LoggerFactory.getLogger(UdpServer.class);

	/**
	 * run
	 * 
	 * @param
	 * @return
	 */
	public void run() {
		logger.info("UdpServer - StartP2PServiveChanege");
		try {
			StartP2PService();
		} catch (Exception e) {
			logger.info("UdpServer - run - Error !");
			logger.info(e.getMessage());
		}
	}

	/**
	 * 开始P2P交换服务(程序起点)
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	private void StartP2PService() throws Exception {
		logger.info("UdpServer - StartP2PService - port("
				+ UdpSystemDefine.UDP_PORT + ") is running !");
		byte[] buf = new byte[1024];
		DatagramPacket p = new DatagramPacket(buf, 1024);

		boolean isEnd = false;
		// 循环接受
		while (!isEnd) {
			// udp接受消息
			UdpSystemDefine.ds.receive(p);
			// 取出信息
			String content = new String(p.getData(), 0, p.getLength());

			// 日志信息
			logger.info("UdpServer - StartP2PServiveChanege - receive Msg : "
					+ p.getAddress().getHostAddress()
					+ ":"
					+ p.getPort()
					+ " >>>> " + content);

			// 处理控制部分,委托给其他方法做
			if (content.startsWith(UdpSystemDefine.LOGIN)) {
				// 登录
				dealLogin(UdpSystemDefine.ds, p, content);
			} else if (content.startsWith(UdpSystemDefine.HEART)) {
				// 心跳
				dealHeart(UdpSystemDefine.ds, p, content);
			} else if (content.startsWith(UdpSystemDefine.WANT_TO_CONNECT)) {
				// 打洞创建连接
				notifyPunchHole(UdpSystemDefine.ds, p, content);
			} else if (content.startsWith(UdpSystemDefine.SUCCESS_HOLE_TO)) {
				// 维持打洞连接
				notifyPunchHoleSuccess(UdpSystemDefine.ds, p, content);
			} else {
				// 处理协议没有定义过的情况
				dealOther(p, content);
			}
		}
		// 关闭服务器
		UdpSystemDefine.ds.close();
	}

	/**
	 * 处理登陆请求
	 * 
	 * @param DatagramSocket
	 *            ds udp服务
	 * @param DatagramPacket
	 *            p udp信息包
	 * @param String
	 *            content 信息内容
	 * @return
	 */
	private static void dealLogin(DatagramSocket ds, DatagramPacket p,
			String content) {
		ConnectionClientInfoVo clientInfo = new ConnectionClientInfoVo();
		// 分割信息内容
		String[] clientLogin = StringUtils.split(content,
				UdpSystemDefine.SPLITOR);
		// 判断是否有信息
		if (clientLogin != null) {
			// 记录登录信息--用户名
			clientInfo.setUserName(clientLogin[1]);
			// 记录登录信息--ip地址
			clientInfo.setIp(p.getAddress().getHostAddress());
			// 记录登录信息--端口号
			clientInfo.setPort(p.getPort());
			// 记录所有在线用户
			UdpSystemDefine.ALLCLIENTS
					.put(clientInfo.getUserName(), clientInfo);
			logger.info("UdpServer - dealLogin : " + clientInfo.getUserName()
					+ " ( " + clientInfo.getIp() + " : " + clientInfo.getPort()
					+ " )");
		}
	}

	/**
	 * 处理心跳
	 * 
	 * @param DatagramSocket
	 *            ds udp服务
	 * @param DatagramPacket
	 *            p udp信息包
	 * @param String
	 *            content 信息内容
	 * @return
	 */
	private static void dealHeart(DatagramSocket ds, DatagramPacket p,
			String content) {
		logger.info("UdpServer - dealHeart : "
				+ p.getAddress().getHostAddress() + " : " + p.getPort()
				+ " --> " + content);
		ConnectionClientInfoVo clientInfo = null;
		if (UdpSystemDefine.ALLCLIENTS.get(content
				.split(UdpSystemDefine.SPLITOR)[1]) != null) {// 更新心跳
			// 获得用户信息
			clientInfo = (ConnectionClientInfoVo) UdpSystemDefine.ALLCLIENTS
					.get(content.split(UdpSystemDefine.SPLITOR)[1]);
		} else {
			// 获得用户信息
			clientInfo = new ConnectionClientInfoVo();
		}
		// 更新人员信息
		clientInfo.setUserName(content.split(UdpSystemDefine.SPLITOR)[1]);
		// 更新当前心跳时间
		clientInfo.setHeartTime(System.currentTimeMillis());
		// 更新ip地址
		clientInfo.setIp(p.getAddress().getHostAddress());
		// 更新端口号
		clientInfo.setPort(p.getPort());
		// 更新用户信息
		UdpSystemDefine.ALLCLIENTS.put(
				content.split(UdpSystemDefine.SPLITOR)[1], clientInfo);
	}

	/**
	 * 打洞创建连接
	 * 
	 * @param DatagramSocket
	 *            ds udp服务
	 * @param DatagramPacket
	 *            p udp信息包
	 * @param String
	 *            content 信息内容
	 * @return
	 */
	private static void notifyPunchHole(DatagramSocket ds, DatagramPacket p,
			String content) throws IOException {
		// 分割信息内容
		String[] clientInfo = StringUtils.split(content,
				UdpSystemDefine.SPLITOR);
		// 判断是否有信息
		if (clientInfo != null) {
			logger.info("UdpServer - notifyPunchHole : " + clientInfo[3]
					+ " ( " + clientInfo[1] + " : " + clientInfo[2] + " )");
			// 打洞ip
			String punchToIp = p.getAddress().getHostAddress();
			// 打洞端口
			int punchToPort = p.getPort();
			// 消息体
			String sendMsg = UdpSystemDefine.PUNCH_HOLE_TO
					+ UdpSystemDefine.SPLITOR + punchToIp
					+ UdpSystemDefine.SPLITOR + punchToPort;
			logger.info("UdpServer - notifyPunchHole - sendMsg : " + sendMsg);
			// 发送消息
			DatagramPacket p2 = new DatagramPacket(sendMsg.getBytes(),
					sendMsg.getBytes().length,
					InetAddress.getByName(clientInfo[1]),
					Integer.parseInt(clientInfo[2]));
			ds.send(p2);
		}

	}

	/**
	 * 通知打洞成功
	 * 
	 * @param DatagramSocket
	 *            ds udp服务
	 * @param DatagramPacket
	 *            p udp信息包
	 * @param String
	 *            content 信息内容
	 * @return
	 */
	private static void notifyPunchHoleSuccess(DatagramSocket ds,
			DatagramPacket p, String content) throws IOException {
		// 分割信息内容
		String[] clientInfo = StringUtils.split(content,
				UdpSystemDefine.SPLITOR);
		// 判断是否有信息
		if (clientInfo != null) {
			// 消息体
			String sendMsg = UdpSystemDefine.CAN_P2P_TO
					+ UdpSystemDefine.SPLITOR + p.getAddress().getHostAddress()
					+ UdpSystemDefine.SPLITOR + p.getPort();
			logger.info("UdpServer - notifyPunchHoleSuccess - sendMsg : "
					+ sendMsg);
			// 发送消息
			DatagramPacket p2 = new DatagramPacket(sendMsg.getBytes(),
					sendMsg.getBytes().length,
					InetAddress.getByName(clientInfo[1]),
					Integer.parseInt(clientInfo[2]));
			ds.send(p2);
		}

	}

	/**
	 * 处理微信端订单预约成功消息通知
	 * 
	 * @param DatagramPacket
	 *            p udp信息包
	 * @param String
	 *            content 信息内容
	 * @return
	 */
	private void dealOther(DatagramPacket p,String content) {
//	  //获取我的位置信息
//        PointVo myWxPoint=null;
//        PointVo myPoint=null;
//        
//		// 分割信息内容
//		String[] clientInfo = StringUtils.split(content,",");
//		// 判断是否有信息
//		if (clientInfo != null) {
//			String membername=clientInfo[0];
//			String orderno=clientInfo[1];
//			if(!StringUtils.isEmpty(membername)){
//				//获取用户openId
//				CustomInfoVo curUserInfo =uSERService.queryUserInfo(membername);
//				String openId=curUserInfo.getWxNo();
//				
//				//获取订单信息
//				OrderInfoVo curOrderInfo=orderService.getOrderInfo(openId, orderno);
//				
//				//获取门店信息
//		          EventMessage curEventMessage =userInfoService.getLocation(openId);
//		          if(curEventMessage!=null&&curEventMessage.getLongitude()!=null&&curEventMessage.getLatitude()!=null){
//		              myWxPoint=new PointVo(curEventMessage.getLongitude(),curEventMessage.getLatitude());
////		              myPoint=CoordinateUtil.convertToBaiduPoint(myWxPoint);
//		              myPoint=CoordinateUtil.convertToAMapPoint(myWxPoint);
//		          }
//		          String storeNo=curOrderInfo.getDeptCode();
//		          StoreInfoVo store =storeService.getStoreInfo(storeNo,myPoint);
//		          String storeName="";
//		          if(store!=null && !StringUtils.isEmpty(store.getStoreName())){
//		              storeName=store.getStoreName();
//		          }
//				
//				//发送消息
//				messageSendMessage.sendPreOrderSuccess(openId,curOrderInfo,storeName);
//			}
//		}
//		logger.info("UdpServer - dealOther : "+ p.getAddress().getHostAddress() + " : " + p.getPort()+ " --> " + content);
	}
}
