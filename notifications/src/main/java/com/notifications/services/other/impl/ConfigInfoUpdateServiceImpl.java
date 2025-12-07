package com.notifications.services.other.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.stereotype.Service;

import com.notifications.models.DbProperty;
import com.notifications.repositories.DbPropertyRepository;
import com.notifications.services.other.ConfigInfoUpdateService;

@Service
public class ConfigInfoUpdateServiceImpl implements ConfigInfoUpdateService, EnvironmentAware {

	private static final String PROPERTY_SOURCE_NAME = "propertiesInsideDatabase";
	private ConfigurableEnvironment environment;
	private DbPropertyRepository repository;

	public ConfigInfoUpdateServiceImpl(ConfigurableEnvironment environment, DbPropertyRepository repository) {
		super();
		this.environment = environment;
		this.repository = repository;
	}

	@Override
	public void updateConfig(Map<String, String> map) {

		updateInDb(map);

		if (environment != null) {
			Map<String, Object> propertiesMap = getPropertiesMap();
			environment.getPropertySources().replace(PROPERTY_SOURCE_NAME,
					new MapPropertySource(PROPERTY_SOURCE_NAME, propertiesMap));
		}

	}

	private Map<String, Object> getPropertiesMap() {
		List<DbProperty> propertiesList = repository.findAll();
		return propertiesList.stream().collect(Collectors.toMap(DbProperty::getKey, DbProperty::getValue));
	}

	private void updateInDb(Map<String, String> map) {
		String key = "app." + map.get("key");
		String value = map.get("value");

		DbProperty existingProperty = repository.findByKey(key);
		if (existingProperty != null) {
			existingProperty.setValue(value);
			repository.save(existingProperty);
			return;
		}
		DbProperty newProperty = new DbProperty();
		newProperty.setKey(key);
		newProperty.setValue(value);
		repository.save(newProperty);
	}

	@Override
	public void setEnvironment(Environment environment) {
		if (environment instanceof ConfigurableEnvironment configurableEnvironment) {
			this.environment = configurableEnvironment;
		}
	}

}
