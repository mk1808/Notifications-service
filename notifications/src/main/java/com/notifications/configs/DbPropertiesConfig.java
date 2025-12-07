package com.notifications.configs;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import com.notifications.models.DbProperty;
import com.notifications.repositories.DbPropertyRepository;

@Configuration
public class DbPropertiesConfig implements BeanPostProcessor, InitializingBean, EnvironmentAware {

	private ConfigurableEnvironment environment;
	private DbPropertyRepository repository;

	private static final String PROPERTY_SOURCE_NAME = "propertiesInsideDatabase";

	public DbPropertiesConfig(DbPropertyRepository repository) {
		this.repository = repository;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (environment != null) {
			Map<String, Object> propertiesMap = getPropertiesMap();
			environment.getPropertySources().addFirst(new MapPropertySource(PROPERTY_SOURCE_NAME, propertiesMap));
		}
	}

	@Override
	public void setEnvironment(Environment environment) {
		if (environment instanceof ConfigurableEnvironment configurableEnvironment) {
			this.environment = configurableEnvironment;
		}
	}

	private Map<String, Object> getPropertiesMap() {
		List<DbProperty> propertiesList = repository.findAll();
		return propertiesList.stream()
				.collect(Collectors.toMap(
						DbProperty::getKey, 
						DbProperty::getValue
						));
	}
}