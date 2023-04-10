package com.hfdc.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hfdc.lms.entity.LoanManagement;

@Service
public interface ILoanManagementService {
	
	public List<LoanManagement> getLoanData();
	
}
