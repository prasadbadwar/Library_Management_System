 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 06/04/2023
  * 
  * @Description : Rest Controller class for Reservation of the books.
  * ==========================
  * */
package com.hfdc.lms.controller;

import java.util.List;

import javax.validation.Valid;

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
	public ResponseEntity<String> addBook(@Valid @RequestBody BookDTO bookDTO) throws BookNotFound {
		service.addBook(bookDTO); 
		return new ResponseEntity<>("Book Added Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/updatebook")
	public ResponseEntity<String> updateBook(@Valid @RequestBody BookDTO bookDTO) throws BookNotFound {
		 service.updateBook(bookDTO);
		 return new ResponseEntity<>("Book Updated Successfully!!",HttpStatus.OK);
	}
	
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable long bookId) throws BookNotFound{
		service.deleteBook(bookId);
		return new ResponseEntity<>("Book Deleted Successfully!!!",HttpStatus.OK);
	}
	
	@GetMapping("/findtitle/{title}")
	public ResponseEntity<List<Book>> findByTitle(@PathVariable String title) throws BookNotFound{
		List<Book> list=service.findByTitle(title);
		if(list.isEmpty()) {
			throw new BookNotFound("Oops...Sorry,Book not found");
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/findauthor/{author}")
	public List<Book> findByAuthor(@PathVariable String author) throws BookNotFound{
		List<Book> list=service.findByAuthor(author);
		if(list.isEmpty()) {
			throw new BookNotFound("Oops...Sorry,Book not found");
		}
		return list;
		
	}
	
	@GetMapping("/findsubject/{subject}")
	public List<Book> findBySubject(@PathVariable String subject) throws BookNotFound{
		List<Book> list= service.findBySubject(subject);
		if(list.isEmpty()) {
			throw new BookNotFound("Oops...Sorry,No Book not found with Subject "+subject);
		}
		return list;
	}
	
	@GetMapping("/getbooks")
	public List<Book> getBooks(){
		return service.getBooks();
	}
	
	@GetMapping("/getbyTAS/{query}")
	public List<Book> findByTAS(@PathVariable String query) throws BookNotFound{
		List<Book> list= service.findByTAS(query);
		if(list.isEmpty()) {
			throw new BookNotFound("Oops...Sorry,No Book not found with "+query);
		}
		return list;
	}
}
