package com.hfdc.lms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDTO {
	
	private long bookId;
	private String title;
	private String author;
	private String subject;
	private String isbn;
	private String publisher;
	private LocalDate date;
	private int quantity;
	private int availableQuantity;

}
