package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.UserDTO;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.UserNotFound;

public interface IUserService {

	public User addUser(UserDTO userDTO);
	
	public User updateUser(UserDTO userDTO);
	
	public List<User> getUser();
	
	public void deleteUser(long userId) throws UserNotFound;
	
}
