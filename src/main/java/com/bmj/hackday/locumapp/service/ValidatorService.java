package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import org.springframework.stereotype.Service;

import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@Service
public class ValidatorService {

	private static final String[] HOSPITAL_IDS = {"bch", "bwh", "gosh", "hoe", "qeh"};
	private static final String[] DOCTOR_IDS = {"ravinder", "adrian", "alex", "caroline", "chris", "derek"};

	public ValidationResponse getValidationDetails(UserName username) {
		ValidationResponse validationResponse = null;
		
		if (username != null) {
			String id = username.getName();
			if (id != null) {
				if (isValid(id, HOSPITAL_IDS)) 
					validationResponse = createHospitalResponse(id);
				else if (isValid(id, DOCTOR_IDS)) 
					validationResponse = createDoctorResponse(id);
				else 
					validationResponse = createNonValidResponse();
			}
		}
				
		return validationResponse;
	}

	private boolean isValidDoctor(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isValid(String name, String[] ids) {
		boolean isValid = false;
		for (String id : ids) {
			if (id.equals(name)) {
				isValid = true;
				break;
			}
		}

		return isValid;
	}

	private ValidationResponse createNonValidResponse() {
		return new ValidationResponse(false, null, null);
	}

	private ValidationResponse createDoctorResponse(String id) {
		return new ValidationResponse(true, DOCTOR, id);
	}

	private ValidationResponse createHospitalResponse(String id) {
		return new ValidationResponse(true, HOSPITAL, id);
	}

}
