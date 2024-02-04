package com.nagarro.serviceInterface;

import com.nagarro.entity.User;

/**
 * Here we have created an Interface which contains methods to save, retrieve, and count the users.
 * @author saumyaawasthi
 *
 */
public interface RegistrationServiceInterface {

	public User saveUser(User user);
	
	public User fetchUserByEmailId(String emailId);
	
	public Long countAllRegistrated();
}
