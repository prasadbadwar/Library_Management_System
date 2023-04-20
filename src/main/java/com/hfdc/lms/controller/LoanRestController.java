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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.ILoanManagementService;

@RestController
@RequestMapping("/lms/book")
public class LoanRestController {

	@Autowired
	ILoanManagementService service;
	
	@GetMapping("/getloandata")
	public List<LoanManagement> getLoanData() {
		return service.getLoanData();
	}
	
	
	@PutMapping("/payfine/{loanid}")
	public ResponseEntity<String> updateLoan(@Valid @PathVariable long loanid) throws NotFoundExp{
		service.updateLoan(loanid);
		return new ResponseEntity<>("User Paid Fine successfully!",HttpStatus.OK);
	}
	
	@GetMapping("/finebyuserid/{userid}")
	public List<LoanManagement> findByUser(@PathVariable long userid)  throws UserNotFound{
		return service.findByUser(userid);
	}
}

