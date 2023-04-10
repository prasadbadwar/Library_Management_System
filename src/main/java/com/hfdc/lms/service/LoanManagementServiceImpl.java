package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.repository.ILoanManagementRepository;

@Service
public class LoanManagementServiceImpl implements ILoanManagementService {

	@Autowired
	ILoanManagementRepository loanrepo;
	
	@Override
	public List<LoanManagement> getLoanData() {
		
		return loanrepo.findAll();
	}

}
