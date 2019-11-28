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

import com.mahendra.booklib.exceptions.ApplicationException;
import com.mahendra.booklib.models.Book;
import com.mahendra.booklib.services.BookService;

/**
 * @author mahendra shinde (MahendraShinde@synergetics-india.com
 *
 */
@Controller
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService service;

	// The Books home page
	// Resulting URL: books/home.htm
	// And also: books/
	@GetMapping("/home.htm")
	public String booksHome(Model model) {
		System.out.println("Books Home");
		return "books/home";
	}

	// Resulting URL books/find-by-id.htm
	@PostMapping("find-by-id.htm")
	public String findBook(Model map, @RequestParam int id) {
		System.out.println("Find by Id");
		try {
			Book book = service.findById(id);
			List<Book> books = Arrays.asList(book);
			map.addAttribute("bookResults", books);
		} catch (ApplicationException ex) {
			map.addAttribute("msg", "No record found for book id " + id);
		}
		return "books/home";
	}

	// Resulting URL books/find-by-id.htm
	@PostMapping("find-by-title.htm")
	public String findBookByTitle(Model map, @RequestParam String title) {
		System.out.println("Find by title");
		try {
			List<Book> books = service.findByTitle(title);
			map.addAttribute("bookResults", books);
		} catch (ApplicationException ex) {
			map.addAttribute("msg", "No record found for book title " + title);
		}
		return "books/home";
	}

	@GetMapping("edit.htm")
	public String editBookView(Model map, @RequestParam int id) {
		try {
			Book book = service.findById(id);
			map.addAttribute("book", book);
			return "books/edit";
		} catch (ApplicationException ex) {
			map.addAttribute("msg", "No record found for book id " + id);
			return "books/home";
		}
	}

	@PostMapping("edit.htm")
	public String editBook(@ModelAttribute Book book, BindingResult result, Model map) {
		try {
			service.update(book);
			map.addAttribute("msg", "Record updated for book id " + book.getId());
			return "books/home";
		} catch (ApplicationException ex) {
			map.addAttribute("msg", ex.getMessage());
			return "books/home";
		}
	}

	@PostMapping("add-book.htm")
	public String addBook(@ModelAttribute("book") Book book, BindingResult result, Model model) {
		int id = service.save(book);
		model.addAttribute("msg", "Book created with id: " + id);
		return "books/home";
	}

	@GetMapping("add-book.htm")
	public String addBookView(Model model) {
		model.addAttribute("book", new Book());
		return "books/add";
	}

	@GetMapping("delete.htm")
	public String deleteBook(@RequestParam int id, Model map) {
		try {
			service.delete(id);
		} catch (Exception ex) {
			map.addAttribute("msg", ex.getMessage());
		}
		return "books/home";
	}

}
