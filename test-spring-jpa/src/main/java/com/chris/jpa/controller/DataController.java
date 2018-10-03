package com.chris.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.jpa.dao.PersonRepository;
import com.chris.jpa.domain.Person;

@RestController
public class DataController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/save")
	public Person save(String name, Integer age, String address) {

		Person person = personRepository.save(new Person(null, name, age, address));

		return person;

	}

	@RequestMapping("/findByName")
	public List<Person> findByName(String name) {

		List<Person> list = personRepository.findByName(name);
		return list;

	}

	@RequestMapping("/findByAddress")
	public List<Person> findByAddress(String address) {

		List<Person> list = personRepository.findByAddress(address);
		return list;

	}

	@RequestMapping("/findByNameAndAddress")
	public Person findByNameAndAddress(String name, String address) {

		Person person = personRepository.findByNameAndAddress(name, address);
		return person;

	}

	@RequestMapping("/withNameAndAddressQuery")
	public Person withNameAndAddressQuery(String name, String address) {

		Person person = personRepository.withNameAndAddressQuery(name, address);
		return person;

	}

	@RequestMapping("/withNameAndAddressNamedQuery")
	public List<Person> withNameAndAddressNamedQuery(String name, String address) {

		List<Person> list = personRepository.withNameAndAddressNamedQuery(name, address);
		return list;

	}

	@RequestMapping("/sort")
	public List<Person> sort() {

		List<Person> list = personRepository.findAll(new Sort(Direction.ASC, "age"));
		return list;

	}

	@RequestMapping("/page")
	public Page<Person> page() {

		Page<Person> pagePerson = personRepository.findAll(new PageRequest(1, 2));
		return pagePerson;

	}

	@RequestMapping("/auto")
	public Page<Person> auto(Person person) {

		Page<Person> pagePerson = personRepository.findByAuto(person, new PageRequest(0, 10));
		return pagePerson;

	}
}
