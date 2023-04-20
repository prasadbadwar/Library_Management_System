package com.hfdc.lms.servicetest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.service.IBookService;

class BookServiceImplTest {
	
	@Autowired
	IBookService service;
	@Test
	void testFindByTitle() throws BookNotFound {
//		fail("Not yet implemented");
		List<Book> li=service.findByTitle("Java");
		assertTrue(li.size()>=1);
	}
//
//	@Test
//	void testFindByAuthor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindBySubject() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetBooks() {
//		fail("Not yet implemented");
		
		List<Book> li=service.getBooks();
		assertNotNull(li);
		
		
	}

	@Test
	void testFindByTAS() throws BookNotFound {
//		fail("Not yet implemented");
		List<Book> li=service.findByTAS("Biology");
		assertTrue(li.size()>=1);
	}

}
