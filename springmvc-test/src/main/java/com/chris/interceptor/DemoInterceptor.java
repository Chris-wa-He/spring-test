package com.chris.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		System.out.println("Session: " + request.getSession().getId() + " starts at "
				+ new Date());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		request.removeAttribute("startTime");

		System.out.println("Session: " + request.getSession().getId() + " completed operation within "
				+ (endTime - startTime) + " ms.");
	}

}
