package com.chris.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestSpringCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringCacheApplication.class, args);
	}
}
