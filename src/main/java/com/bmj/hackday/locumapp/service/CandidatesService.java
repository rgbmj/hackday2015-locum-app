package com.bmj.hackday.locumapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.model.Grade;
import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.model.UsersRepository;
import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class CandidatesService {


	@Autowired
	private UsersRepository candidatesRepository;
	
	@Autowired
	private SearchHandler searchHandler;


	public List<UserDetail> getAllCandidates(UserRole roleToFetch) {
		List<UserDetail> candidates = new ArrayList<UserDetail>();
		
		if (roleToFetch != null){
			switch (roleToFetch) {
			case HOSPITAL:
				candidates = candidatesRepository.getAllHospitals();
				break;

			case DOCTOR:
				candidates = candidatesRepository.getAllDoctors();
				break;

			default:
				break;
			}

		}
		
		return candidates;
	}





	public List<UserDetail> getSoughtCandidates(SearchParams searchParams) {
		List<UserDetail> matches = searchHandler.getSearchedCandidates(searchParams);
		return matches;
	}





	public Set<Grade> getAllGrades() {
		Set<Grade> grades = null;
		grades = candidatesRepository.getAllHospitalsGrades();
		
		if (grades != null)
			grades.addAll(candidatesRepository.getAllDoctorsGrades());
		
		return grades;
	}





	public Set<String> getAllSpecialties() {
		Set<String> specialties = null;
		specialties = candidatesRepository.getAllHospitalsSpecialties();
		
		if (specialties != null)
			specialties.addAll(candidatesRepository.getAllDoctorsSpecialties());
		
		return specialties;
	}

}
