package com.chris.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.service.HelloService;

@Service
public class SayHelloService {

	@Autowired
	private HelloService hs;

	public String SayHello(String word) {
		return hs.HelloWorld(word);

	}

}
