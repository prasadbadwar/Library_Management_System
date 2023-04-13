package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.hfdc.lms.dto.ReservationDTO;
import com.hfdc.lms.entity.Book;
import com.hfdc.lms.entity.Reservation;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IReservationRepository;

@Service
public class ReservationServiceImpl implements IReservationService{

	@Autowired
	IReservationRepository reserverepo;
	
	@Autowired
	UserServiceImpl userservice;
	
	@Autowired
	BookServiceImpl bookservice;
	
	

	
	@Override
	public Reservation ReserveBook(ReservationDTO reserveDTO) throws UserNotFound, BookNotFound,NotFoundExp {
		
		User user=userservice.getUserID(reserveDTO.getUserId());
		
		Book book=bookservice.getBookID(reserveDTO.getBookId());
		
		if(reserverepo.existsById(reserveDTO.getBookId()) || book.getAvailableQuantity()<1) {
			throw new NotFoundExp("Oops...Sorry,Book is reserved for someone...");
		}
		
		Reservation reserve=new Reservation();
		reserve.setReservationId(reserveDTO.getReservationId());
		reserve.setUser(user);
		reserve.setBook(book);
		reserve.setReservationDate(reserveDTO.getReservationDate());
		
		book.setAvailableQuantity(book.getAvailableQuantity()-1);
		
		return reserverepo.save(reserve);
	}

	@Override
	public Reservation updateReservation(ReservationDTO reserveDTO) throws UserNotFound,BookNotFound,NotFoundExp {
		if(!reserverepo.existsById(reserveDTO.getReservationId())) {
			throw new NotFoundExp("Reservation Id Not found...");
		}
		User user=userservice.getUserID(reserveDTO.getUserId());
		
		Book book=bookservice.getBookID(reserveDTO.getBookId());
		
		Reservation reserve=new Reservation();
		reserve.setReservationId(reserveDTO.getReservationId());
		reserve.setUser(user);
		reserve.setBook(book);
		reserve.setReservationDate(reserveDTO.getReservationDate());
		
		
		
		return reserverepo.save(reserve);	
		
	}

	@Override
	public List<Reservation> AllReservations() {
		
		return reserverepo.findAll();
	}

	@Override
	public void deleteReservation(long reservationId) {
		if(!reserverepo.existsById(reservationId)) {
			throw new NotFoundException("Reservation ID Not Found...");
		}
		reserverepo.deleteById(reservationId);
		
		
		
		
	}

}
