package com.notifications.enums;

public class NotificationSourceType {
	public static final String SSE = "SSE";
	public static final String LONG_POLLING = "LONG_POLLING";
	public static final String SHORT_POLLING = "SHORT_POLLING";
	public static final String WEBSOCKET = "WEBSOCKET";
	public static final String RABBIT = "RABBIT";
	
	private NotificationSourceType() {}

}
