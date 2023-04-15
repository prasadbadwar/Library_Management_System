package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.exception.UserNotFound;

public interface IReportsService {

	public List<Reports> getReports(long id) throws UserNotFound;


	
}
