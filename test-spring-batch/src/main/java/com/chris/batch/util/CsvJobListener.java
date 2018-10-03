package com.chris.batch.util;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class CsvJobListener implements JobExecutionListener {

	private Long startTime;
	private Long endTime;

	@Override
	public void beforeJob(JobExecution jobExecution) {
		startTime = System.currentTimeMillis();
		System.out.println("Job Starts:" + jobExecution.getJobConfigurationName());

	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		endTime = System.currentTimeMillis();
		System.out.println("Job end:" + jobExecution.getJobConfigurationName());
		System.out.println("Run time:" + (endTime - startTime) + " ms");

	}

}
