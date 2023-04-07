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
	public Book addBook(BookDTO bookDTO) {
		Book book=new Book();
		
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setDate(bookDTO.getDate());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailableQuantity(book.getAvailableQuantity());
		
		return bookrepo.save(book); 
	}

	@Override
	public Book updateBook(BookDTO bookDTO) {
		Book book=new Book();
		
		book.setBookId(bookDTO.getBookId());
		book.setTitle(bookDTO.getTitle());
		book.setAuthor(bookDTO.getAuthor());
		book.setSubject(bookDTO.getSubject());
		book.setIsbn(bookDTO.getIsbn());
		book.setPublisher(bookDTO.getPublisher());
		book.setDate(bookDTO.getDate());
		book.setQuantity(bookDTO.getQuantity());
		book.setAvailableQuantity(book.getAvailableQuantity());
		
		return bookrepo.save(book); 
	}

	@Override
	public void deleteBook(long bookId) throws BookNotFound {
		
		if(!bookrepo.existsById(bookId)) {
			throw new BookNotFound();
		}
		
		bookrepo.deleteById(bookId);
		
	}

	@Override
	public List<Book> findByTitle(String title) throws BookNotFound {
		
		if(bookrepo.findByTitle(title)==null) {
			throw new BookNotFound();
		}
		return bookrepo.findByTitle(title);
	}

	@Override
	public List<Book> findByAuthor(String author) throws BookNotFound {
		
		if(bookrepo.findByAuthor(author)==null) {
			throw new BookNotFound();
		}
		return bookrepo.findByAuthor(author);
	}

	@Override
	public List<Book> findBySubject(String subject) throws BookNotFound {
		
		if(bookrepo.findBySubject(subject)==null) {
			throw new BookNotFound();
		}
		return bookrepo.findBySubject(subject);
	}

	@Override
	public List<Book> getBooks() {
		return bookrepo.findAll();
	}

}
