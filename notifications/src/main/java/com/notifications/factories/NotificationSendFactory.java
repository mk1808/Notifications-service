package com.notifications.factories;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.notifications.services.NotificationSendService;

@Component
public class NotificationSendFactory {

	private final Map<String, NotificationSendService> services;

	public NotificationSendFactory(Map<String, NotificationSendService> services) {
		this.services = services;
	}

	public NotificationSendService get(String source) {
		NotificationSendService sender = services.get(source);
		if (sender == null) {
			throw new IllegalArgumentException("Unsupported notification source type");
		}
		return sender;
	}
}
