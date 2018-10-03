package com.chris;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chris.config.HelloConfig2;
import com.chris.service.impl.SayHelloService2;

public class HelloApplication2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloConfig2.class);

//		SayHelloService2 shs = context.getBean(SayHelloService2.class);
		SayHelloService2 shs= (SayHelloService2) context.getBean("SayHelloService");

		System.out.println(shs.SayHello("Chris"));

		context.close();
	}

}
