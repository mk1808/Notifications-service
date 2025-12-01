package com.api_gateway.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfig {
	@Bean
	RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/NOTIFICATIONS/**")
						.filters(f -> f.rewritePath("/NOTIFICATIONS/(?<segment>.*)", "/${segment}"))
						.uri("lb://NOTIFICATIONS"))
				.route(p -> p.path("/**")
						.uri("lb://USERINTERFACE"))
				.build();
	}
}