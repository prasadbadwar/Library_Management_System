package com.hfdc.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.UserNotFound;

@Service
public interface ILoanManagementService {
	
	public List<LoanManagement> getLoanData();
	
	public LoanManagement updateLoan(LoanManagementDTO loanDTO) throws UserNotFound,BookNotFound,NotFoundException;
	
}
