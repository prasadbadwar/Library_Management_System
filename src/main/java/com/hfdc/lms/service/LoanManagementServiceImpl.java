/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 08/04/2023
  * 
  * @Description : Implementation of ILoanManagementService methods.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
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
	public LoanManagement updateLoan(LoanManagementDTO loanDTO) throws UserNotFound, BookNotFound,NotFoundExp {
		Optional<LoanManagement> opt=loanrepo.findById(loanDTO.getLoanId());
		if(opt.isPresent()) {
			User user=userservice.getUserID(loanDTO.getUserId());
			
			Book book=bookservice.getBookID(loanDTO.getBookId());
			LoanManagement loan=new LoanManagement();
			loan.setLoanId(loanDTO.getLoanId());
			loan.setUser(user);
			loan.setBook(book);
			loan.setFine(500.0);
			loan.setDueDate(loanDTO.getDueDate());
			loan.setStatus("Paid");
			
			return loanrepo.save(loan);
			
		}
		else {
			throw new NotFoundExp("Loan Id is not Present");
		}
		
	}

}
