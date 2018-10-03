package com.chris.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskExecutorApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

		AsycnTaskService asycnTaskService = context.getBean(AsycnTaskService.class);

		for (int i = 0; i < 50; i++) {
			try {
				asycnTaskService.executeAsycnTask(i);
				asycnTaskService.executeAsycnTaskPlus(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		context.close();
	}

}
