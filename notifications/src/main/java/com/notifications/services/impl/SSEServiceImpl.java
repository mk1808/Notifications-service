package com.notifications.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.SSEService;


@Service(NotificationSourceType.SSE)
public class SSEServiceImpl implements NotificationSendService, SSEService {

	Logger logger = LoggerFactory.getLogger(SSEServiceImpl.class);
	
	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by sse");

	}


}
