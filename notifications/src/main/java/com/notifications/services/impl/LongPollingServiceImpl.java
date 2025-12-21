package com.notifications.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.LongPollingService;
import com.notifications.services.NotificationSendService;

@Service(NotificationSourceType.LONG_POLLING)
public class LongPollingServiceImpl implements NotificationSendService, LongPollingService {

	Logger logger = LoggerFactory.getLogger(LongPollingServiceImpl.class);

	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by long polling");

	}

}
