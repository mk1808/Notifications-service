package com.notifications.configs.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@ConfigurationProperties("app")
@RequestScope
public class DbProperties {
	
	Logger logger = LoggerFactory.getLogger(DbProperties.class);

	private String notificationSource;
	
	private Long shortPollingClientInactivitySchedulerInterval;
	private Long shortPollingClientInactivityTimeout;
	private Long shortPollingClientRequestInterval;

	public String getNotificationSource() {
		return notificationSource;
	}

	public void setNotificationSource(String notificationSource) {
		this.notificationSource = notificationSource;
	}

	public Long getShortPollingClientInactivitySchedulerInterval() {
		return shortPollingClientInactivitySchedulerInterval;
	}

	public void setShortPollingClientInactivitySchedulerInterval(Long shortPollingClientInactivitySchedulerInterval) {
		this.shortPollingClientInactivitySchedulerInterval = shortPollingClientInactivitySchedulerInterval;
	}

	public Long getShortPollingClientInactivityTimeout() {
		return shortPollingClientInactivityTimeout;
	}

	public void setShortPollingClientInactivityTimeout(Long shortPollingClientInactivityTimeout) {
		this.shortPollingClientInactivityTimeout = shortPollingClientInactivityTimeout;
	}

	public Long getShortPollingClientRequestInterval() {
		return shortPollingClientRequestInterval;
	}

	public void setShortPollingClientRequestInterval(Long shortPollingClientRequestInterval) {
		this.shortPollingClientRequestInterval = shortPollingClientRequestInterval;
	}

	@Override
	public String toString() {
		return "DbProperties [notificationSource=" + notificationSource 
				+ ", shortPollingClientInactivitySchedulerInterval=" + shortPollingClientInactivitySchedulerInterval 
				+ ", shortPollingClientInactivityTimeout=" + shortPollingClientInactivityTimeout
				+ ", shortPollingClientRequestInterval=" + shortPollingClientRequestInterval
				+ "]";
	}
	
}
