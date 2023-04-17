/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IBorrowingRepository is an interface which extends JpaRepository for connecting with borrowing table of library database.
  * ==========================
  * */
package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.Borrowing;
import com.hfdc.lms.entity.User;

@Repository
public interface IBorrowingRepository extends JpaRepository<Borrowing, Long> {

	public List<Borrowing> findByUser(User user);
}
