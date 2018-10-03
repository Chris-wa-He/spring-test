package com.chris.service.aop.impl;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.chris.aop.AopAction;

@Aspect
@Component
public class DemoLogAopAspect {

	@Pointcut("@annotation(com.chris.aop.AopAction)")
	public void annotationCutPoint() {

	}

	@After("annotationCutPoint()")
	public void after(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		Method method = methodSignature.getMethod();
		AopAction action = method.getAnnotation(AopAction.class);

		System.out.println("Annotation AOP:" + action.name());
	}

	@Before("execution(* com.chris.service.aop.impl.DemoMethodService.*(..))")
	public void before(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		Method method = methodSignature.getMethod();

		System.out.println("Method AOP:" + method.getName());
	}

}
