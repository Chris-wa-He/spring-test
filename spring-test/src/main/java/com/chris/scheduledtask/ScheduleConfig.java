package com.chris.scheduledtask;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.chris.scheduledtask")
@EnableScheduling
public class ScheduleConfig {

}
