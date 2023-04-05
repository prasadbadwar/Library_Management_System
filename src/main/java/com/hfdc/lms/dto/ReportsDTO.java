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
	
	private long reportId;
	private String userActivity;
	private String bookStatus;
	private Double finesCollected;

}
