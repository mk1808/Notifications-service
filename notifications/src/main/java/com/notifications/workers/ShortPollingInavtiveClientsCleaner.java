package com.notifications.workers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.notifications.services.ShortPollingService;

@Component
public class ShortPollingInavtiveClientsCleaner {

	private final ShortPollingService shortPollingService;

	public ShortPollingInavtiveClientsCleaner(ShortPollingService shortPollingService) {
		this.shortPollingService = shortPollingService;
	}

	@Scheduled(fixedRateString = "${app.shortPollingClientInactivitySchedulerInterval}")
	public void scheduleFixedDelayTask() {
		shortPollingService.cleanClients();
	}

}
