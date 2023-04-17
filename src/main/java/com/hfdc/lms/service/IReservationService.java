/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IReservationService is an interface which hold service related to reservation of books;
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.ReservationDTO;
import com.hfdc.lms.entity.Reservation;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;

public interface IReservationService {

	public Reservation reserveBook(ReservationDTO reserveDTO) throws UserNotFound,BookNotFound, NotFoundExp;
	
	public Reservation updateReservation(ReservationDTO reserveDTO) throws UserNotFound,BookNotFound,NotFoundExp ;
	
	public List<Reservation> allReservations();
	
	public void deleteReservation(long reservationId); 
}
