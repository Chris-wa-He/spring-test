package com.chris.jpa.repository.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.asm.Type;
import org.springframework.cglib.core.CodeEmitter;
import org.springframework.cglib.core.Customizer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.chris.jpa.repository.CustomRepository;

import static com.chris.jpa.specs.CustomerSpecs.*;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements CustomRepository<T, ID>, Customizer {

	private EntityManager entityManager;

	public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		this.entityManager = em;
	}

	@Override
	public Page<T> findByAuto(T example, Pageable pageable) {
		return findAll(byAuto(entityManager, example), pageable);
	}

	@Override
	public void customize(CodeEmitter arg0, Type arg1) {
		
	}

}
