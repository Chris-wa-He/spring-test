package com.chris.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chris.security.domain.Msg;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index(Model model) {
		Msg msg = new Msg("Test title", "Test context", "Extra info, only for admin");

		model.addAttribute("msg", msg);

		return "home";
	}

}
