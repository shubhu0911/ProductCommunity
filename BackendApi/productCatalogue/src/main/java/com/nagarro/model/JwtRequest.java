package com.nagarro.model;

import java.io.Serializable;

/**
 * JwtRequest object used as a request object for getting username and password
 * from the client.
 * @author saumyaawasthi
 * 
 *
 */

public class JwtRequest implements Serializable {
	private static final long serialVersionUID = 5926468583005150707L;

	private String emailId;
	private String password;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}