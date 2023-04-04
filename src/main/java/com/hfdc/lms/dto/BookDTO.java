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
	
	private long Book_ID;
	private String Title;
	private String Author;
	private String Subject;
	private String ISBN;
	private String Publisher;
	private LocalDate Date;
	private int Quantity;
	private int Available_Quantity;

}
