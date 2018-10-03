package com.chris.activemq.provider;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class Provider implements MessageCreator {

	@Override
	public Message createMessage(Session session) throws JMSException {

		return session.createTextMessage("Test message:" + System.currentTimeMillis());
	}

}
