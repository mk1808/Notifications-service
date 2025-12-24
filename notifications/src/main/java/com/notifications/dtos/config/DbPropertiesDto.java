package com.notifications.dtos.config;

import com.notifications.configs.properties.DbProperties;

public class DbPropertiesDto {
	
	public String notificationSource;

	public Long shortPollingClientInactivitySchedulerInterval;
	public Long shortPollingClientInactivityTimeout;
	public Long shortPollingClientRequestInterval;

	public DbPropertiesDto(DbProperties dbProperties) {
		notificationSource = dbProperties.getNotificationSource();
		
		shortPollingClientInactivitySchedulerInterval = dbProperties.getShortPollingClientInactivitySchedulerInterval();
		shortPollingClientInactivityTimeout = dbProperties.getShortPollingClientInactivityTimeout();
		shortPollingClientRequestInterval = dbProperties.getShortPollingClientRequestInterval();
	}

}
