package com.notifications.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RequestMapping("/api/notifications/sse")
public interface SSEController {

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	SseEmitter connect();
}
