package com.notifications.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.notifications.dtos.NotificationDto;

public interface WebSocketController {

	@MessageMapping("/chat.connectUser")
	@SendTo("/topic/public")
	NotificationDto connectUser(NotificationDto notificationDto, SimpMessageHeaderAccessor headerAccessor);

}
