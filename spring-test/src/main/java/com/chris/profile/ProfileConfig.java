package com.chris.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("com.chris.profile")
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public DemoBean devBean() {
		return new DemoBean("Dev bean");

	}

	@Bean
	@Profile("prod")
	public DemoBean prodBean() {
		return new DemoBean("Prod bean");

	}

}
