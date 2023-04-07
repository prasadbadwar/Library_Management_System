package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Borrowing;

@Repository
public interface IBorrowingRepository extends JpaRepository<Borrowing, Long> {

}