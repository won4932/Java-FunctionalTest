// package com.reservation.reservationevent.handler;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;
//
// import org.springframework.web.socket.CloseStatus;
// import org.springframework.web.socket.PongMessage;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.socket.WebSocketMessage;
// import org.springframework.web.socket.WebSocketSession;
// import org.springframework.web.socket.handler.TextWebSocketHandler;
//
// import com.reservation.reservationevent.entity.Message;
//
// public class MessageHandler extends TextWebSocketHandler {
//
// 	// Map<String, WebSocketSession> users = new ConcurrentHashMap<>();
//
// 	// private final Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();
//
// 	private static List<WebSocketSession> list = new ArrayList<>();
//
// 	// Client Connect
// 	@Override
// 	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//
// 		list.add(session);
//
// 		System.out.println("Client Connection : " + session);
//
// 		// String senderId = getMemberId(session);
//
// 		// String senderId = session.getId();
// 		// sessionMap.put(senderId, session);
// 		//
// 		// Message message = Message.builder()
// 		// 	.sender(senderId)
// 		// 	.receiver("all")
// 		// 	.build();
// 		//
// 		// message.newConnect();
//
// 		// sessionMap.values().forEach(s -> {
// 		// 	try{
// 		// 		if(!s.getId().equals(senderId)) {
// 		// 			s.sendMessage(new TextMessage(message));
// 		// 		}
// 		// 	}
// 		// });
//
//
//
//
//
// 		// if(senderId != null) {
// 		// 	System.out.println("Connection : " + senderId);
// 		// 	users.put(senderId, session);
// 		// }
// 	}
//
// 	// Send Data
// 	@Override
// 	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//
// 		String payload = message.getPayload();
// 		System.out.println("PAYLOAD : " + payload);
//
// 		for(WebSocketSession s : list) {
// 			s.sendMessage(message);
// 		}
//
// 		// String senderId = getMemberId(session);
// 		//
// 		// String msg = message.getPayload();
// 		//
// 		// if(msg != null) {
// 		// 	String[] strs = msg.split(",");
// 		// 	System.out.println(strs);
// 		//
// 		// 	if(strs != null && strs.length == 4) {
// 		// 		String type = strs[0]
// 		// 	}
// 		// }
// 	}
//
// 	@Override
// 	protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
// 		super.handlePongMessage(session, message);
// 	}
//
// 	@Override
// 	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
// 		super.handleTransportError(session, exception);
// 	}
//
// 	@Override
// 	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
// 		System.out.println("Client Closed : " + session);
//
// 		list.remove(session);
// 	}
//
// 	@Override
// 	public boolean supportsPartialMessages() {
// 		return super.supportsPartialMessages();
// 	}
//
// 	// Session select id get
// 	// private String getMemberId(WebSocketSession session) {
// 	// 	Map<String, Object> httpSession = session.getAttributes();
// 	// 	String id = (String) httpSession.get("m_id");
// 	// 	return id==null ? null : id;
// 	// }
// }
