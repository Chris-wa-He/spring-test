package com.chris.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chris.jpa.domain.Person;
import com.chris.jpa.repository.CustomRepository;

public interface PersonRepository extends CustomRepository<Person, Long> {

	List<Person> findByName(String name);

	List<Person> findByAddress(String address);

	Person findByNameAndAddress(String name, String address);

	@Query("select p from Person p where p.name=:name and address=:address")
	Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

	List<Person> withNameAndAddressNamedQuery(String name, String Address);

}
