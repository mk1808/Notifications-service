package com.notifications.controllers.impl;

import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.LongPollingController;
import com.notifications.services.LongPollingService;

@RestController
public class LongPollingControllerImpl implements LongPollingController {

	private LongPollingService service;

	public LongPollingControllerImpl(LongPollingService service) {
		super();
		this.service = service;
	}

}
