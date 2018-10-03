package com.chris.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import com.chris.service.HelloService;
import com.chris.service.impl.HelloServiceImpl2;
import com.chris.service.impl.SayHelloService2;

@Configurable
public class HelloConfig2 {

	@Bean
	public HelloService helloService() {
		return new HelloServiceImpl2();
	}

//	@Bean
//	public SayHelloService2 SayHelloService() {
//		SayHelloService2 shs = new SayHelloService2();
//		shs.setHs(helloService());
//
//		return shs;
//	}

	@Bean
	public SayHelloService2 SayHelloService(HelloService helloService) {
		SayHelloService2 shs = new SayHelloService2();
		shs.setHs(helloService);

		return shs;
	}

}
