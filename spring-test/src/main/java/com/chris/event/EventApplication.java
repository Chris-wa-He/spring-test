package com.chris.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);

		DemoEventPublisher publisher = context.getBean(DemoEventPublisher.class);

		publisher.publishEvent("Hello world!");

		publisher.publishEvent("Nice to meet you!");

		context.close();
	}

}
