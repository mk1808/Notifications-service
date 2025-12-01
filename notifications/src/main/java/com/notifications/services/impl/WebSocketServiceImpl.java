package com.notifications.services.impl;

import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.services.NotificationSendService;
import com.notifications.services.WebSocketService;

@Service
public class WebSocketServiceImpl implements NotificationSendService, WebSocketService {

	@Override
	public void send(NotificationDto dto) {
		// TODO Auto-generated method stub
		
	}

}