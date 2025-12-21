package com.notifications.services.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.configs.properties.DbProperties;
import com.notifications.configs.properties.RabbitProperties;
import com.notifications.dtos.config.ConfigInfoDto;
import com.notifications.services.ConfigInfoService;
import com.notifications.services.other.ConfigInfoUpdateService;

@Service
public class ConfigInfoServiceImpl implements ConfigInfoService {

	private final DbProperties dbProperties;
	private final RabbitProperties rabbitProperties;
	private final ConfigInfoUpdateService configInfoUpdateService;

	Logger logger = LoggerFactory.getLogger(ConfigInfoServiceImpl.class);

	public ConfigInfoServiceImpl(DbProperties dbProperties, RabbitProperties rabbitProperties, ConfigInfoUpdateService configInfoUpdateService) {
		this.dbProperties = dbProperties;
		this.rabbitProperties = rabbitProperties;
		this.configInfoUpdateService = configInfoUpdateService;
	}

	@Override
	public ConfigInfoDto getCurrentConfig() {
		
		return new ConfigInfoDto(dbProperties, rabbitProperties);
	}
	
	@Override
	public ConfigInfoDto updateConfig(Map<String, String> map) {
		
		configInfoUpdateService.updateConfig(map);
		return getCurrentConfig();
	}

}
