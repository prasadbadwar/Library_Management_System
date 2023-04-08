package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Book {
	
	@Id
	@Column(name="book_id")
	private long bookId;
	
	private String title;
	
	private String author;
	
	private String subject;
	
	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	private String isbn;
	
	private String publisher;
	
	private LocalDate date;

	private int quantity;
	
	@Column(name="available_quantity")
	private int availableQuantity;
	
	@OneToOne(mappedBy ="book",fetch = FetchType.LAZY )
	private Borrowing borrow;

}
