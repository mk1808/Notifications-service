package com.notifications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notifications.dtos.ConfigInfoDto;

@RequestMapping("/api/config")
public interface ConfigInfoController {
	
	@GetMapping
	public ResponseEntity<ConfigInfoDto> getCurrentConfig();

}
