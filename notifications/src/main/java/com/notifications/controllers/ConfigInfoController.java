package com.notifications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notifications.dtos.ConfigInfoDto;

@RestController
@RequestMapping("/api/config")
public interface ConfigInfoController {
	
	@GetMapping
	public ResponseEntity<ConfigInfoDto> getCurrentConfig();

}
