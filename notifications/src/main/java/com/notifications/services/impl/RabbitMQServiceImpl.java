package com.notifications.services.impl;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.RabbitMQService;

@Service(NotificationSourceType.RABBIT)

public class RabbitMQServiceImpl implements NotificationSendService, RabbitMQService {

	@Override
	public void send(NotificationDto dto) {
		// TODO Auto-generated method stub

	}

}
