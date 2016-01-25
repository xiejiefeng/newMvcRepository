package com.xjf.wemall.web.socket.handler;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.xjf.wemall.api.util.JSONParser;
//import com.xjf.wemall.service.redis.api.RedisJobService;
import com.xjf.wemall.web.socket.entity.SocketObject;
import com.xjf.wemall.web.socket.util.SocketSessionUtils;

/**
 * 功能说明：WebSocket处理器 可以继承 {@link TextWebSocketHandler}/
 * {@link BinaryWebSocketHandler}， 或者简单的实现{@link WebSocketHandler}接口
 */
public class WebSocketHandler extends TextWebSocketHandler {
	
//	/**缓存任务服务*/
//	@Autowired
//    private RedisJobService redisJobService;

	/**
	 * 日志
	 * */
	protected final Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

	/**
	 * 建立连接
	 * 
	 * @param session
	 * @throws Exception
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.info("connect to the websocket success......");
		String socketId = MapUtils.getString(session.getAttributes(), SocketSessionUtils.SOCKET_ID);
		logger.info("socket id:" + socketId);
		SocketSessionUtils.add(socketId, session);
	}

	/**
	 * 收到客户端消息
	 * 
	 * @param session
	 * @param message
	 * @throws Exception
	 */
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String socketId = MapUtils.getString(session.getAttributes(), SocketSessionUtils.SOCKET_ID);

		SocketObject obj = JSONParser.toStringObject(message.getPayload(), SocketObject.class);
		
		if (obj != null) {
			if ("cookie".equals(obj.getAction())) {
				String msg = "";
				
				switch(obj.getValue()) {
				case "shopping": // 刷新购物车缓存
//					shoppingCartService.remove(key);
					break;
				case "mail": // 刷新邮件服务
//					result = mailService.init();
					break;
				default:
					//msg = redisJobService.resetRedis(obj.getValue());
					break;
				}
				msg = "true";
				SocketSessionUtils.sendMessage(socketId, msg);
			}
		}
		
	}

	/**
	 * 出现异常
	 * 
	 * @param session
	 * @param exception
	 * @throws Exception
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception)
			throws Exception {
		String socketId = MapUtils.getString(session.getAttributes(), SocketSessionUtils.SOCKET_ID);

		logger.error("websocket connection exception: " + socketId);
		logger.error(exception.getMessage(), exception);

		SocketSessionUtils.remove(socketId);
	}

	/**
	 * 连接关闭
	 * 
	 * @param session
	 * @param closeStatus
	 * @throws Exception
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
			throws Exception {
		String socketId = MapUtils.getString(session.getAttributes(), SocketSessionUtils.SOCKET_ID);

		SocketSessionUtils.remove(socketId);
	}

	/**
	 * 是否分段发送消息
	 * 
	 * @return
	 */
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}