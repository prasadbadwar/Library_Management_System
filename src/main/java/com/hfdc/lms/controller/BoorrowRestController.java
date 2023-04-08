package com.hfdc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.dto.BorrowingDTO;
import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.IBorrowingService;

@RestController
@RequestMapping("/lms/borrow")
public class BoorrowRestController {

	@Autowired
	IBorrowingService service;
	
	@PostMapping("/boorrowbook")
	public ResponseEntity<String> addBorrower(@RequestBody BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound,BookNotFound{
		service.addBorrower(borrowDTO);
		return new ResponseEntity<String>("User Borrowed Book Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/returnbook")
	public ResponseEntity<String> updateBorrower(@RequestBody BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound,BookNotFound{
		service.updateBorrower(borrowDTO);
		
		return new ResponseEntity<String>("User Returned Book Successfully!!",HttpStatus.OK);
		
	}
	
	@GetMapping("/getBorrowers")
	public List<Borrowing> getData() {
		return service.getBorrower();
	}
}
