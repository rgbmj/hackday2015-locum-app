package com.bmj.hackday.locumapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bmj.hackday.locumapp.model.CandidatesChoices;
import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.role.UserRole;
import com.bmj.hackday.locumapp.service.MatcherService;
import com.bmj.hackday.locumapp.service.ValidatorService;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@RestController
public class MatchController {
	
	@Autowired
	MatcherService service;

	@Autowired
	ValidatorService validationService;
	
	@RequestMapping(value = "/savechoices/{id}", method = RequestMethod.POST)
	public void saveChoices(@RequestParam String id, @RequestBody List<String> choices) {
		ValidationResponse validation = validationService.getValidationDetails(id);
		CandidatesChoices candidatesChoices = createCandidatesChoices(validation, choices);
		service.saveChoices(candidatesChoices);
	}
	
	


	@RequestMapping(value = "/getmatches", method = RequestMethod.GET)
	public @ResponseBody List<UserDetail> getMatches(@RequestParam String id){
		List<UserDetail> matches = null;

		ValidationResponse validation = validationService.getValidationDetails(id);
		if (validation.isValid())
			matches = getMatches(validation);

		if (matches == null)
			matches = new ArrayList<>();
	
		return matches;
	}




	private List<UserDetail> getMatches(ValidationResponse validation) {
		List<UserDetail> matches = null;
		
		UserRole role = validation.getUserRole();
		if (role != null)
			matches = getRoledMatches(validation, role);
		
		return matches;
	}


	private CandidatesChoices createCandidatesChoices(ValidationResponse validation, List<String> choices) {
		CandidatesChoices candidatesChoices = null;
		
		if (validation != null && validation.isValid()) {
			String id = validation.getId();
			UserRole userRole = validation.getUserRole();
			candidatesChoices = new CandidatesChoices(id, userRole);
			candidatesChoices.addChoices(choices);
		}
		
		return candidatesChoices;
	}

	
	private List<UserDetail> getRoledMatches(ValidationResponse validation, UserRole role) {
		List<UserDetail> matches = null;
		switch (role) {
		case DOCTOR:
			matches = service.getDoctorMatches(validation.getId());
			break;
		case HOSPITAL:
			matches = service.getHospitalMatches(validation.getId());
			break;
		}
		
		return matches;
	}

}
