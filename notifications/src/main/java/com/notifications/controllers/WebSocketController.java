package com.notifications.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;

import com.notifications.dtos.NotificationDto;

public interface WebSocketController {

	@MessageMapping("/connectUser")
	@SendTo("/topic/notifications")
	NotificationDto connectUser(NotificationDto notificationDto, SimpMessageHeaderAccessor headerAccessor);

}
