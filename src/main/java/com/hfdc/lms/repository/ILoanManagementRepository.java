/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : ILoanManagementRepository is an interface which extends JpaRepository for connecting with loan_management table of library database.
  * ==========================
  * */
package com.hfdc.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hfdc.lms.entity.LoanManagement;
import com.hfdc.lms.entity.User;

@Repository
public interface ILoanManagementRepository extends JpaRepository<LoanManagement, Long> {

	@Query("from LoanManagement l where l.status='Fined' and l.user=:user")
	public LoanManagement findFinedUser(@Param("user") User user);
	
	@Modifying
	@Query("update LoanManagement l set l.status='Paid' where l.loanId=:id ")
	public int updateLoan(@Param("id") long id);
	
	public List<LoanManagement> findByUser(User user);
}
