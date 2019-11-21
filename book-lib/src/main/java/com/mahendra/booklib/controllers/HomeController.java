package com.mahendra.booklib.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author mahendra shinde (MahendraShinde@synergetics-india.com)
 * Home page controller 
 *
 */

@Controller
@RequestMapping("/home.htm")
public class HomeController {
	
	@GetMapping
	public String home() {
		return "home";
	}
}
