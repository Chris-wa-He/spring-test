package com.chris.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);

		DemoAwareService awareService = context.getBean(DemoAwareService.class);

		awareService.outputResult();

		context.close();
	}

}
