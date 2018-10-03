package com.chris.testpropreties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.spring_boot_starter_hello.HelloService;
import com.chris.testpropreties.bean.AuthorSettings;

@RestController
@SpringBootApplication
public class TestPropertiesApplication {

	@Autowired
	private AuthorSettings settings;

	@Autowired
	private HelloService helloService;

	@RequestMapping(value = "/")
	public String index() {
		return "Author name:" + settings.getName() + "  and Author age:" + settings.getAge();

	}

	@RequestMapping(value = "/hello")
	public String sayHello() {
		return helloService.sayHello();
	}

	public static void main(String[] args) {
		SpringApplication.run(TestPropertiesApplication.class, args);
	}
}
