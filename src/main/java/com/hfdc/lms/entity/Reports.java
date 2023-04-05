package com.hfdc.lms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Reports {
	
	@Id
	@Column(name="report_id")
	private long reportId;
	
	@Column(name="user_activity")
	private String userActivity;
	
	@Column(name="book_status")
	private String bookStatus;
	
	@Column(name="fines_collected")
	private Double finesCollected;

}
