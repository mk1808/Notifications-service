package com.notifications.dtos.config;

import com.notifications.configs.properties.DbProperties;
import com.notifications.configs.properties.RabbitProperties;

public class ConfigInfoDto {
	public DbPropertiesDto dbProperties;
	public RabbitPropertiesDto rabbitProperties;
	
	public ConfigInfoDto() {
	}

	public ConfigInfoDto(DbProperties dbProperties, RabbitProperties rabbitProperties) {
		this.dbProperties = new DbPropertiesDto(dbProperties);
		this.rabbitProperties = new RabbitPropertiesDto(rabbitProperties);
	}
	
	
}
