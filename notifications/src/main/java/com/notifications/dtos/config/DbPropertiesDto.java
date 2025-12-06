package com.notifications.dtos.config;

import com.notifications.configs.DbProperties;

public class DbPropertiesDto {
	
	public String notificationSource;

	public DbPropertiesDto(DbProperties dbProperties) {
		this.notificationSource = dbProperties.getNotificationSource();
	}

}
