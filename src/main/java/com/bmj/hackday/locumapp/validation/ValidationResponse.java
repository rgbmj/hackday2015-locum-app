package com.bmj.hackday.locumapp.validation;

import com.bmj.hackday.locumapp.role.UserRole;

public class ValidationResponse  {
	
	private final boolean isValid;
	private final UserRole userRole;
	
	public ValidationResponse(boolean isValid, UserRole userRole) {
		super();
		this.isValid = isValid;
		this.userRole = userRole;
	}

	public boolean isValid() {
		return isValid;
	}

	public UserRole getUserRole() {
		return userRole;
	}
	
	
	
	

}
