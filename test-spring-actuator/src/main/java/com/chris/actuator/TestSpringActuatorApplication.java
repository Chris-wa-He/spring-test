package com.chris.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.actuator.endpoint.SampleStatusEndPoint;
import com.chris.actuator.service.SampleStatusService;

@SpringBootApplication
@RestController
public class TestSpringActuatorApplication {

	@Autowired
	private SampleStatusService statusService;

	public static void main(String[] args) {
		SpringApplication.run(TestSpringActuatorApplication.class, args);
	}

	@Bean
	public Endpoint<String> sampleStatus() {
		Endpoint<String> endpoint = new SampleStatusEndPoint("samplestatus");
		return endpoint;
	}

	@RequestMapping("/change")
	public String changeStatus(String status) {

		statusService.setStatus(status);

		return "OK";

	}
}
