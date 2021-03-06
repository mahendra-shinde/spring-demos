package com.mahendra.booklib.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mahendra.booklib.models.Book;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/spring-core.xml")
public class BookDAOImplTest {

	@Autowired BookDAO dao;
	
	@Test
	public void testFindById() {
		Book b = dao.findById(10000);
		assertNotNull(b);
	}

	@Test
	public void testFindByAuthor() {
		List<Book> books = dao.findByAuthor("Yashwant");
		assertNotNull(books);
		if(books.isEmpty()) {
			fail("No records found!");
		}
	}

}
