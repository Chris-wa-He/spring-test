package com.chris.activemq.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination = "my-destination")
	public void receiveMessage(String message) {

		System.out.println("Received: <" + message + ">");

	}

}
