package com.notifications.workers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.notifications.configs.RabbitMQConfig;

@Component
public class RabbitMQConsumer {
	Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void listen(String message) {
		logger.info("Received message: {}", message);
	}
}
