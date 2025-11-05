package com.notifications.controllers.impl;

import com.notifications.controllers.SSEController;
import com.notifications.services.SSEService;

public class SSEControllerImpl implements SSEController {
	
	private SSEService service;

	public SSEControllerImpl(SSEService service) {
		super();
		this.service = service;
	}

}
