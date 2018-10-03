package com.chris.data.rest.service;

import com.chris.data.rest.domain.Person;

public interface TransactionDemoService {

	public Person savePersonWithRollBack(Person person);

	public Person savePersonWithoutRollBack(Person person);

}
