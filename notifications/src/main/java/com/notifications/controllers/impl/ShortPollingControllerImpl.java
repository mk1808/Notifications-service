package com.notifications.controllers.impl;

import com.notifications.controllers.ShortPollingController;
import com.notifications.services.ShortPollingService;

public class ShortPollingControllerImpl implements ShortPollingController {

	private ShortPollingService service;

	public ShortPollingControllerImpl(ShortPollingService service) {
		super();
		this.service = service;
	}

}
