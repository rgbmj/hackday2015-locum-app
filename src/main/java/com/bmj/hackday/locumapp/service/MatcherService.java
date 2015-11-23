package com.bmj.hackday.locumapp.service;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmj.hackday.locumapp.model.CandidatesChoices;
import com.bmj.hackday.locumapp.model.MatcherRepository;
import com.bmj.hackday.locumapp.model.UserDetail;
import com.bmj.hackday.locumapp.model.UsersRepository;
import com.bmj.hackday.locumapp.role.UserRole;


@Service
public class MatcherService {
	
	@Autowired
	private MatcherRepository matcherRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	public void saveChoices(CandidatesChoices candidatesChoices) {
		matcherRepository.saveChoices(candidatesChoices);
	}

	
	/**
	 * Returns all users who have chosen given hospital id.
	 * @param id
	 * @return
	 */
	public List<UserDetail> getHospitalMatches(String id) {
		return getMatches(id, HOSPITAL);
	}

	
	/**
	 * Returns all users who have chosen given doctor id.
	 * @param id
	 * @return
	 */
	public List<UserDetail> getDoctorMatches(String id) {
		return getMatches(id, DOCTOR);
	}


	private List<UserDetail> getMatches(String id, UserRole userRole) {
		List<UserDetail> matches = new ArrayList<>();
		
		List<String> matchIds = getMatchedChoosers(userRole, id);
		for (String matchId : matchIds) {
			matches.add(usersRepository.getUser(matchId));
		}
		
		return matches;
	}


	private List<String> getMatchedChoosers(UserRole userRole, String id) {
		List<String> matchIds = null;
		
		switch (userRole) {
		case HOSPITAL:
			matchIds = matcherRepository.getHospitalMatches(id);
			break;
		case DOCTOR:
			matchIds = matcherRepository.getDoctorMatches(id);
			break;
		}

		return matchIds;
	}

}
