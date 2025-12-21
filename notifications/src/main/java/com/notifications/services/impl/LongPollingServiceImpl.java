package com.notifications.services.impl;

import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.LongPollingService;
import com.notifications.services.NotificationSendService;

@Service(NotificationSourceType.LONG_POLLING)
public class LongPollingServiceImpl implements NotificationSendService, LongPollingService {

	public LongPollingServiceImpl() {

	}

	@Override
	public void send(NotificationDto dto) {
		// TODO Auto-generated method stub

	}

}
