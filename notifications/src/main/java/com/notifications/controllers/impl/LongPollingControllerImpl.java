package com.notifications.controllers.impl;

import com.notifications.controllers.LongPollingController;
import com.notifications.services.LongPollingService;

public class LongPollingControllerImpl implements LongPollingController {

	private LongPollingService service;

	public LongPollingControllerImpl(LongPollingService service) {
		super();
		this.service = service;
	}

}
