package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.nagarro.entity.User;
import com.nagarro.model.CustomerUserDetails;

/**
 * Here we are using Product Service to get the customer.
 * @author saumyaawasthi
 * 
 *
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private RegistrationService repository;

	/**
	 * This function is used to check and return the user present in the database.
	 */
	@Override
	public CustomerUserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		final User user = this.repository.fetchUserByEmailId(emailId);
		if (user == null) {
			return null;
		} else {
			return new CustomerUserDetails(user);
		}
	}

}