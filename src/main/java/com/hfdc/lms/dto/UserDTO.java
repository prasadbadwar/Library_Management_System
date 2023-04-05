package com.hfdc.lms.dto;

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
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String accountStatus;

}
