package com.hfdc.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.ILoanManagementRepository;
import com.hfdc.lms.repository.IReportsRepository;
@Service
public class ReportsServiceImpl implements IReportsService {

	@Autowired
	IReportsRepository reprepo;
	
	@Autowired 
	ILoanManagementRepository loanservice;

	@Autowired
	IUserService userService;
	@Override
	public Reports getReports(long id) throws UserNotFound{
//		User user=userService.getUserID(id);
//		Borrowing borrow=new Borrowing();
//		borrow.getUser().getUserId();
//		borrow.getUser().getUserId();
//		borrow.getBook();
//		borrow.getStatus();
//		
//		List<Borrowing> list=new ArrayList<Borrowing>();
//		list.add(borrow);
//
//		System.out.println(list);
		
		
//		
//		LoanManagement loan=loanservice.findByUserId(id);
//		
//		Reports reports=new Reports();
//		reports.setUser(borrow.getUser());
//		reports.setBook(borrow.getBook());
//		reports.setFinesCollected(loan.getFine());
//		
//		reprepo.save(reports);
		
		return reprepo.findById(id).get() ;
		
		
	}
	
	
	
	
}
