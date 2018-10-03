package com.chris.scheduledtask;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduleApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);
		
//		context.close();
	}
}
