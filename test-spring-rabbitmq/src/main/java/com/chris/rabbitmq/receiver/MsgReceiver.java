package com.chris.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgReceiver {

	@RabbitListener(queues="demo-queue")
	public void receiveMessage(String message) {
		System.out.println("Received:<" + message + ">");
	}

}
