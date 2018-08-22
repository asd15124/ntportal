package com.nt.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Class for creating all configuration for the application
 * 
 * @author suhail.ahmad
 * @version 1.0
 *
 */
@Configuration
public class BaseConfig {

	@Bean
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}
}
