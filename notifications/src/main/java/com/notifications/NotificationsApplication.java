package com.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.notifications.configs.DbProperties;
import com.notifications.configs.RabbitProperties;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class NotificationsApplication {
	
	@Autowired
	private DbProperties dbProperties;
	
	@Autowired
	private RabbitProperties rabbit;

	public static void main(String[] args) {
		SpringApplication.run(NotificationsApplication.class, args);
	}
	
	  @PostConstruct
	  private void init() {
	    //System.out.println("Text = "+text);
	    System.out.println("config.toString() "+dbProperties.toString());
	    System.out.println("config.toString() "+rabbit.toString());
	    
	  }

}
