/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IReportsService is an interface which hold service related to user status,book status and fine collections.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

public interface IReportsService {

	public List<Reports> getUserReports(long id) throws UserNotFound, NotFoundExp;

	public List<Reports> getBookReports(long id) throws BookNotFound, NotFoundExp;

	
}
