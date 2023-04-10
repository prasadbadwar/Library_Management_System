package com.hfdc.lms.dto;

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
public class BorrowingDTO {

	private long borrowingId;
	private long userId;// (Foreign Key)
	private long bookId;// (Foreign Key)
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private String status; // (Borrowed/Returned)

}
