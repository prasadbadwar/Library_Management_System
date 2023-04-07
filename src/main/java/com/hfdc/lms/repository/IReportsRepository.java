package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Reports;

@Repository
public interface IReportsRepository extends JpaRepository<Reports, Long> {

}
