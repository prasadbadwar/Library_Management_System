package com.hfdc.lms.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;			// (Foreign Key)
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book;			// (Foreign Key)
	
	@Column(name="borrow_date")
	private LocalDate borrowDate;
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	private String status; // (Borrowed/Returned)


}
