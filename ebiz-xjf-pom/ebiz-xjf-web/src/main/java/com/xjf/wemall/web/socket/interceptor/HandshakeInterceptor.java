package com.xjf.wemall.web.socket.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import com.xjf.wemall.web.socket.util.SocketSessionUtils;

//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import java.util.Map;

/**
 * 功能说明：websocket连接的拦截器 有两种方式
 * 一种是实现接口HandshakeInterceptor，实现beforeHandshake和afterHandshake函数
 * 一种是继承HttpSessionHandshakeInterceptor，重载beforeHandshake和afterHandshake函数
 */
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {

	/**
	 * 从请求中获取唯一标记参数，填充到数据传递容器attributes
	 * 
	 * @param serverHttpRequest
	 * @param serverHttpResponse
	 * @param wsHandler
	 * @param attributes
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest serverHttpRequest,
			ServerHttpResponse serverHttpResponse, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		
		// 解决The extension [x-webkit-deflate-frame] is not supported问题  
		// 比如微信浏览器
        if(serverHttpRequest.getHeaders().containsKey("Sec-WebSocket-Extensions")) {  
        	serverHttpRequest.getHeaders().set("Sec-WebSocket-Extensions", "permessage-deflate");  
        }  
        
		HttpSession session = getSession(serverHttpRequest);
		if (session != null) {
			attributes.put(SocketSessionUtils.SOCKET_ID, session.getId());
		}

		super.beforeHandshake(serverHttpRequest, serverHttpResponse, wsHandler, attributes);

		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler wsHandler, Exception ex) {
		super.afterHandshake(request, response, wsHandler, ex);
	}

	private HttpSession getSession(ServerHttpRequest request) {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
			return serverRequest.getServletRequest().getSession(true);
		}
		return null;
	}

}