package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.BorrowingDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IBorrowingRepository;
import com.hfdc.lms.repository.ILoanManagementRepository;
import com.hfdc.lms.repository.IReportsRepository;
import com.hfdc.lms.repository.IReservationRepository;

@Service
public class BorrowingServiceImpl implements IBorrowingService {

	@Autowired
	IBorrowingRepository borrowrepo;
	
	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	BookServiceImpl bookservice;
	
	@Autowired
	ILoanManagementRepository loanrepo;
	
	@Autowired
	IReservationRepository resrepo;
	
	@Autowired
	IReservationService resservice;
	
	@Autowired
	IReportsRepository reportrepo;
	
	String message;
	@Override
	public Borrowing addBorrower(BorrowingDTO borrowDTO) throws UserNotFound, BookNotFound, NotFoundExp {
		if(borrowrepo.existsById(borrowDTO.getBorrowingId())) {
			throw new NotFoundExp("Borrower Id Already Exist!");
		}
		User user=userservice.getUserID(borrowDTO.getUserId());
		
		Book book=bookservice.getBookID(borrowDTO.getBookId());  
				
		Borrowing borrow=new Borrowing(); 
		
		if(loanrepo.existsById(borrowDTO.getUserId())==true) {
			throw new NotFoundExp("Sorry, you can't borrow Book.Please pay fine first...");
			
		}
		else if(!(book.getAvailableQuantity()>=1)) {
			throw new NotFoundExp("Oops...Sorry, Currently this Book is not available...");
		}
		
		else if(resrepo.existsById(borrowDTO.getBookId()) && book.getAvailableQuantity()<1) {
			throw new NotFoundExp("Oops...Sorry,Book is reserved for someone...");
		}
		else {
		borrow.setBorrowingId(borrowDTO.getBorrowingId());
		borrow.setBorrowDate(borrowDTO.getBorrowDate());
		borrow.setDueDate(borrowDTO.getDueDate());
		borrow.setReturnDate(borrowDTO.getReturnDate());
		borrow.setStatus("Borrowed");
		borrow.setUser(user);
		borrow.setBook(book);
		
		book.setAvailableQuantity(book.getAvailableQuantity()-1);
		user.setAccountStatus("Active");
	
		
		return borrowrepo.save(borrow);
		}
	}

	@Override
	public Borrowing updateBorrower(BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound, BookNotFound{
	
		if(!borrowrepo.existsById(borrowDTO.getBorrowingId())) {
			throw new NotFoundExp("Borrower Id Not found...");
		}
		User user=userservice.getUserID(borrowDTO.getUserId());
		Book book=bookservice.getBookID(borrowDTO.getBookId());
		
		
				
		Borrowing borrow=new Borrowing(); 
//		List<Book> book=borrow.getBook();
		
		borrow.setBorrowingId(borrowDTO.getBorrowingId());
		borrow.setBorrowDate(borrowDTO.getBorrowDate());
		borrow.setDueDate(borrowDTO.getDueDate());
		borrow.setReturnDate(borrowDTO.getReturnDate());
		borrow.setStatus("Returned");
		borrow.setUser(user);
		borrow.setBook(book);
		
		
		book.setAvailableQuantity(book.getAvailableQuantity()+1);
		
		//if book returned after due date then perform following operation
		
		LoanManagement loan=new LoanManagement();
		if(borrow.getReturnDate().isAfter(borrow.getDueDate())) {
			
			
			loan.setUser(user);
			loan.setBook(book);
			loan.setFine(500.0);
			loan.setStatus("Fined");
			loan.setDueDate(borrow.getReturnDate().plusDays(5));
			
			loanrepo.save(loan);
			message="You have return book after due date.Please pay fine"+loan.getFine()+" upto "+loan.getDueDate();
			}
		
		Reports report=new Reports();
		report.setFinesCollected(loan.getFine());
		report.setUser(user);
		report.setBook(book);
		reportrepo.save(report);
		
		
		return borrowrepo.save(borrow);
		
		
	}

	@Override
	public List<Borrowing> getBorrower() {
		
		return borrowrepo.findAll() ;
	}

	@Override
	public Borrowing getBorrowerId(long borrowingId) throws NotFoundExp {
		
		return borrowrepo.findById(borrowingId).orElse(null);
	}
	
	@Override
	public String display() {
		if(message!=null) {
			return message;
		}
		return "";   
		}
	
}
