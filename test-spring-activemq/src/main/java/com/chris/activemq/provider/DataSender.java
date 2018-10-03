package com.chris.activemq.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSender implements CommandLineRunner {

	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public void run(String... arg0) throws Exception {

		jmsTemplate.send("my-destination", new Provider());

	}

}
