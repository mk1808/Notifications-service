package com.notifications.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notifications.dtos.config.ConfigInfoDto;

@RequestMapping("/api/config")
public interface ConfigInfoController {
	
	@GetMapping
	public ResponseEntity<ConfigInfoDto> getCurrentConfig();
	
	@PutMapping
	public ResponseEntity<ConfigInfoDto> update(@RequestBody Map<String, String> property);

}
