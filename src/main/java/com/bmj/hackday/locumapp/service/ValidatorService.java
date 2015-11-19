package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import org.springframework.stereotype.Service;

import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@Service
public class ValidatorService {

	public ValidationResponse getValidationDetails(UserName username) {
		ValidationResponse validationResponse = null;
		
		if (username != null && username.getName() != null) {
			switch (username.getName()) {
			case "HOSPITAL":
			case "hospital":
				validationResponse = new ValidationResponse(true, HOSPITAL);
				break;
			case "ravinder":
			case "stephen":
			case "rauf":
			case "seema":
			case "beverley":
			case "RAVINDER":
			case "STEPHEN":
			case "RAUF":
			case "SEEMA":
			case "BEVERLEY":
				validationResponse = new ValidationResponse(true, DOCTOR);
				break;
			default:
				validationResponse = new ValidationResponse(false, null);
			}
		}
		
		return validationResponse;
	}

}
