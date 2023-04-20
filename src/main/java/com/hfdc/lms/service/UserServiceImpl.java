/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 06/04/2023
  * 
  * @Description : Implementation of IUserService methods.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hfdc.lms.dto.UserDTO;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.UserNotFound;
import com.hfdc.lms.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userrepo;
	@Override
	public User addUser(UserDTO userDTO) throws UserNotFound {
		if(userrepo.existsByEmail(userDTO.getEmail())) {
			throw new UserNotFound("User with this Email-id alredy registered!");
			
		}
		User user=new User();
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserId());
		user.setAccountStatus("Inactive");
		
		return userrepo.save(user);
	}

	@Override
	public User updateUser(UserDTO userDTO) throws UserNotFound {
		if(!userrepo.existsById(userDTO.getUserId())) {
			throw new UserNotFound("Oops...Sorry,User not found");
		}
		else if(!userrepo.existsByEmail(userDTO.getEmail())) {
			throw new UserNotFound("User with this Email-id not found!");
			
		}
		
		User user=userrepo.findById(userDTO.getUserId()).orElse(null);
		if(user==null) {
			throw new NullPointerException("Null user");
		}
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setUserId(userDTO.getUserId());
		user.setAccountStatus(user.getAccountStatus());
		

		
		return userrepo.save(user);
	}

	@Override
	public List<User> getUser() {
		
		return userrepo.findAll();
	}

	@Override
	public void deleteUser(long userId) throws UserNotFound {

		if(!userrepo.existsById(userId)) {
			throw new UserNotFound("Oops...Sorry,User not found with given Id");
		}
		
		userrepo.deleteById(userId);

	}

	@Override
	public User getUserID(long userId) throws UserNotFound {
		if(!userrepo.existsById(userId)) {
			throw new UserNotFound("Oops...Sorry,User Id not found");
		}
		return userrepo.findById(userId).orElse(null);
	}

}
