/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : DTO class for Reports entity.
  * ==========================
  * */
package com.hfdc.lms.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ReportsDTO {
	
	private long reportId;
	@NotNull
	private long userId;
	@NotNull
	private long bookId;
	private Double finesCollected;

}
