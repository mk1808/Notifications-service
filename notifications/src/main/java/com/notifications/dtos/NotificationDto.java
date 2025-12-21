package com.notifications.dtos;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class NotificationDto {
	
	public UUID id = UUID.randomUUID();
	public Date created = new Date();
	
	@NotBlank(message = "Content is mandatory")
	public String content;
	public String recipient;

}
