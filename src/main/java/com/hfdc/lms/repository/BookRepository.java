package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hfdc.lms.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
