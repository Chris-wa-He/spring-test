package com.chris.mongo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.chris.mongo.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

	public Person findByName(String name);

	@Query("{'age':?0}")
	public List<Person> withQueryFindByAge(Integer age);

}
