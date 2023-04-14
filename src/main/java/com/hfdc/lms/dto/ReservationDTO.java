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
public class ReservationDTO {
	
	private long reservationId;
	@NotNull
	private long userId;// (Foreign Key)
	@NotNull
	private long bookId; //(Foreign Key)
	@NotNull
	private LocalDate reservationDate;

}
