package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class LoanManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="loan_id")
	private long loanId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user; //(Foreign Key)
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book book; //(Foreign Key)
	
	@Column(name="due_date")
	private LocalDate dueDate;
	
	private Double fine;

}
