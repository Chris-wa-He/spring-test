package com.chris.cache.service;

import com.chris.cache.domain.Person;

public interface DemoService {

	public Person save(Person person);

	public void remove(Long id);

	public Person findOne(Person person);

}
