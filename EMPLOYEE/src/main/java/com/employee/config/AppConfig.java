package com.employee.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelmapper =new ModelMapper();
		modelmapper.getConfiguration()
		.setFieldAccessLevel(AccessLevel.PACKAGE_PRIVATE)
		.setFieldMatchingEnabled(true);
		return modelmapper;	
	}
}
