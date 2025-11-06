package com.notifications.services;

import org.springframework.stereotype.Service;

import com.notifications.dtos.ConfigInfoDto;

@Service
public interface ConfigInfoService {

	ConfigInfoDto getCurrentConfig();

}
