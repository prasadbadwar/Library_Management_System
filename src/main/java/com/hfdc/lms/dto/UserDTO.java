/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : DTO class for User entity.
  * ==========================
  * */
package com.hfdc.lms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDTO {

	private long userId;
	@NotNull
	private String firstName;
	@NotEmpty
	private String lastName;
	
	@Email(message = "Email should be valid")
	private String email;
	
	@NotEmpty
	private String password;
	
	private String accountStatus;

}
