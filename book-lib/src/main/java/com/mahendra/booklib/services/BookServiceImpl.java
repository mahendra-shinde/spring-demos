package com.mahendra.booklib.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.booklib.dao.BookDAO;
import com.mahendra.booklib.exceptions.ApplicationException;
import com.mahendra.booklib.models.Book;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO dao;
	

	@Override
	public Book findById(Integer id) {
		Book temp = dao.findById(id);
		if(temp==null)
			throw new ApplicationException("Book not found!");
		return temp;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> temp = dao.findByAuthor(author);
		return temp;
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> temp = dao.findByCategory(category);
		return temp;
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> temp = dao.findByCategory(title);
		return temp;
	}

	@Override
	public List<Book> findAvailableByTitle(String title) {
		List<Book> temp = dao.findAvailableByCategory(title);
		return temp;
	}

	@Override
	public List<Book> findAvailableByAuthor(String author) {
		List<Book> temp = dao.findAvailableByAuthor(author);
		return temp;
	}

	@Override
	public List<Book> findAvailableByCategory(String category) {
		List<Book> temp = dao.findAvailableByCategory(category);
		return temp;
	}

	@Transactional
	@Override
	public int save(Book book) {
		int id = dao.save(book);
		return id;
	}

}
