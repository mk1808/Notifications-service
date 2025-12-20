package com.notifications.controllers.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.NotificationSendController;
import com.notifications.dtos.NotificationDto;
import com.notifications.services.NotificationSendService;

@RestController
public class NotificationSendControllerImpl implements NotificationSendController {

	private NotificationSendService notificationSendService;

	public NotificationSendControllerImpl(@Qualifier("longPollingServiceImpl") NotificationSendService notificationSendService) {
		super();
		this.notificationSendService = notificationSendService;
	}

	@Override
	public ResponseEntity<String> send(NotificationDto notificationDto) {
		notificationDto.fillFields();
		notificationSendService.send(notificationDto);
		return ResponseEntity.ok("ok");
	}

}
