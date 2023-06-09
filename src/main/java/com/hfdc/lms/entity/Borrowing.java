 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : Borrowing entity class.
  * ==========================
  * */
package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Borrowing {

	@Id
	@Column(name="borrowing_id")
	private long borrowingId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	@NotNull//or can use maped by user_id
	private User user;			// (Foreign Key)
		
	@ManyToOne(targetEntity = Book.class,fetch = FetchType.EAGER)
	@JoinColumn(name="book_id")
	@NotNull
	private Book book;	
	
	@Column(name="borrow_date")
	@NotNull
	private LocalDate borrowDate;
	
	@Column(name="due_date")
	@NotNull
	private LocalDate dueDate;
	
	@Column(name="return_date")
	private LocalDate returnDate;
	
	
	private String status; // (Borrowed/Returned)


}
