package com.chris.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.domain.DemoObj;

@RestController
@RequestMapping("/rest")
public class DemoRestController {

	@RequestMapping(value = "/getjson", produces = "application/json; charset=UTF-8")
	public DemoObj getJson(DemoObj demoObj) {
		return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "json");

	}

	@RequestMapping(value = "/getxml", produces = "application/xml; charset=UTF-8")
	public DemoObj getXml(DemoObj demoObj) {
		return new DemoObj(demoObj.getId() + 1, demoObj.getName() + "xml");

	}
}
