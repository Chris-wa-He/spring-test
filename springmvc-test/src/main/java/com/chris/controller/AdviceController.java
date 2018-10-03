package com.chris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.domain.DemoObj;

@Controller
public class AdviceController {

	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {

		System.out.println("DemoObj \nid:" + obj.getId() + "\nName:" + obj.getName());
		throw new IllegalArgumentException("Argument Exception. From @ModelAttribute:" + msg);

	}
}
