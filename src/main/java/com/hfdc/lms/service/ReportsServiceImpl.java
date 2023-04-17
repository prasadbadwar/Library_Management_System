/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 10/04/2023
  * 
  * @Description : Implementation of IReportsService methods.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IReportsRepository;
@Service
public class ReportsServiceImpl implements IReportsService {

	@Autowired
	IReportsRepository reprepo;
	
	@Autowired 
	IBorrowingService borrowservice;

	@Autowired
	IUserService userService;
	@Autowired
	IBookService bookService;
	@Override
	public List<Reports> getUserReports(long id) throws UserNotFound, NotFoundExp{
		User user=userService.getUserID(id);		

		return reprepo.findByUser(user);	
	}
	
	@Override
	public List<Reports> getBookReports(long id) throws BookNotFound, NotFoundExp {
		Book book=bookService.getBookID(id);		

		return reprepo.findByBook(book);
	}
	
	
	
	
}
