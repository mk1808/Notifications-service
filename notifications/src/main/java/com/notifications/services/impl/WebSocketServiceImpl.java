package com.notifications.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.WebSocketService;

@Service(NotificationSourceType.WEBSOCKET)
public class WebSocketServiceImpl implements NotificationSendService, WebSocketService {

	Logger logger = LoggerFactory.getLogger(WebSocketServiceImpl.class);

	
	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by websocket");
		
	}

}