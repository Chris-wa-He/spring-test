package com.chris.event;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7098509937599956534L;

	private String msg;

	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
