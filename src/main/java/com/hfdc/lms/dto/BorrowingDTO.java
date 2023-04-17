 /* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description :DTO class for Borrowing entity.
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
public class BorrowingDTO {

	private long borrowingId;
	@NotNull
	private long userId;// (Foreign Key)
	@NotNull
	private long bookId;// (Foreign Key)
	@NotNull
	private LocalDate borrowDate;
	@NotNull
	private LocalDate dueDate;

	private LocalDate returnDate;
	
	private String status; // (Borrowed/Returned)

}
