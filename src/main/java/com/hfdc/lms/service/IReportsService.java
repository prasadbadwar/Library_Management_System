package com.hfdc.lms.service;

import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.exception.UserNotFound;

public interface IReportsService {

	public Reports getReports(long id) throws UserNotFound;


	
}
