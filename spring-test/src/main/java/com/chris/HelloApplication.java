package com.chris;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chris.config.HelloConfig;
import com.chris.service.impl.SayHelloService;

public class HelloApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig.class);

		SayHelloService shs = context.getBean(SayHelloService.class);

		System.out.println(shs.SayHello("Chris"));

		context.close();
	}

}
