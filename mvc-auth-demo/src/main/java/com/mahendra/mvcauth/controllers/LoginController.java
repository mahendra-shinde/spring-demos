package com.mahendra.mvcauth.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LoginController {
	
	@RequestMapping(value="login.htm", method=RequestMethod.POST)
	public String  login(Model model, HttpSession session, @RequestParam String uname, @RequestParam String pass, @RequestParam("destination") String target) {
		List<String> errors = new ArrayList<>();
		if(uname==null || uname.trim().length()<1) {
			errors.add("Missing username! ");
		}
		if(pass==null || pass.trim().length()<1) {
			errors.add("Missing password!");
		}
		if(errors.isEmpty()) {
			if(authenticate(uname, pass)) {
				session.setAttribute("loggedInUser", uname);
				return "redirect:/"+target;
			}
			else {
				errors.add("Login failed due to invalid Credentials!");
			}
		}
		model.addAttribute("errors",errors);
		//Forward request to HOME PAGE with ALL ERROR MESSAGES
		return "forward:/home.htm";
		
	}
	
	@GetMapping("logout.htm")
	public String logout(HttpSession session) {
		System.out.println("Killing current session!");
		session.removeAttribute("loggedInUser");
		session.invalidate();
		return "redirect:/home.htm";
	}
	
	
	private boolean authenticate(String user, String pass) {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("admin", "Pass@1234");
		credentials.put("user1","User@1234");
		credentials.put("user2","MyPass@321");
		String password = credentials.get(user);
		if(password !=null &&  password.equals(pass)) {
			return true;
		}
		return false;
	}
}
