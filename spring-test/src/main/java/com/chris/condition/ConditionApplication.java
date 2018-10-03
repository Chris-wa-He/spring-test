package com.chris.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chris.condition.service.ListCmdService;

public class ConditionApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);

		ListCmdService listCmdService = context.getBean(ListCmdService.class);

		System.out.println("OS name:" + context.getEnvironment().getProperty("os.name") + "\nlist command: "
				+ listCmdService.showListCmd());

		context.close();
	}
}
