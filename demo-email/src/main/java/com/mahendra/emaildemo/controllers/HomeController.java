package com.mahendra.emaildemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 
 * @author mahendra shinde (MahendraShinde@synergetics-india.com)
 *
 */

@Controller
@RequestMapping("/home.htm")
public class HomeController {

	@GetMapping
	public String showPage() {
		return "home";
	}
}
