package com.notifications.services;

import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;

@Service
public interface NotificationSendService {
	
	public void send(NotificationDto dto);

}
