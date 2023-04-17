 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : DTO class for Book entity.
  * ==========================
  * */
package com.hfdc.lms.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookDTO {
	
	private long bookId;
	@NotNull
	private String title;
	@NotNull
	private String author;
	@NotNull
	private String subject;
	@NotNull
	private String isbn;
	@NotNull
	private String publisher;
	@NotNull
	private LocalDate date;
	@NotNull
	private int quantity;
	@NotNull
	private int availableQuantity;

}
