package com.hfdc.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReportsDTO {
	
	private long Report_ID;
	private String User_Activity;
	private String Book_Status;
	private Double Fines_Collected;

}
