package com.chris.beanInitDes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.chris.beanInitDes")
public class BeanInitDesConfig {

	@Bean(initMethod = "init", destroyMethod = "destory")
	public BeanWayService beanWayService() {
		return new BeanWayService();

	}

	@Bean
	public JSR250WayService jsr250WayService() {
		return new JSR250WayService();

	}

}
