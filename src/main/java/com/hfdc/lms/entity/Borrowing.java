package com.hfdc.lms.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Borrowing {

	@Id
	@Column(name="borrowing_id")
	private long borrowingId;
	
	@Column(name="user_id")
	private long userId;// (Foreign Key)
	
	@Column(name="book_id")
	private long bookId;// (Foreign Key)
	
	@Column(name="borrow_date")
	private LocalDate borrowDate;
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	private String status; // (Borrowed/Returned)
}
