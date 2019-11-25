package com.mahendra.booklib.services;

import java.util.List;

import com.mahendra.booklib.models.Book;

public interface BookService {

	Book findById(Integer id);
	List<Book> findByAuthor(String author);
	List<Book> findByCategory(String category);
	List<Book> findByTitle(String title);

	List<Book> findAvailableByTitle(String title);
	List<Book> findAvailableByAuthor(String author);
	List<Book> findAvailableByCategory(String category);
	
	int save(Book book);
	void update(Book book);
	void delete(int id);
	
}
