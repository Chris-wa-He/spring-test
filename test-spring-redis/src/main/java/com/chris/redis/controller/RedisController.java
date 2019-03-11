package com.chris.redis.controller;

import com.chris.redis.service.TimeSequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.redis.dao.PersonDao;
import com.chris.redis.domain.Person;

@RestController
public class RedisController {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private TimeSequenceService timeSequenceService;

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

	@RequestMapping("/setBatchObj")
	public String setBatchObj(Integer volume) {

		timeSequenceService.insertObject(volume);
		return "OK";
	}

	@RequestMapping("/setBatchStr")
	public String setBatchStr(Integer volume) {

		timeSequenceService.insertStr(volume);
		return "OK";
	}

}
