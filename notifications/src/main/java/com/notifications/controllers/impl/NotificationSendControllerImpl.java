package com.notifications.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.NotificationSendController;
import com.notifications.dtos.NotificationDto;
import com.notifications.services.SenderService;

@RestController
public class NotificationSendControllerImpl implements NotificationSendController {

	private final SenderService senderService;

	public NotificationSendControllerImpl(SenderService senderService) {
		this.senderService = senderService;
	}

	@Override
	public ResponseEntity<String> send(NotificationDto notificationDto) {

		senderService.send(notificationDto);
		return ResponseEntity.ok("ok");
	}

}
