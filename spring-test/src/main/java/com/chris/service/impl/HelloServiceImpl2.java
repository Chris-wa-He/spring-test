package com.chris.service.impl;

import com.chris.service.HelloService;

public class HelloServiceImpl2 implements HelloService {

	public String HelloWorld(String word) {

		StringBuffer strbuf = new StringBuffer();

		strbuf.append("Hello ");
		strbuf.append(word);
		strbuf.append(" 2 !");

		return strbuf.toString();

	}

}
