package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hfdc.lms.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
