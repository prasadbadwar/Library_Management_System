/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IBookService is an interface which hold all services related to book management. Book controller can access book services through this interface class.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.BookDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;

public interface IBookService {
	
	public Book addBook(BookDTO bookDTO) throws BookNotFound;
	
	public Book updateBook(BookDTO bookDTO) throws BookNotFound;
	
	public void deleteBook(long bookId) throws BookNotFound;
	
	public List<Book> getBooks();
	
	public Book getBookID(long bookId) throws BookNotFound;
	
	public List<Book> findByTitle(String title) throws BookNotFound;
	
	public List<Book> findByAuthor(String author) throws BookNotFound;
	
	public List<Book> findBySubject(String subject) throws BookNotFound;
	
	public List<Book> findByTAS(String query) throws BookNotFound;
}
