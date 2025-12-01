package com.notifications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notifications.dtos.NotificationDto;

@RequestMapping("/api/notifications/send")
public interface NotificationSendController {

	@PostMapping
	public ResponseEntity<String> send(NotificationDto notificationDto);

}
