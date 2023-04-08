package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
	
	public List<Book> findByTitle(String title);
	
	public List<Book> findByAuthor(String author);
	
	public List<Book> findBySubject(String Subject);
	
	
	@Query("from Book where title=:query OR author=:query OR subject=:query")
	public List<Book> searchTAS(@Param("query") String query);
}
