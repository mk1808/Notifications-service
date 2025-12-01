package com.notifications.services.impl;

import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.services.LongPollingService;
import com.notifications.services.NotificationSendService;

@Service
public class LongPollingServiceImpl implements NotificationSendService, LongPollingService {

	@Override
	public void send(NotificationDto dto) {
		// TODO Auto-generated method stub

	}

}
