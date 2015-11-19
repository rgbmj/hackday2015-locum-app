package com.bmj.hackday.locumapp.validation;

import com.bmj.hackday.locumapp.role.UserRole;

public class ValidationResponse  {
	
	private final boolean isValid;
	private final UserRole userRole;
	private final String id;
	
	public ValidationResponse(boolean isValid, UserRole userRole, String id) {
		this.isValid = isValid;
		this.userRole = userRole;
		this.id = id;
	}

	public boolean isValid() {
		return isValid;
	}

	public UserRole getUserRole() {
		return userRole;
	}
	
	public String getId() {
		return id;
	}
	
	
	
	

}
