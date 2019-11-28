package com.mahendra.booklib.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahendra.booklib.exceptions.ApplicationException;
import com.mahendra.booklib.models.Book;
import com.mahendra.booklib.models.Member;
import com.mahendra.booklib.services.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired private MemberService service;
	
	@GetMapping("home.htm")
	public String home(Model map) {
		
		return "members/home";
	}
	

	// Resulting URL members/find-by-id.htm
	@PostMapping("find-by-id.htm")
	public String findMember(Model map, @RequestParam int id) {
		System.out.println("Find by Id");
		try {
			Member member = service.findById(id);
			List<Member> members = Arrays.asList(member);
			map.addAttribute("memberResults", members);
		} catch (ApplicationException ex) {
			map.addAttribute("msg", "No record found for member id " + id);
		}
		return "members/home";
	}
}
