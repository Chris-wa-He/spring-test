package com.chris.data.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.data.rest.domain.Person;
import com.chris.data.rest.service.TransactionDemoService;

@RestController
public class TestTransationController {

	@Autowired
	private TransactionDemoService demoService;

	@RequestMapping("/rollback")
	public Person rollBack(Person person) {

		return demoService.savePersonWithRollBack(person);
	}

	@RequestMapping("/noRollback")
	public Person noRollBack(Person person) {

		return demoService.savePersonWithoutRollBack(person);
	}
}
