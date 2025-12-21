package com.notifications.controllers.impl;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.controllers.ConfigInfoController;
import com.notifications.dtos.config.ConfigInfoDto;
import com.notifications.services.ConfigInfoService;

@RestController
public class ConfigInfoControllerImpl implements ConfigInfoController {

	private final ConfigInfoService configInfoService;

	public ConfigInfoControllerImpl(ConfigInfoService configInfoService) {
		this.configInfoService = configInfoService;
	}

	@Override
	public ResponseEntity<ConfigInfoDto> getCurrentConfig() {

		return ResponseEntity.ok(configInfoService.getCurrentConfig());
	}

	@Override
	public ResponseEntity<ConfigInfoDto> update(Map<String, String> property) {
		return ResponseEntity.ok(configInfoService.updateConfig(property));
	}

}
