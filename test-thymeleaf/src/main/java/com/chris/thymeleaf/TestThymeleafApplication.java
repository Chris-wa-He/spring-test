package com.chris.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.thymeleaf.obj.Person;

@Controller
@ComponentScan("com.chris")
@SpringBootApplication
public class TestThymeleafApplication {

	@RequestMapping("/")
	public String index(Model model) {

		Person single = new Person("aa", 11);

		List<Person> list = new ArrayList<Person>();
		list.add(new Person("xx", 22));
		list.add(new Person("yy", 33));
		list.add(new Person("zz", 44));

		model.addAttribute("singlePerson", single);
		model.addAttribute("people", list);

		return "index";

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TestThymeleafApplication.class, args);
	}

}
