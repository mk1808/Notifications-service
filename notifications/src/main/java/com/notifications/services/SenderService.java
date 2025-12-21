package com.notifications.services;

import com.notifications.dtos.NotificationDto;

public interface SenderService {
	
	public void send(NotificationDto dto);

}
