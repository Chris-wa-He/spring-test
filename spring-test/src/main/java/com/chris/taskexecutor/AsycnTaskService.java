package com.chris.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsycnTaskService {

	@Async
	public void executeAsycnTask(Integer i) throws InterruptedException {

		System.out.println("Thread ID:" + Thread.currentThread().getName() + ". Execute async task ID: " + i);

	}

	@Async
	public void executeAsycnTaskPlus(Integer i) throws InterruptedException {

		System.out.println("Thread ID:" + Thread.currentThread().getName() + ". Execute async task(Plus) ID: " + (i + 1));

	}

}
