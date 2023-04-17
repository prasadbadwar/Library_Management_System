/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 06/04/2023
  * 
  * @Description : Implementation of IBookService methods.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.BookDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookRepository bookrepo;
	
	@Override
	public Book addBook(BookDTO bookDTO)throws BookNotFound {
		if(bookrepo.existsById(bookDTO.getBookId())) {
			throw new BookNotFound("Book Already Exist with given ID");
		}
		
		Book book=new Book();
		
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setDate(bookDTO.getDate());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailableQuantity(bookDTO.getAvailableQuantity());
		
		return bookrepo.save(book); 
	}

	@Override
	public Book updateBook(BookDTO bookDTO) throws BookNotFound{
		if(!bookrepo.existsById(bookDTO.getBookId())) {
			throw new BookNotFound("Oops...Sorry,No such book found");
		}
		Book book=new Book();
		
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setDate(bookDTO.getDate());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailableQuantity(bookDTO.getAvailableQuantity());
		
		return bookrepo.save(book); 
	}

	@Override
	public void deleteBook(long bookId) throws BookNotFound {
		
		if(!bookrepo.existsById(bookId)) {
			throw new BookNotFound("Oops...Sorry,Book ID not found");
		}
		
		bookrepo.deleteById(bookId);
		
	}

	@Override
	public List<Book> findByTitle(String title) throws BookNotFound {
		
		if(bookrepo.findByTitle(title)==null) {
			throw new BookNotFound("Oops...Sorry,Book with given Title not found");
		}
		return bookrepo.findByTitle(title);
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFound {
		
		if(bookrepo.findByAuthor(author)==null) {
			throw new BookNotFound("Oops...Sorry,Book with given author not found");
		}
		return bookrepo.findByAuthor(author);
	}

	@Override
	public List<Book> findBySubject(String subject) throws BookNotFound {
		
		if(bookrepo.findBySubject(subject)==null) {
			throw new BookNotFound("Oops...Sorry,Book with given subject not found");
		}
		return bookrepo.findBySubject(subject);
	}

	@Override
	public List<Book> getBooks() {
		return bookrepo.findAll();
	}

	@Override
	public List<Book> findByTAS(String query) throws BookNotFound {
		
		if(bookrepo.searchTAS(query)==null) {
			throw new BookNotFound("Oops...Sorry,Book not found");
		}
		return bookrepo.searchTAS(query);
	}

	@Override
	public Book getBookID(long bookId) throws BookNotFound {
		if(!bookrepo.existsById(bookId)) {
			throw new BookNotFound("Oops...Sorry,Given Book Id not found");
		}
		
		return bookrepo.findById(bookId).orElse(null);
		
	}

}
