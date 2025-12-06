package com.notifications.dtos.config;

import com.notifications.configs.properties.RabbitProperties;

public class RabbitPropertiesDto {
	
	public String host;

	public RabbitPropertiesDto(RabbitProperties rabbitProperties) {
		this.host = rabbitProperties.getHost();
	}

}
