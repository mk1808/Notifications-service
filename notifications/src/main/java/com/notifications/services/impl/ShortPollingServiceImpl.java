package com.notifications.services.impl;

import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.services.NotificationSendService;
import com.notifications.services.ShortPollingService;

@Service
public class ShortPollingServiceImpl implements NotificationSendService, ShortPollingService {

	@Override
	public void send(NotificationDto dto) {
		// TODO Auto-generated method stub

	}

}
