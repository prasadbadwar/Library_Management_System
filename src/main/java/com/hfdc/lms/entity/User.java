package com.hfdc.lms.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {

	private long User_Id;
	private String First_Name;
	private String Last_Name;
	private String Email;
	private String Password;
	private String Account_Status;

}
