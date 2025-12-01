package com.notifications.services;

import com.notifications.dtos.NotificationDto;

public interface NotificationSendService {
	
	public void send(NotificationDto dto);

}
