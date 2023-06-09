/* =========================
  * @Author : Er.Prasad B.Badwar.
  * 
  * @Date : 04/04/2023
  * 
  * @Description : IUserService is an interface which hold all services related to users. User controller can access user services through this interface class.
  * ==========================
  * */
package com.hfdc.lms.service;

import java.util.List;

import com.hfdc.lms.dto.UserDTO;
import com.hfdc.lms.entity.User;
import com.hfdc.lms.exception.UserNotFound;

public interface IUserService {

	public User addUser(UserDTO userDTO) throws UserNotFound;
	
	public User updateUser(UserDTO userDTO) throws UserNotFound;
	
	public User getUserID(long userId) throws UserNotFound;
	
	public List<User> getUser();
	
	public void deleteUser(long userId) throws UserNotFound;
	
}
