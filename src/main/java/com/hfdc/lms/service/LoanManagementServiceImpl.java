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

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.entity.User;
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
	@Transactional
	public int updateLoan(long loanid) throws NotFoundExp {
		if(!loanrepo.existsById(loanid)) {
			throw new NotFoundException("Loan ID Not Found...");
		}
		return loanrepo.updateLoan(loanid);
	}

	@Override
	public List<LoanManagement> findByUser(long userid) throws UserNotFound {
		User user=userservice.getUserID(userid);
		return loanrepo.findByUser(user);
	}

	 
	
}
