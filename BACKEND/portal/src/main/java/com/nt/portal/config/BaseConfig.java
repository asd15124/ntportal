package com.nt.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Class for configuration for application
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Configuration
public class BaseConfig {

	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		return new MappingJackson2HttpMessageConverter();
	}
}
