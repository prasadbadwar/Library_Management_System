package com.hfdc.lms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

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
	@NotNull
	private long userId; //(Foreign Key)
	@NotNull
	private long bookId; //(Foreign Key)
	@NotNull
	private LocalDate dueDate;
	
	private Double fine;
	
	private String status;

}
