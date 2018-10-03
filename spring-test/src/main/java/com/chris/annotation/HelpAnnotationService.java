package com.chris.annotation;

import org.springframework.stereotype.Service;

@Service
public class HelpAnnotationService {

	public void output() {
		System.out.println("Test annotation bean");
	}
}
