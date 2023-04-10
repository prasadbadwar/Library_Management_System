package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User userId;// (Foreign Key)
	
	@OneToOne
	@JoinColumn(name="book_id")
	private Book bookId; //(Foreign Key)
	
	@Column(name="reservation_date")
	private LocalDate reservationDate;

}
