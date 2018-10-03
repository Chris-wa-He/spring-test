package com.chris.cache.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chris.cache.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
