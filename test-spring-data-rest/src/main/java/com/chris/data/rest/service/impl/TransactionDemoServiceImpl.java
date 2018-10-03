package com.chris.data.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.data.rest.dao.PersonRepository;
import com.chris.data.rest.domain.Person;
import com.chris.data.rest.service.TransactionDemoService;

@Service
public class TransactionDemoServiceImpl implements TransactionDemoService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional(rollbackFor = IllegalArgumentException.class)
	public Person savePersonWithRollBack(Person person) {

		Person p = personRepository.save(person);

		if (person.getName().equals("Chris")) {
			throw new IllegalArgumentException("Chris already exist! Transaction will roll back.");
		}
		return p;
	}

	@Override
	@Transactional(noRollbackFor = IllegalArgumentException.class)
	public Person savePersonWithoutRollBack(Person person) {

		Person p = personRepository.save(person);

		if (person.getName().equals("Chris")) {
			throw new IllegalArgumentException("Chris already exist! But transaction will not roll back.");
		}
		return p;
	}

}
