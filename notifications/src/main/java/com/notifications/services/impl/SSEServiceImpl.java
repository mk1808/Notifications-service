package com.notifications.services.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.notifications.dtos.NotificationDto;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.SSEService;

@Service(NotificationSourceType.SSE)
public class SSEServiceImpl implements NotificationSendService, SSEService {

	Logger logger = LoggerFactory.getLogger(SSEServiceImpl.class);

	private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by sse");
		sendEvents(dto);
	}

	@Override
	public void register(SseEmitter emitter) {
		emitters.add(emitter);
		emitter.onCompletion(() -> emitters.remove(emitter));
		emitter.onTimeout(() -> emitters.remove(emitter));
	}

	public void sendEvents(NotificationDto dto) {
		for (SseEmitter emitter : emitters) {
			try {
				emitter.send(dto);
			} catch (IOException e) {
				emitter.complete();
				emitters.remove(emitter);
			}
		}
	}
}
