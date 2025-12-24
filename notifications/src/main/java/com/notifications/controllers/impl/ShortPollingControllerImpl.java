package com.notifications.controllers.impl;

import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.ShortPollingController;
import com.notifications.dtos.NotificationDto;
import com.notifications.services.ShortPollingService;

@RestController
public class ShortPollingControllerImpl implements ShortPollingController {

	private final ShortPollingService service;

	public ShortPollingControllerImpl(ShortPollingService service) {
		this.service = service;
	}

	@Override
	public NotificationDto getNext(String clientId) {
		return service.getNext(clientId);
	}

	@Override
	public void unregister(String clientId) {
		service.unregister(clientId);
	}

}
