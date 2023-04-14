package com.hfdc.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.IReportsService;

@RestController
@RequestMapping("/lms/book")
public class ReportsController {

	@Autowired
	IReportsService service;
	
	@GetMapping("getUserReport/{id}")
	public Reports getReports(@PathVariable long id) throws UserNotFound{
		return service.getReports(id);
	}
}
