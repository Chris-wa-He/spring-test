package com.chris.ELservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoValueService {

	@Value("Other value")
	private String anotherValue;

	public String getAnotherValue() {
		return anotherValue;
	}

	public void setAnotherValue(String anotherValue) {
		this.anotherValue = anotherValue;
	}

}
