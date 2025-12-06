package com.notifications.controllers.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.ConfigInfoController;
import com.notifications.dtos.config.ConfigInfoDto;
import com.notifications.services.ConfigInfoService;

@RestController
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
