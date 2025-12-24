package com.notifications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.notifications.dtos.NotificationDto;

@RequestMapping("/api/notifications/shortPolling")
public interface ShortPollingController {

	@GetMapping("{clientId}")
	NotificationDto getNext(@PathVariable(name = "clientId") String clientId);
	
	@PatchMapping("unregister/{clientId}")
	void unregister(@PathVariable(name = "clientId") String clientId);
}
