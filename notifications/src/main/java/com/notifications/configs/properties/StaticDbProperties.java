package com.notifications.configs.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
public class StaticDbProperties{
	Logger logger = LoggerFactory.getLogger(StaticDbProperties.class);

	private Long shortPollingClientInactivityTimeout;

	public Long getShortPollingClientInactivityTimeout() {
		return shortPollingClientInactivityTimeout;
	}

	public void setShortPollingClientInactivityTimeout(Long shortPollingClientInactivityTimeout) {
		this.shortPollingClientInactivityTimeout = shortPollingClientInactivityTimeout;
	}
	
}
