package com.reservation.reservationevent.component;

import java.util.ArrayList;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint("/websocket")
public class WebSocket {
	// WebSocket Session in list
	private static ArrayList<Session> sessionList = new ArrayList<Session>();

	// WebSocket Client Connect
	@OnOpen
	public void handleOpen(Session session) {
		if(session != null) {
			String sessionId = session.getId();

			System.out.println("client connection : " + sessionId);

			sessionList.add(session);

			// WebSocket Connection User send Message
			// sendMessageToAdmin("******** " + sessionId + " is connected ********");
			sendMessageToAll("******** " + sessionId + " is connected ********");
		}
	}

	// WebSocket Message get
	@OnMessage
	public String handleMessage(String message, Session session) {
		if(session != null) {
			String sessionId = session.getId();

			// System.out.println("message get session : " + sessionId);

			String manager = session.getUserPrincipal().getName();

			if(!manager.equals("admin")){
				// sendMessageToAdmin(message);
				sendMessageToAll(message);
			}else {

				// sendMessage(message);
			}
			// String auth = strs[1].trim();

			// sendMessageToAll("******** " + sessionId + " is " + message);
		}

		return null;
	}

	// WebSocket Client Close
	@OnClose
	public void handleClose(Session session) {
		if(session != null) {
			String sessionId = session.getId();

			System.out.println("client disconnect : " + sessionId);

			// sendMessage
			sendMessageToAll("******** " + sessionId + " is disconnected ********");
		}
	}

	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}

	// WebSocket send to Message
	private boolean sendMessageToAll(String message) {
		if(sessionList == null) {
			return false;
		}

		int sessionCount = sessionList.size();
		if(sessionCount < 1) {
			return false;
		}

		Session singleSession = null;
		for(int i = 0; i < sessionCount; i++) {
			singleSession = sessionList.get(i);
			if(singleSession == null) {
				continue;
			}

			if(!singleSession.isOpen()) {
				continue;
			}

			sessionList.get(i).getAsyncRemote().sendText(message);
		}

		return true;
	}

	// private boolean sendMessageToAdmin(String message) {
	// 	if(sessionList == null) {
	// 		return false;
	// 	}
	//
	// 	int sessionCount = sessionList.size();
	// 	if(sessionCount < 1) {
	// 		return false;
	// 	}
	//
	// 	Session singleSession = null;
	// 	for(int i = 0; i < sessionCount; i++) {
	// 		singleSession = sessionList.get(i);
	// 		if(singleSession == null) {
	// 			continue;
	// 		}
	//
	// 		if(!singleSession.isOpen()) {
	// 			continue;
	// 		}
	//
	// 		String temp_roles = singleSession.getUserPrincipal().getName();
	//
	// 		 if(temp_roles.equals("admin")) {
	// 			sessionList.get(i).getAsyncRemote().sendText(message);
	// 		 }
	//
	// 	}
	//
	// 	return true;
	// }
	//
	// private boolean sendMessage(String message) {
	// 	if(sessionList == null) {
	// 		return false;
	// 	}
	//
	// 	int sessionCount = sessionList.size();
	// 	if(sessionCount < 1) {
	// 		return false;
	// 	}
	//
	// 	Session singleSession = null;
	// 	for(int i = 0; i < sessionCount; i++) {
	// 		singleSession = sessionList.get(i);
	// 		if(singleSession == null) {
	// 			continue;
	// 		}
	//
	// 		if(!singleSession.isOpen()) {
	// 			continue;
	// 		}
	//
	// 		String temp_roles = singleSession.getUserPrincipal().getName();
	//
	// 		if(temp_roles.equals(message)) {
	// 			sessionList.get(i).getAsyncRemote().sendText(message + " -> Approve Reservation!");
	// 		}
	//
	// 	}
	//
	// 	return true;
	// }
}
