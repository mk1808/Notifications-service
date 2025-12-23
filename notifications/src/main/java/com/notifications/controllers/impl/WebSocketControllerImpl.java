package com.notifications.controllers.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.notifications.controllers.WebSocketController;
import com.notifications.dtos.NotificationDto;

@Controller
public class WebSocketControllerImpl implements WebSocketController {

	Logger logger = LoggerFactory.getLogger(WebSocketControllerImpl.class);

	@Override
	public NotificationDto connectUser(@Payload NotificationDto notificationDto, SimpMessageHeaderAccessor headerAccessor) {
		logger.info("User Connected {}", notificationDto.recipient);
		if (notificationDto.recipient != null && headerAccessor.getSessionAttributes() != null) {
			headerAccessor.getSessionAttributes().put("recipient", notificationDto.recipient);
		}

		return notificationDto;
	}

}
