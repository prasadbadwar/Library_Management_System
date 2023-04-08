package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.BorrowingDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IBorrowingRepository;

@Service
public class BorrowingServiceImpl implements IBorrowingService {

	@Autowired
	IBorrowingRepository borrowrepo;
	
	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	BookServiceImpl bookservice;
	
	@Override
	public Borrowing addBorrower(BorrowingDTO borrowDTO) throws UserNotFound, BookNotFound, NotFoundExp {
		if(borrowrepo.existsById(borrowDTO.getBorrowingId())) {
			throw new NotFoundExp("Borrower Id Already Exist!");
		}
		User user=userservice.getUserID(borrowDTO.getUserId());
		
		Book book=bookservice.getBookID(borrowDTO.getBookId());
				
		Borrowing borrow=new Borrowing(); 
		
		borrow.setBorrowingId(borrowDTO.getBorrowingId());
		borrow.setBorrowDate(borrowDTO.getBorrowDate());
		borrow.setDueDate(borrowDTO.getDueDate());
		borrow.setReturnDate(borrowDTO.getReturnDate());
		borrow.setStatus("Borrowed");
		borrow.setUser(user);
		borrow.setBook(book);
		
		return borrowrepo.save(borrow);
	}

	@Override
	public Borrowing updateBorrower(BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound, BookNotFound{
	
		if(!borrowrepo.existsById(borrowDTO.getBorrowingId())) {
			throw new NotFoundExp("Borrower Id Not found...");
		}
		User user=userservice.getUserID(borrowDTO.getUserId());
		
		Book book=bookservice.getBookID(borrowDTO.getBookId());
				
		Borrowing borrow=new Borrowing(); 
		
		borrow.setBorrowingId(borrowDTO.getBorrowingId());
		borrow.setBorrowDate(borrowDTO.getBorrowDate());
		borrow.setDueDate(borrowDTO.getDueDate());
		borrow.setReturnDate(borrowDTO.getReturnDate());
		borrow.setStatus("Returned");
		borrow.setUser(user);
		borrow.setBook(book);
		
		return borrowrepo.save(borrow);
		
		
	}

	@Override
	public List<Borrowing> getBorrower() {
		
		return borrowrepo.findAll() ;
	}

	@Override
	public Borrowing getBorrowerId(long borrowingId) throws NotFoundExp {
		// TODO Auto-generated method stub
		return null;
	}

	
}
