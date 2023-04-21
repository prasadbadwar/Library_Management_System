package com.hfdc.lms.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.service.IBookService;

@SpringBootTest
class BookServiceImplTest {
	
	@Autowired
	IBookService service;
	@Test
	void testFindByTitle() throws BookNotFound {
		List<Book> li=service.findByTitle("Java");
		assertTrue(li.size()>=1);
	}

	@Test
	void testFindByAuthor() throws BookNotFound {

		List<Book> li=service.findByTitle("Javeed Sir");
		assertTrue(li.size()>=1);
	}
	

	@Test
	void testGetBooks() {

		
		List<Book> li=service.getBooks();
		assertNotNull(li);
		
		
	}

	@Test
	void testFindByTAS() throws BookNotFound {
		List<Book> li=service.findByTAS("Biology");
		assertTrue(li.size()>=1);
	}

}
