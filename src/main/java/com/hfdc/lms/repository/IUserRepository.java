package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

}
