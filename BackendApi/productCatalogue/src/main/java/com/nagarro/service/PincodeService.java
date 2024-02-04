package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.entity.Pincode;
import com.nagarro.repository.PincodeRepository;
import com.nagarro.serviceInterface.PincodeServiceInterface;

@Service
public class PincodeService implements PincodeServiceInterface {

	@Autowired
	private PincodeRepository repo;

	public Pincode getPincode(Long pincode) {

		Pincode pinObj = repo.findByPincode(pincode);
		return pinObj;
	}

}
