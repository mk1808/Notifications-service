package com.notifications.controllers.impl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.notifications.controllers.SSEController;
import com.notifications.services.SSEService;

@RestController
public class SSEControllerImpl implements SSEController {

	private final SSEService service;

	public SSEControllerImpl(SSEService service) {
		this.service = service;
	}

	public SseEmitter connect() {
		SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);
		service.register(emitter);
        return emitter;
	}
}
