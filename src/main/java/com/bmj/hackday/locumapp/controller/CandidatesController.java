package com.bmj.hackday.locumapp.controller;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.role.UserRole;
import com.bmj.hackday.locumapp.service.CandidatesService;
import com.bmj.hackday.locumapp.service.ValidatorService;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@RestController
public class CandidatesController {
	
	@Autowired
    private CandidatesService candidatesService;
	
	@Autowired
	private ValidatorService validatorService;
	

	@RequestMapping(value = "/getallcandidates", method = POST)
	public List<UserDetail> getAllCandidates(@RequestBody UserName username) {
		ValidationResponse validation = validatorService.getValidationDetails(username);

		UserRole roleToFetch = null;
		if (validation != null && validation.isValid()){
			switch (validation.getUserRole()){
			case DOCTOR:
				roleToFetch = HOSPITAL;
				break;
			case HOSPITAL:
				roleToFetch = DOCTOR;
				break;
			}

		}
	
		return candidatesService.getAllCandidates(roleToFetch);
	}
	
	
	@RequestMapping(value = "/grades", method = GET)
	public Set<String> getAllGrades(){
		return candidatesService.getAllGrades();
	}
	
	
	@RequestMapping(value = "/specialties", method = GET)
	public Set<String> getAllSpecialties(){
		return candidatesService.getAllSpecialties();
	}


}
