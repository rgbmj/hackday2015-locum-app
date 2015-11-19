package com.bmj.hackday.locumapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.model.Candidate;
import com.bmj.hackday.locumapp.model.CandidatesRepository;
import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class CandidatesService {


	@Autowired
	private CandidatesRepository candidatesRepository;
	
	@Autowired
	private SearchHandler searchHandler;


	public List<Candidate> getAllCandidates(UserRole roleToFetch) {
		List<Candidate> candidates = new ArrayList<Candidate>();
		
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





	public List<Candidate> getMatches(SearchParams searchParams) {
		List<Candidate> matches = searchHandler.getSearchedCandidates(searchParams);
		return matches;
	}

}
