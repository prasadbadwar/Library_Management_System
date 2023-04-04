package com.hfdc.lms.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Reservation {
	
	private long Reservation_ID;
	private long User_ID;// (Foreign Key)
	private long Book_ID; //(Foreign Key)
	private LocalDate Reservation_Date;

}
