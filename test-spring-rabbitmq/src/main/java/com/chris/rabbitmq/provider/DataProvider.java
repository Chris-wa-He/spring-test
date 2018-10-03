package com.chris.rabbitmq.provider;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataProvider implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Bean
	public Queue demoQueue() {
		return new Queue("demo-queue");
	}

	@Override
	public void run(String... arg0) throws Exception {
		rabbitTemplate.convertAndSend("demo-queue", "Hello RabbitMQ");

	}

}
