package com.nagarro.serviceInterface;

import com.nagarro.entity.Pincode;

/**
 * Here we have created an Interface which contains method to get the pincode
 * entered by the user.
 * 
 * @author saumyaawasthi
 *
 */
public interface PincodeServiceInterface {
	public Pincode getPincode(Long pincode);

}
