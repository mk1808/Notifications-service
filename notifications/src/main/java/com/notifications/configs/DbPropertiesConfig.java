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
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DbPropertiesConfig implements BeanPostProcessor, InitializingBean, EnvironmentAware {

	private JdbcTemplate jdbcTemplate;
	private ConfigurableEnvironment environment;

	private static final String propertySourceName = "propertiesInsideDatabase";

	public DbPropertiesConfig(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (environment != null) {

			List<Map<String, Object>> propertiesList = getProperties();
			Map<String, Object> propertiesMap = propertiesList.stream()
					.collect(Collectors.toMap(
							prop -> String.valueOf(prop.get("key")), 
							prop -> prop.get("value")
							));

			environment.getPropertySources().addFirst(new MapPropertySource(propertySourceName, propertiesMap));
		}
	}

	private List<Map<String, Object>> getProperties() {
		String sql = "SELECT key, value from props";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void setEnvironment(Environment environment) {
		if (environment instanceof ConfigurableEnvironment) {
			this.environment = (ConfigurableEnvironment) environment;
		}
	}
}