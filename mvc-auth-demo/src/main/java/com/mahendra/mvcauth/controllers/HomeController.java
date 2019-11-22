package com.mahendra.mvcauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("home.htm")
	public String home(Model model, @RequestParam(name="target",defaultValue="about.htm") String target) {
		model.addAttribute("target",target);
		return "home";
	}
}
