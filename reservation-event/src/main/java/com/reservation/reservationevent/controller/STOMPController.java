// package com.reservation.reservationevent.controller;
//
// import org.springframework.messaging.handler.annotation.MessageMapping;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.web.bind.annotation.RestController;
//
// import com.reservation.reservationevent.entity.Message;
//
// import lombok.RequiredArgsConstructor;
//
// @RestController
// @RequiredArgsConstructor
// public class STOMPController {
//
// 	// private final SimpleMessage
// 	private final SimpMessagingTemplate simpMessagingTemplate;
//
// 	@MessageMapping("/message")
// 	public void test(Message message) {
// 		simpMessagingTemplate.convertAndSend("/subscribe/sendMessage/" + message.getReceiver(), message);
// 	}
// }
//
//
