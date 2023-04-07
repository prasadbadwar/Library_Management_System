package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.UserDTO;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.BookNotFound;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userrepo;
	@Override
	public User addUser(UserDTO userDTO) {
		User user=new User();
		user.setAccountStatus(userDTO.getAccountStatus());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserId());
		
		return userrepo.save(user);
	}

	@Override
	public User updateUser(UserDTO userDTO) {
		User user=new User();
		user.setAccountStatus(userDTO.getAccountStatus());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserId());
		
		return userrepo.save(user);
	}

	@Override
	public List<User> getUser() {
		
		return userrepo.findAll();
	}

	@Override
	public void deleteUser(long userId) throws UserNotFound {

		if(!userrepo.existsById(userId)) {
			throw new UserNotFound();
		}
		
		userrepo.deleteById(userId);

	}

}
