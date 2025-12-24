package com.notifications.services.impl;

import java.time.Duration;
import java.time.Instant;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.notifications.configs.properties.StaticDbProperties;
import com.notifications.dtos.NotificationDto;
import com.notifications.dtos.shortpolling.ClientContainer;
import com.notifications.enums.NotificationSourceType;
import com.notifications.services.NotificationSendService;
import com.notifications.services.ShortPollingService;

@Service(NotificationSourceType.SHORT_POLLING)
public class ShortPollingServiceImpl implements NotificationSendService, ShortPollingService {
	
	Logger logger = LoggerFactory.getLogger(ShortPollingServiceImpl.class);

    private final StaticDbProperties dbProperties;
	private ConcurrentMap<String, ClientContainer<NotificationDto>> clientsMap = new ConcurrentHashMap<>();

	public ShortPollingServiceImpl(StaticDbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

	@Override
	public void send(NotificationDto dto) {
		logger.info("sending by short polling");
		
		clientsMap.forEach((clientId, clientContainer) -> clientContainer.getNotifications().add(dto));
	}

	@Override
	public NotificationDto getNext(String clientId) {		
		ClientContainer<NotificationDto> clientContainer = getClientContainer(clientId);
		clientContainer.setRequestTimeNow();

		return clientContainer.getNotifications().poll();
	}
	
	private ClientContainer<NotificationDto> getClientContainer(String clientId) {
		return clientsMap.computeIfAbsent(clientId, k -> new ClientContainer<>());
	}

	@Override
	public void cleanClients() {
		boolean didRemove = clientsMap.entrySet().removeIf(this::isClientInactive);
		if(didRemove) {
			logger.info("Removed client because of inactivity");
		}
	}
	
	private boolean isClientInactive(Entry<String, ClientContainer<NotificationDto>> clientEntry) {
		return Duration.between(clientEntry.getValue()
				.getLastRequestTime(), Instant.now())
				.toMillis() > dbProperties.getShortPollingClientInactivityTimeout();
	}

	@Override
	public void unregister(String clientId) {
		clientsMap.remove(clientId);
		logger.info("Removed client because of request");
	}
}
