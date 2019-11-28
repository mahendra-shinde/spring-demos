package com.mahendra.booklib.exceptions;

import javax.persistence.PersistenceException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public String showError() {
		return "error";
	}

	@ExceptionHandler(PersistenceException.class)
	public String showConnectError(Model map) {
		map.addAttribute("msg", "Unable to connect with DB");
		return "error";
	}
}
