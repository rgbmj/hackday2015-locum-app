package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.model.Candidate;
import com.bmj.hackday.locumapp.model.CandidatesRepository;
import com.bmj.hackday.locumapp.model.SearchData;
import com.bmj.hackday.locumapp.model.SpecialtyData;
import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class SearchHandler {

	
	@Autowired
	CandidatesRepository candidatesRepository;
	
	
	public List<Candidate> getSearchedCandidates(SearchParams searchParams) {
		List<Candidate> candidates = new ArrayList<>();
		
		String role = searchParams.getRole();
		if (role != null) {
			switch (role) {
			case "doctor":
				candidates = doSearch(searchParams, DOCTOR);
				break;
			case "hospital":
				candidates = doSearch(searchParams, HOSPITAL);
				break;
			}
		}
		
		return candidates;
	}

	
	private List<Candidate> doSearch(SearchParams searchParams, UserRole userRole) {
		List<Candidate> candidates = null;

		SearchData allRoleData = getAllRoleData(userRole);
		if (allRoleData != null) {
			SpecialtyData specialtyData = allRoleData.getSpecialtyData(searchParams.getSpecialty());
			if (specialtyData != null) {
				candidates = specialtyData.getCandidates(searchParams.getGrade());
			}
		}

		return candidates;
	}

	
	private SearchData getAllRoleData(UserRole userRole) {
		SearchData data = null;
		
		switch (userRole) {
		case DOCTOR:
			data = candidatesRepository.getAllDoctorsData();
			break;
		case HOSPITAL:
			data = candidatesRepository.getAllHospitalsData();
			break;
		}
		
		return data;
	}





}
