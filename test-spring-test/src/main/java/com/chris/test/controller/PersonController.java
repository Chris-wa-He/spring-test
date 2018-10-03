package com.chris.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chris.test.dao.PersonRepository;
import com.chris.test.domain.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Person> findAll() {
		return personRepository.findAll();
	}
}
