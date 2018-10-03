package com.chris.service.aop.impl;

import org.springframework.stereotype.Service;

import com.chris.aop.AopAction;

@Service
public class DemoAnnotationService {

	@AopAction(name = "Chris test AOP")
	public void add() {

	}

}
