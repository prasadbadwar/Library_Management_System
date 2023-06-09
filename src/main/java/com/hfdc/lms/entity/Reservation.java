 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : Reservation entity class.
  * ==========================
  * */
package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reservation_id")
	private long reservationId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;// (Foreign Key)
	
	@OneToOne
	@JoinColumn(name="book_id")
	@NotNull
	private Book book; //(Foreign Key)
	
	@Column(name="reservation_date")
	@NotNull
	private LocalDate reservationDate;

}
