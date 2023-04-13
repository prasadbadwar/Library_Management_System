package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Reports;

@Repository
public interface IReportsRepository extends JpaRepository<Reports, Long> {

	@Query("select b.user_id,b.book_id,b.borrow_date,b.return_date,b.status,l.fine from Borrowing b,LoanManagement l where b.user_id=:user_id && b.book_id=:book:id")
	List<Reports> getUserReport(@Param("user_id") long user_id,@Param("book_id") long book_id);
}
