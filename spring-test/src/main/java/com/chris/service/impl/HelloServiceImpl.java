package com.chris.service.impl;

import org.springframework.stereotype.Service;

import com.chris.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

	public String HelloWorld(String word) {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("Hello ");
		strbuf.append(word);
		strbuf.append(" !");

		return strbuf.toString();

	}

}
