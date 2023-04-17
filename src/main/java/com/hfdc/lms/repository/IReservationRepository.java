/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IReservationRepository is an interface which extends JpaRepository for connecting with reservation table of library database.
  * ==========================
  * */
package com.hfdc.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Reservation;

@Repository
public interface IReservationRepository extends JpaRepository<Reservation, Long> {

	
}
