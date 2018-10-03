package com.chris.actuator.endpoint;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.chris.actuator.service.SampleStatusService;

@ConfigurationProperties(prefix = "endpoints.samplestatus", ignoreInvalidFields = false)
public class SampleStatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware {

	private ApplicationContext context;

	public SampleStatusEndPoint(String id) {
		super(id);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		this.context = arg0;

	}

	@Override
	public String invoke() {
		SampleStatusService statusService = context.getBean(SampleStatusService.class);
		return "Current Status is: " + statusService.getStatus();
	}

}
