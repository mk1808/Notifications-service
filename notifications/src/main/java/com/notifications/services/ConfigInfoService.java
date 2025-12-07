package com.notifications.services;

import java.util.Map;

import com.notifications.dtos.config.ConfigInfoDto;

public interface ConfigInfoService {

	ConfigInfoDto getCurrentConfig();

	ConfigInfoDto updateConfig(Map<String, String> map);

}
