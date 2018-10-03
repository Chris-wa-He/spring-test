package com.chris.beanInitDes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInitDesApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInitDesConfig.class);

		context.close();
	}
}
