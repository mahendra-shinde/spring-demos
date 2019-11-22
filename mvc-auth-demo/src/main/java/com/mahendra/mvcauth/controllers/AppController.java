package com.mahendra.mvcauth.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("about.htm")
	public String about(Model model, HttpSession session) {
		
		String view = authorize(session,model,"about");
		///ACTUAL BUSINESS LOGIC HERE....
		/// eg. Fetch some data for about page and push it in MODEL object
		return view;
		
	}
	
	@GetMapping("contact.htm")
	public String contact(Model model, HttpSession session) {
		
		String view = authorize(session,model,"contact");
		///ACTUAL BUSINESS LOGIC HERE....
		/// eg. Fetch contact details and push it in MODEL object
		return view;
		
	}
	
	
	
	private String authorize(HttpSession session, Model model, String reqUrl) {
		Object user = session.getAttribute("loggedInUser");
		if(user!=null) {
			System.out.println("User has logged in as "+user);
			return reqUrl;
		}
		System.out.println("Login required!");
		List<String> errors = new ArrayList<>();
		errors.add("please login to continue...");
		model.addAttribute("errors",errors);
		model.addAttribute("target",reqUrl+".htm");
		return "redirect:/home.htm";
	}
}
