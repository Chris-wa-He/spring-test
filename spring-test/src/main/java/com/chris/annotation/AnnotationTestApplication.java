package com.chris.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class AnnotationTestApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationTestConfig.class);

		HelpAnnotationService helpAnnotationService = context.getBean(HelpAnnotationService.class);

		Class c=null;
		try {
			c = Class.forName("com.chris.annotation.WiselyConfiguration");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ComponentScan componentScan= (ComponentScan) c.getAnnotation(ComponentScan.class);
		System.out.println(componentScan.value());
		
		Configuration configuration= (Configuration) c.getAnnotation(Configuration.class);
		System.out.println(configuration.value());
		
		
		
//		Annotation[] annotations = config.getClass().getAnnotations();
//
//		for (Annotation annotation : annotations) {
//
//			System.out.println(annotation.getClass().getName());
//			if (annotation instanceof ComponentScan) {
//				ComponentScan componentScan = (ComponentScan) annotation;
//				System.out.println(componentScan.value());
//			}
//
//			if (annotation instanceof Configuration) {
//				Configuration configuration = (Configuration) annotation;
//				System.out.println(configuration.value());
//			}
//		}

		helpAnnotationService.output();

		context.close();
	}
}
