package com.chris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chris.service.DemoService;

@RestController
public class MyRestController {

	@Autowired
	private DemoService demoService;

	@RequestMapping(value = "/restController", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String testRest() {
		return demoService.saySomething();

	}
}
