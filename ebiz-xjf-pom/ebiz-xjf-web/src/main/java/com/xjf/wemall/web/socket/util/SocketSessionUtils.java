package com.xjf.wemall.web.socket.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.xjf.wemall.web.socket.handler.WebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能说明：TelSocketSessionUtils 作者：liuxing(2014-12-26 02:32)
 */
public class SocketSessionUtils {

	/**
	 * 日志
	 * */
	protected final static Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);
	
	/**
	 * SOCKET_ID
	 */
	public static final String SOCKET_ID = "SOCKET_ID";
	
	/**
	 * ACTION_NAME
	 */
	public static final String ACTION_NAME = "ACTION_NAME";

	private static Map<String, WebSocketSession> clients = new ConcurrentHashMap<>();

	/**
	 * 保存一个连接
	 * 
	 * @param socketId
	 * @param session
	 */
	public static void add(String socketId, WebSocketSession session) {
		clients.put(socketId, session);
	}

	/**
	 * 获取一个连接
	 * 
	 * @param socketId
	 * @return
	 */
	public static WebSocketSession get(String socketId) {
		return clients.get(socketId);
	}

	/**
	 * 移除一个连接
	 * 
	 * @param inquiryId
	 * @param empNo
	 */
	public static void remove(String socketId) throws IOException {
		clients.remove(socketId);
	}

	/**
	 * 判断是否有效连接 判断是否存在 判断连接是否开启 无效的进行清除
	 * 
	 * @param inquiryId
	 * @param empNo
	 * @return
	 */
	public static boolean hasConnection(String socketId) {
		if (clients.containsKey(socketId)) {
			return true;
		}

		return false;
	}

	/**
	 * 获取连接数的数量
	 * 
	 * @return
	 */
	public static int getSize() {
		return clients.size();
	}

	/**
	 * 发送消息到客户端
	 * 
	 * @param inquiryId
	 * @param empNo
	 * @param message
	 * @throws Exception
	 */
	public static void sendMessage(String socketId, String message) throws Exception {
		if (!hasConnection(socketId)) {
			throw new NullPointerException(socketId + " connection does not exist");
		}

		WebSocketSession session = get(socketId);
		try {
			session.sendMessage(new TextMessage(message));
		} catch (IOException e) {
			logger.error("websocket sendMessage exception: " + socketId);
			logger.error(e.getMessage(), e);
			clients.remove(socketId);
		}
	}

}