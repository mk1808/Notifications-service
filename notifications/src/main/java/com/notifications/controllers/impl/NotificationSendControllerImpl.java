package com.notifications.controllers.impl;

import org.springframework.http.ResponseEntity;

import com.notifications.controllers.NotificationSendController;
import com.notifications.dtos.NotificationDto;
import com.notifications.services.NotificationSendService;

public class NotificationSendControllerImpl implements NotificationSendController {
	
	private NotificationSendService notificationSendService;
	

	public NotificationSendControllerImpl(NotificationSendService notificationSendService) {
		super();
		this.notificationSendService = notificationSendService;
	}


	@Override
	public ResponseEntity<String> send(NotificationDto notificationDto) {
		notificationSendService.send(notificationDto);
		return null;
	}

}
