package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.ReservationDTO;
import com.hfdc.lms.entity.Reservation;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

public interface IReservationService {

	public Reservation ReserveBook(ReservationDTO reserveDTO) throws UserNotFound,BookNotFound;
	
	public Reservation updateReservation(ReservationDTO reserveDTO) throws UserNotFound,BookNotFound,NotFoundExp ;
	
	public List<Reservation> AllReservations();
	
	public void deleteReservation(long reservationId); 
}
