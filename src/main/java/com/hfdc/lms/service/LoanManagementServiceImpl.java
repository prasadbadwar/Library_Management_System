package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.ILoanManagementRepository;

@Service
public class LoanManagementServiceImpl implements ILoanManagementService {

	@Autowired
	ILoanManagementRepository loanrepo;
	
	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	BookServiceImpl bookservice;
	
	@Override
	public List<LoanManagement> getLoanData() {
		
		return loanrepo.findAll();
	}

	@Override
	public LoanManagement updateLoan(LoanManagementDTO loanDTO) throws UserNotFound, BookNotFound,NotFoundException {
		
		if(!loanrepo.existsById(loanDTO.getLoanId())) {
			throw new NotFoundException("User Id is not Present");
		}
		User user=userservice.getUserID(loanDTO.getUserId());
		
		Book book=bookservice.getBookID(loanDTO.getBookId());
		LoanManagement loan=new LoanManagement();
		loan.setLoanId(loanDTO.getLoanId());
		loan.setUser(user);
		loan.setBook(book);
		loan.setFine(500.0);
		loan.setStatus("Paid");
		
		return loanrepo.save(loan);
	}

}
