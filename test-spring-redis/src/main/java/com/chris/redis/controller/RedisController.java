package com.chris.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.redis.dao.PersonDao;
import com.chris.redis.domain.Person;

@RestController
public class RedisController {

	@Autowired
	private PersonDao personDao;

	@RequestMapping("/set")
	public void set() {
		Person person = new Person("1", "test1", 18);
		personDao.save(person);
		personDao.stringRedisTemplateDemo();
	}

	@RequestMapping("/getStr")
	public String getStr() {
		return personDao.getString();
	}

	@RequestMapping("/getPerson")
	public Person getPerson() {
		return personDao.getPerson();
	}

}
