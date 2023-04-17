 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 10/04/2023
  * 
  * @Description : Rest Controller class for Reservation of the books.
  * ==========================
  * */





package com.hfdc.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.dto.ReservationDTO;
import com.hfdc.lms.entity.Reservation;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.NotFoundExp;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.IReservationService;

@RestController
@RequestMapping("/lms/reserve")
public class ReservationRestController {

	@Autowired
	IReservationService service;
	
	@PostMapping("/reservebook")
	public ResponseEntity<String> reserveBook(@Valid @RequestBody ReservationDTO reserveDTO) throws UserNotFound,BookNotFound, NotFoundExp{
		service.reserveBook(reserveDTO);
		return new ResponseEntity<>("Book Reserved !!!",HttpStatus.OK);
	}
	
	@PutMapping("/updatereservation")
	public ResponseEntity<String> updateReservation(@Valid @RequestBody ReservationDTO reserveDTO) throws UserNotFound,BookNotFound,NotFoundExp {
		service.updateReservation(reserveDTO);
		return new ResponseEntity<>("Book Reserved Status Updated !!!",HttpStatus.OK);
	}
	
	@GetMapping("/getallreservation")
	public List<Reservation> allReservations(){
		return service.allReservations();
	}
	
	@DeleteMapping("/deletereservation/{reserveId}")
	public ResponseEntity<String> delete(@PathVariable long reserveId){
		service.deleteReservation(reserveId);
		return new ResponseEntity<>("Reservation Deleted Successfully !!!",HttpStatus.OK);
	}
}
