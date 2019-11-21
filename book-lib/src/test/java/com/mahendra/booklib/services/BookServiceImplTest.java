package com.mahendra.booklib.services;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mahendra.booklib.models.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/spring-core.xml")
public class BookServiceImplTest {

	@Autowired private BookService service;
	
	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() {
		Book book = new Book("Thinking in Java","Unknown","Java",'A');
		int id = service.save(book);
		assertNotEquals(0, id);
	}

}
