package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.BookDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;

public interface IBookService {
	
	public Book addBook(BookDTO bookDTO);
	
	public Book updateBook(BookDTO bookDTO);
	
	public void deleteBook(long bookId) throws BookNotFound;
	
	public List<Book> getBooks();
	public List<Book> findByTitle(String title) throws BookNotFound;
	
	public List<Book> findByAuthor(String author) throws BookNotFound;
	
	public List<Book> findBySubject(String subject) throws BookNotFound;
}
