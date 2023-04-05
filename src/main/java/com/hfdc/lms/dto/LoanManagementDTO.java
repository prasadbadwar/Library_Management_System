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
	
	private long loanId;
	private long userId; //(Foreign Key)
	private long bookId; //(Foreign Key)
	private LocalDate dueDate;
	private Double fine;

}
