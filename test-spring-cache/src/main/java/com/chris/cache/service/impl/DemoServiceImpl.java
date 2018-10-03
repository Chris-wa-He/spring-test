package com.chris.cache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.chris.cache.dao.PersonRepository;
import com.chris.cache.domain.Person;
import com.chris.cache.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	@CachePut(value = "people", key = "#person.id")
	public Person save(Person person) {

		Person p = personRepository.save(person);
		System.out.println("Cached data with Key/ID: " + p.getId());
		return p;
	}

	@Override
	@CacheEvict(value = "people")
	public void remove(Long id) {
		System.out.println("Deleted cache data with Key/ID:" + id);
		personRepository.delete(id);

	}

	@Override
	@Cacheable(value = "people", key = "#person.id")
	public Person findOne(Person person) {

		Person p = personRepository.findOne(person.getId());

		System.out.println("Cached data with Key/ID: " + p.getId());
		return p;
	}

}
