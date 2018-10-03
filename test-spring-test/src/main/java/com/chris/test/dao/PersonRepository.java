package com.chris.test.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.test.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
