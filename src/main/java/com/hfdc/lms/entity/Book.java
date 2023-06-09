 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : Book entity class.
  * ==========================
  * */
package com.hfdc.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Book {
	
	@Id
	@Column(name="book_id")
	private long bookId;
	
	@NotNull
	private String title;
	
	@NotNull
	private String author;
	
	@NotNull
	private String subject;
	
	@Column(name = "isbn", length = 50, nullable = false, unique = true)
	@NotNull
	private String isbn;
	
	@NotNull
	private String publisher;
	
	@NotNull
	private LocalDate date;

	@NotNull
	private int quantity;
	
	@Column(name="available_quantity")
	@NotNull
	private int availableQuantity;	

}
