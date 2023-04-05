package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hfdc.lms.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
