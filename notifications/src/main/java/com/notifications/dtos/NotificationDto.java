package com.notifications.dtos;

import java.util.Date;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class NotificationDto {
	
	public UUID id;
	public Date created;
	
	@NotBlank(message = "Content is mandatory")
	public String content;
	public String recipient;
	
	public void fillFields() {
		this.created = new Date();
		this.id = UUID.randomUUID();
	}

}
