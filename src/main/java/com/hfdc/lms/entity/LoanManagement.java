 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : LoanManagement/fine management class.
  * ==========================
  * */
package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class LoanManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="loan_id")
	private long loanId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user; //(Foreign Key)
	
	@OneToOne
	@JoinColumn(name="book_id")
	@NotNull
	private Book book; //(Foreign Key)
	
	@Column(name="due_date")
	@NotNull
	private LocalDate dueDate;
	
	private Double fine;
	
	private String status;

}
