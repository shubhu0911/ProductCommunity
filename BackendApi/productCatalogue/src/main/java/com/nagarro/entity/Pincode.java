package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is used to create Pincode entity consisting of the pincode and the
 * expected message.
 * 
 * @author saumyaawasthi
 *
 */
@Entity
public class Pincode {

	@Id
	private Long pincode;
	private String message;

	public Pincode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pincode(Long pincode, String message) {
		super();
		this.pincode = pincode;
		this.message = message;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
