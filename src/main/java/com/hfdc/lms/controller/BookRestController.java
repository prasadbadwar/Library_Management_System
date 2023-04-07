package com.hfdc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.dto.BookDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.service.IBookService;

@RestController
@RequestMapping("/lms/book")
public class BookRestController {

	@Autowired
	IBookService service;
	
	@PostMapping("/addbook")
	public Book addBook(@RequestBody BookDTO bookDTO) {
		return service.addBook(bookDTO); 	
	}
	
	@PutMapping("/updatebook")
	public Book updateBook(@RequestBody BookDTO bookDTO) {
		return service.updateBook(bookDTO);
	}
	
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable long bookId) throws BookNotFound{
		service.deleteBook(bookId);
		return new ResponseEntity<String>("Book Deleted Successfully!!!",HttpStatus.OK);
	}
	
	@GetMapping("/findtitle/{title}")
	public ResponseEntity<List<Book>> findByTitle(@PathVariable String title) throws BookNotFound{
		List list=service.findByTitle(title);
		if(list.isEmpty()) {
			throw new BookNotFound();
		}
		return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/findauthor/{author}")
	public List<Book> findByAuthor(@PathVariable String author) throws BookNotFound{
		List list=service.findByAuthor(author);
		if(list.isEmpty()) {
			throw new BookNotFound();
		}
		return list;
		
	}
	
	@GetMapping("/findsubject/{subject}")
	public List<Book> findBySubject(@PathVariable String subject) throws BookNotFound{
		List list= service.findBySubject(subject);
		if(list.isEmpty()) {
			throw new BookNotFound();
		}
		return list;
	}
	
	@GetMapping("/getbooks")
	public List<Book> getBooks(){
		return service.getBooks();
	}
}
