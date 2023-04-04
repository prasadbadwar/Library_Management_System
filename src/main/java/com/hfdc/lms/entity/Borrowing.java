package com.hfdc.lms.entity;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Borrowing {

	private long Borrowing_ID;
	private long User_ID;// (Foreign Key)
	private long Book_ID;// (Foreign Key)
	private LocalDate Borrow_Date;
	private LocalDate Due_Date;
	private Date Return_Date;
	private String Status; // (Borrowed/Returned)
}
