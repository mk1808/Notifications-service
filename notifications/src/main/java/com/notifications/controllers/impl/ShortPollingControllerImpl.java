package com.notifications.controllers.impl;

import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.ShortPollingController;
import com.notifications.services.ShortPollingService;

@RestController
public class ShortPollingControllerImpl implements ShortPollingController {

	private ShortPollingService service;

	public ShortPollingControllerImpl(ShortPollingService service) {
		super();
		this.service = service;
	}

}
