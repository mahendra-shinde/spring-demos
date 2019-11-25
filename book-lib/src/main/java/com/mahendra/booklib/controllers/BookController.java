package com.mahendra.booklib.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahendra.booklib.models.Book;
import com.mahendra.booklib.services.BookService;

@Controller
@RequestMapping("books")
public class BookController {

	@Autowired private BookService service;
	
	//The Books home page
	// Resulting URL: books/home.htm
	// And also:	  books/
	@GetMapping("/home.htm")
	public String booksHome(Model model) {
		System.out.println("Books Home");
		model.addAttribute("book",new Book());//Empty Book instance for CREATE BOOK FORM
		return "books/home";
	}
	
	// Resulting URL books/find-by-id.htm
	@PostMapping("find-by-id.htm")
	public String findBook(Model map, @RequestParam int id) {
		System.out.println("Find by Id");
		Book book = service.findById(id);
		List<Book> books = Arrays.asList(book);
		map.addAttribute("book",new Book());
		map.addAttribute("bookResults",books);
		return "books/home";
	}
	
	@PostMapping("add-book.htm")
	public String addBook(@ModelAttribute("book") Book book, BindingResult result, Model model) {
		int id = service.save(book);
		model.addAttribute("msg","Book created with id: "+id);
		return "books/home";
	}
	
}
