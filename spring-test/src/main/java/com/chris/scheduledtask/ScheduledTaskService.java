package com.chris.scheduledtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void fiveSecondsAlert() {

		System.out.println("Five seconds alert:" + dateFormat.format(new Date()));
	}

	@Scheduled(cron="30 * * * * *")
	public void fixTimeExecution() {
		System.out.println("Fix time execution:" + dateFormat.format(new Date()));
	}

}
