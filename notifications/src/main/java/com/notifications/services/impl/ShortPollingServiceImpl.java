package com.notifications.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.ShortPollingService;

@Service(NotificationSourceType.SHORT_POLLING)

public class ShortPollingServiceImpl implements NotificationSendService, ShortPollingService {

	Logger logger = LoggerFactory.getLogger(ShortPollingServiceImpl.class);

	
	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by short polling");

	}

}
