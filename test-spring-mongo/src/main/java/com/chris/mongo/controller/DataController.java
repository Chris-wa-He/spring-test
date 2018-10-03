package com.chris.mongo.controller;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.mongo.dao.PersonRepository;
import com.chris.mongo.domain.Location;
import com.chris.mongo.domain.Person;

@RestController
public class DataController {

	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/save")
	public Person save() {

		Person person = new Person("xyz", 40);

		Collection<Location> locations = new LinkedHashSet<Location>();

		Location loc_1 = new Location("GZ", "2000");
		Location loc_2 = new Location("BJ", "2005");
		Location loc_3 = new Location("SH", "2010");
		Location loc_4 = new Location("HK", "2017");

		locations.add(loc_1);
		locations.add(loc_2);
		locations.add(loc_3);
		locations.add(loc_4);

		person.setLocations(locations);

		return personRepository.save(person);

	}

	@RequestMapping("/q1")
	public Person queryByName(String name) {
		return personRepository.findByName(name);
	}

	@RequestMapping("/q2")
	public List<Person> queryByAge(Integer age) {
		return personRepository.withQueryFindByAge(age);
	}

}
