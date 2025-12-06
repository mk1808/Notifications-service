package com.notifications.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.configs.properties.DbProperties;
import com.notifications.configs.properties.RabbitProperties;
import com.notifications.dtos.config.ConfigInfoDto;
import com.notifications.services.ConfigInfoService;

import jakarta.annotation.PostConstruct;

@Service
public class ConfigInfoServiceImpl implements ConfigInfoService {

	private DbProperties dbProperties;

	private RabbitProperties rabbitProperties;

	Logger logger = LoggerFactory.getLogger(ConfigInfoServiceImpl.class);

	public ConfigInfoServiceImpl(DbProperties dbProperties, RabbitProperties rabbitProperties) {
		super();
		this.dbProperties = dbProperties;
		this.rabbitProperties = rabbitProperties;
	}

	@Override
	public ConfigInfoDto getCurrentConfig() {
		
		return new ConfigInfoDto(dbProperties, rabbitProperties);
	}

	@PostConstruct
	private void init() {
		logger.info("dbProperties {}", dbProperties);
		logger.info("rabbitProperties {}", rabbitProperties);
	}

}
