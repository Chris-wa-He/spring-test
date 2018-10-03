package com.chris;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chris.config.AopConfig;
import com.chris.service.aop.impl.DemoAnnotationService;
import com.chris.service.aop.impl.DemoMethodService;

public class AopApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		DemoAnnotationService demoAnnotationService = context.getBean(DemoAnnotationService.class);

		DemoMethodService demoMethodService = context.getBean(DemoMethodService.class);

		demoAnnotationService.add();
		demoMethodService.add();

		context.close();
	}
}
