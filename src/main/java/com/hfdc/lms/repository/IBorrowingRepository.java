package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.entity.Reports;
import com.hfdc.lms.entity.User;

@Repository
public interface IBorrowingRepository extends JpaRepository<Borrowing, Long> {

	public List<Borrowing> findByUser(User user);
}
