package com.hfdc.lms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hfdc.lms.dto.UserDTO;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.service.IUserService;

@RestController
@RequestMapping("/lms/user")
public class UserRestController {

	@Autowired
	IUserService service;
	
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO userDTO) throws UserNotFound {
		service.addUser(userDTO);
		return new ResponseEntity<String>("User Added Successfully!!",HttpStatus.OK);
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserDTO userDTO)throws UserNotFound {
		service.updateUser(userDTO);
		return new ResponseEntity<String>("User Updated Successfully!!",HttpStatus.OK);
	}
	
	@GetMapping("/getusers")
	public List<User> getUser(){
		return service.getUser();
		
	}
	
	@DeleteMapping("/deleteuser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable long userId) throws UserNotFound{
		service.deleteUser(userId);
		return new ResponseEntity<String>("User Deleted Successfully!!!",HttpStatus.OK);
	}
	
	@GetMapping("/getuserid/{userId}")
	public User getUser(@PathVariable long userId) throws UserNotFound{
		return service.getUserID(userId);
	}
}
