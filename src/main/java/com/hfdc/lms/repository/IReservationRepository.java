package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

}
