package com.notifications.services;

import com.notifications.dtos.NotificationDto;

public interface ShortPollingService {
	
	NotificationDto getNext(String clientId);
	
	void unregister(String clientId);
	
	void cleanClients();
}
