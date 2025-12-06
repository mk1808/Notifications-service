package com.notifications.configs.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
public class DbProperties {

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
