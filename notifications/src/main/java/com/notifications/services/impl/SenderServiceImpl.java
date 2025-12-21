package com.notifications.services.impl;

import org.springframework.stereotype.Service;

import com.notifications.configs.properties.DbProperties;
import com.notifications.dtos.NotificationDto;
import com.notifications.factories.NotificationSendFactory;
import com.notifications.services.NotificationSendService;
import com.notifications.services.SenderService;

@Service
public class SenderServiceImpl implements SenderService {
	private final NotificationSendFactory factory;
	
	private final DbProperties properties;

	public SenderServiceImpl(NotificationSendFactory factory, DbProperties properties) {
		super();
		this.factory = factory;
		this.properties = properties;
	}
	
	public void send(NotificationDto dto) {
		NotificationSendService service = factory.get(properties.getNotificationSource());
		service.send(dto);
	}
}
