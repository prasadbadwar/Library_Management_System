package com.hfdc.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name="user_id")
	private long userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Email
	private String email;
	
	private String password;
	
	
	@Column(name="account_status")
	private String accountStatus;
	
//	@OneToMany(mappedBy ="user",cascade = CascadeType.ALL)
//	private Borrowing borrow;
	
	
	
	
}
