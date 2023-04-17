 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : Reports entity class.
  * ==========================
  * */
package com.hfdc.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Reports {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="report_id")
	private long reportId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_id")
	private Book book;
	
	@Column(name="fines_collected")
	private double finesCollected;
	
//	@OneToOne(mappedBy = "user",fetch =FetchType.LAZY)
//	private List<Borrowing> borrow;
	
//	@OneToOne(mappedBy = "user",fetch =FetchType.EAGER,)
//	private LoanManagement finesCollected;
	
	 

}
