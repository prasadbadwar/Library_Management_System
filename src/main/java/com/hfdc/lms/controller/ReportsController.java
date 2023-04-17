 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 10/04/2023
  * 
  * @Description : Reports Controller class for getting reports according to user.
  * ==========================
  * */
package com.hfdc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.IReportsService;

@RestController
@RequestMapping("/lms/book")
public class ReportsController {

	@Autowired
	IReportsService service;
	
	@GetMapping("getUserReport/{id}")
	public List<Reports> getUserReports(@PathVariable long id) throws UserNotFound, NotFoundExp{
		return service.getUserReports(id);
	}
	@GetMapping("getBookReport/{id}")
	public List<Reports> getBookReports(@PathVariable long id) throws BookNotFound, NotFoundExp{
		return service.getBookReports(id);
	}
}
