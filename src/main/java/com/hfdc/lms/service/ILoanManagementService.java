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

import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

@Service
public interface ILoanManagementService {
	
	public List<LoanManagement> getLoanData();
	
	public int updateLoan(long loanid) throws NotFoundExp;
	
	public List<LoanManagement> findByUser(long userid)  throws UserNotFound;
	
}
