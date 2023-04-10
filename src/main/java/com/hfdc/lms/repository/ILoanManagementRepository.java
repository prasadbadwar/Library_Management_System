package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.LoanManagement;

@Repository
public interface ILoanManagementRepository extends JpaRepository<LoanManagement, Long> {

	
}
