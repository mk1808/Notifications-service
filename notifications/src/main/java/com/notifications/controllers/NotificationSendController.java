package com.notifications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.dtos.NotificationDto;

@RestController
@RequestMapping("/api/notifications/send")
public interface NotificationSendController {
	
	@PostMapping
	public ResponseEntity<String> send(NotificationDto notificationDto);

}
