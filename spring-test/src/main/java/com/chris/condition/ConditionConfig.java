package com.chris.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.chris.condition.service.ListCmdService;
import com.chris.condition.service.impl.LinuxListCmdService;
import com.chris.condition.service.impl.WindowsListCmdService;

@Configuration
@ComponentScan("com.chris.condition.*")
public class ConditionConfig {

	@Bean
	@Conditional(WindowsCondition.class)
	public ListCmdService windowsListCmdService() {

		return new WindowsListCmdService();
	}

	@Bean
	@Conditional(LinuxCondition.class)
	public ListCmdService linuxListCmdService() {
		return new LinuxListCmdService();
	}

}
