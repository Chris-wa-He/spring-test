package com.chris.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoEventPublisher {

	@Autowired
	ApplicationContext applicationContext;

	public void publishEvent(String msg) {
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}
}
