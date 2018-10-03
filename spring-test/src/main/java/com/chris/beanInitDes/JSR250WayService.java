package com.chris.beanInitDes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	public JSR250WayService() {
		super();
		System.out.println("Construct method - JSR250WayService");
	}

	@PostConstruct
	public void init() {

		System.out.println("@JSR250-init-method");
	}

	@PreDestroy
	public void destory() {

		System.out.println("@JSR250-destory-method");
	}

}
