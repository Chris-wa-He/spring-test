package com.chris.service.impl;

import com.chris.service.HelloService;

public class SayHelloService2 {

	private HelloService hs;

	public void setHs(HelloService hs) {
		this.hs = hs;
	}

	public String SayHello(String word) {
		return hs.HelloWorld(word);

	}

}
