package com.notifications.controllers.impl;

import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.SSEController;
import com.notifications.services.SSEService;

@RestController
public class SSEControllerImpl implements SSEController {

	private SSEService service;

	public SSEControllerImpl(SSEService service) {
		super();
		this.service = service;
	}

}
