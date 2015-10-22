package com.bmj.hackday.locumapp.validation;

import com.bmj.hackday.locumapp.role.LocumRole;

public class ValidationResponse  {
	
	private final boolean isValid;
	private final LocumRole locumRole;
	
	public ValidationResponse(boolean isValid, LocumRole locumRole) {
		super();
		this.isValid = isValid;
		this.locumRole = locumRole;
	}

	public boolean isValid() {
		return isValid;
	}

	public LocumRole getLocumRole() {
		return locumRole;
	}
	
	
	
	

}
