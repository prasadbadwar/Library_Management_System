/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : ILoanManagementService is an interface which hold services related to borrowers fine.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.LoanManagementDTO;
import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

@Service
public interface ILoanManagementService {
	
	public List<LoanManagement> getLoanData();
	
	public LoanManagement updateLoan(LoanManagementDTO loanDTO) throws UserNotFound,BookNotFound,NotFoundExp;
	
}
