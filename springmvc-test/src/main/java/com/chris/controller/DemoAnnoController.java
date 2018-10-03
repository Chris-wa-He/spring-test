package com.chris.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chris.domain.DemoObj;

@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

	@RequestMapping(produces = "text/plain; charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access.";

	}

	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String demoPathVar(@PathVariable String str, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access. \nStr:" + str;

	}

	@RequestMapping(value = "/requstParam", produces = "text/plain; charset=UTF-8")
	public @ResponseBody String passRequestParam(Long id, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access. \nId:" + id;

	}

	@RequestMapping(value = "/obj", produces = "text/plain; charset=UTF-8")
	@ResponseBody
	public String passObj(DemoObj demoObj, HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access. \n Obj id:" + demoObj.getId() + " obj name:"
				+ demoObj.getName();

	}

	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain; charset=UTF-8")
	public @ResponseBody String doubleName(HttpServletRequest request) {
		return "url: " + request.getRequestURL() + " can access. ";

	}
}
