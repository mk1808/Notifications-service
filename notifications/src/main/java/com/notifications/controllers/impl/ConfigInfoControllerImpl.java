package com.notifications.controllers.impl;

import org.springframework.http.ResponseEntity;

import com.notifications.controllers.ConfigInfoController;
import com.notifications.dtos.ConfigInfoDto;
import com.notifications.services.ConfigInfoService;

public class ConfigInfoControllerImpl implements ConfigInfoController {

	private ConfigInfoService configInfoService;

	public ConfigInfoControllerImpl(ConfigInfoService configInfoService) {
		super();
		this.configInfoService = configInfoService;
	}

	@Override
	public ResponseEntity<ConfigInfoDto> getCurrentConfig() {

		return ResponseEntity.ok(configInfoService.getCurrentConfig());
	}

}
