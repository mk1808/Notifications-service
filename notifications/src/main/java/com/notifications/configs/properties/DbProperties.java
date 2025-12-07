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

	public String getNotificationSource() {
		return notificationSource;
	}

	public void setNotificationSource(String notificationSource) {
		this.notificationSource = notificationSource;
	}

	@Override
	public String toString() {
		return "DbProperties [notificationSource=" + notificationSource + "]";
	}
	
}
