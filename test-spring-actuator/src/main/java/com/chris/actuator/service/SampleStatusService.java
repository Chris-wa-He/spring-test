package com.chris.actuator.service;

import org.springframework.stereotype.Service;

@Service
public class SampleStatusService {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
