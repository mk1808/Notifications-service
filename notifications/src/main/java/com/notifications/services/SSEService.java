package com.notifications.services;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public interface SSEService {

	void register(SseEmitter emitter);
}
