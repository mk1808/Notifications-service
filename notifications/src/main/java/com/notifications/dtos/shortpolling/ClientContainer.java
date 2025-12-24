package com.notifications.dtos.shortpolling;

import java.time.Instant;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientContainer<T> {
	private final Queue<T> notifications = new ConcurrentLinkedQueue<>();
	private Instant lastRequestTime = Instant.now();

	public Instant getLastRequestTime() {
		return lastRequestTime;
	}

	public void setRequestTimeNow() {
		lastRequestTime = Instant.now();
	}

	public Queue<T> getNotifications() {
		return notifications;
	}

}
