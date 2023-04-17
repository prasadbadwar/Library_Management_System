 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 08/04/2023
  * 
  * @Description : This class is for getting the information of fined students and pay fine.
  * ==========================
  * */
package com.hfdc.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
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
	public ResponseEntity<String> updateLoan(@Valid @RequestBody LoanManagementDTO loanDTO) throws UserNotFound, BookNotFound,NotFoundExp{
		service.updateLoan(loanDTO);
		return new ResponseEntity<>("User Paid Fine successfully!",HttpStatus.OK);
	}
}
