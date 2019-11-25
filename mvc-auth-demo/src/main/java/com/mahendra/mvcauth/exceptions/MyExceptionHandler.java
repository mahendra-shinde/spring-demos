package com.mahendra.mvcauth.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleError(Model map,RuntimeException ex) {
		System.out.println("Caught an exception!");
		map.addAttribute("exception",ex);
		return "error";
	}
}
