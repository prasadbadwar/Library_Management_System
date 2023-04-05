package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hfdc.lms.entity.Borrowing;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

}
