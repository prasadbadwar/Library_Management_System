package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.BorrowingDTO;
import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

public interface IBorrowingService {

	public Borrowing addBorrower(BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound,BookNotFound;
	
	public Borrowing updateBorrower(BorrowingDTO borrowDTO) throws NotFoundExp, UserNotFound,BookNotFound;
	
	public List<Borrowing> getBorrower();
	
	public Borrowing getBorrowerId(long borrowingId) throws NotFoundExp;
	
	public String display();
	
	
}
