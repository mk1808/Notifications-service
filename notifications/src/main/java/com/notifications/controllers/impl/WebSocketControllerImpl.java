package com.notifications.controllers.impl;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.notifications.controllers.WebSocketController;
import com.notifications.dtos.NotificationDto;

@Controller
public class WebSocketControllerImpl implements WebSocketController {

	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/public")
	public NotificationDto sendMessage(@Payload NotificationDto chatMessage) {
		System.out.println("sendMessage");
		System.out.println(chatMessage.content);
		return chatMessage;
	}

	@MessageMapping("/chat.addUser")
	@SendTo("/topic/public")
	public NotificationDto addUser(@Payload NotificationDto chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		System.out.println("addUser");
		System.out.println(chatMessage.content);
		headerAccessor.getSessionAttributes().put("username", chatMessage.recipient);

		return chatMessage;
	}

}
