/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IReportsRepository is an interface which extends JpaRepository for connecting with reports table of library database.
  * ==========================
  * */
package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.entity.User;

@Repository
public interface IReportsRepository extends JpaRepository<Reports, Long> {

	
	public List<Reports> findByUser(User user);
	
	public List<Reports> findByBook(Book book);
}
