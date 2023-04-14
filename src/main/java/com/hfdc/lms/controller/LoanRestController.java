package com.hfdc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.ILoanManagementService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/lms/book")
public class LoanRestController {

	@Autowired
	ILoanManagementService service;
	
	@GetMapping("/getloandata")
	public List<LoanManagement> getLoanData() {
		return service.getLoanData();
	}
	
	
	@PutMapping("/payfine")
	public ResponseEntity<String> updateLoan(@RequestBody LoanManagementDTO loanDTO) throws UserNotFound, BookNotFound,NotFoundException{
		service.updateLoan(loanDTO);
		return new ResponseEntity<String>("User Paid Fine successfully!",HttpStatus.OK);
	}
}
