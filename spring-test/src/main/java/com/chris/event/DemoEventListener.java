package com.chris.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoEventListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent event) {

		String msg = event.getMsg();

		System.out.println("DemoEventListener got message \"" + msg + "\" from message publisher.");

	}

}
