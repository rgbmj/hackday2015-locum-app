package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.model.UsersRepository;
import com.bmj.hackday.locumapp.model.SearchData;
import com.bmj.hackday.locumapp.model.GradesData;
import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class SearchHandler {

	
	@Autowired
	UsersRepository candidatesRepository;
	
	
	public List<UserDetail> getSearchedCandidates(SearchParams searchParams) {
		List<UserDetail> candidates = new ArrayList<>();
		
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

	
	private List<UserDetail> doSearch(SearchParams searchParams, UserRole userRole) {
		List<UserDetail> candidates = null;

		SearchData allRoleData = getAllRoleData(userRole);
		if (allRoleData != null) {
			GradesData specialtyData = allRoleData.getGradesData(searchParams.getSpecialty());
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
