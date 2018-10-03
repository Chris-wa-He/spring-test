package com.chris.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.getEnvironment().setActiveProfiles("dev");
		context.register(ProfileConfig.class);
		context.refresh();

		DemoBean bean = context.getBean(DemoBean.class);
		System.out.println(bean.getContext());

		context.close();

		context = new AnnotationConfigApplicationContext();

		context.getEnvironment().setActiveProfiles("prod");
		context.register(ProfileConfig.class);
		context.refresh();

		bean = context.getBean(DemoBean.class);
		System.out.println(bean.getContext());

		context.close();
	}
}
