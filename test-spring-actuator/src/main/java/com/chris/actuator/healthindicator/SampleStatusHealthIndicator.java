package com.chris.actuator.healthindicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.chris.actuator.service.SampleStatusService;

@Component
public class SampleStatusHealthIndicator implements HealthIndicator {

	@Autowired
	private SampleStatusService statusService;

	@Override
	public Health health() {

		String status = statusService.getStatus();

		if (status == null || !"running".equals(status)) {
			return Health.down().withDetail("Error", "Not running").build();
		}
		return Health.up().build();
	}

}
