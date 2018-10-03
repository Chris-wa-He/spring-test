package com.chris.ELservice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ElApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);

		ElConfig config = context.getBean(ElConfig.class);

		config.outputResoure();

		context.close();
	}

}
