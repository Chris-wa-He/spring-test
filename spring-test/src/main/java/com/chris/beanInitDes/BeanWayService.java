package com.chris.beanInitDes;

public class BeanWayService {

	public BeanWayService() {
		super();
		System.out.println("Construct method - BeanWayService");
	}

	public void init() {

		System.out.println("@Bean-init-method");
	}

	public void destory() {

		System.out.println("@Bean-destory-method");
	}

}
