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
public class LoanManagementDTO {
	
	private long Loan_ID;
	private long User_ID; //(Foreign Key)
	private long Book_ID; //(Foreign Key)
	private LocalDate Due_Date;
	private Double Fine;

}
