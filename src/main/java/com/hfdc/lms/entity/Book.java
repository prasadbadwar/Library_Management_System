package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

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
