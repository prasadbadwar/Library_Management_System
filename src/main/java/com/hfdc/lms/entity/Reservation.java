package com.hfdc.lms.entity;

import java.time.LocalDate;

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
public class Reservation {
	
	@Id
	@Column(name="reservation_id")
	private long reservationId;
	
	@Column(name="user_id")
	private long userId;// (Foreign Key)
	
	@Column(name="book_id")
	private long bookId; //(Foreign Key)
	
	@Column(name="reservation_date")
	private LocalDate reservationDate;

}
