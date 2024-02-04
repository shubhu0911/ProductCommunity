package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.Pincode;
import com.nagarro.service.PincodeService;

/**
 * PincodeController is implementing the api for searching the entered pincode
 * in the Pincode Database.
 * @author saumyaawasthi
 * 
 *
 */
@RestController
@CrossOrigin
public class PincodeController {

	@Autowired
	private PincodeService service;

	/**
	 * This function checks if the entered pincode is present in database or not.
	 * 
	 * @param pincode
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/checkservice/{pincode}")
	public Pincode getProductBypincode(@PathVariable("pincode") Long pincode) throws Exception {

		Pincode pin = this.service.getPincode(pincode);
		if (pin == null) {

			System.out.println("Pincode not found");

		}

		return pin;

	}

}
