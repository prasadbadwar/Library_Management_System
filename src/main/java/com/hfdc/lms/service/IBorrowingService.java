/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IBorrowingService is an interface which hold all services related to borrowers management. Borrower controller can access borrower's services through this interface class.
  * ==========================
  * */
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
	
	public List<Borrowing> getBorrowerId(long borrowingId) throws NotFoundExp,UserNotFound;
	
	public String display();
	
	
}
