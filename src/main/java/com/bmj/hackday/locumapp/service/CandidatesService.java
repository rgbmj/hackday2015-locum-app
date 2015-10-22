package com.bmj.hackday.locumapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.model.Candidate;
import com.bmj.hackday.locumapp.model.UserName;
import com.bmj.hackday.locumapp.validation.ValidationResponse;

@Component
public class CandidatesService {

	@Autowired
	private ValidatorService validatorService;

	public List<Candidate> getCandidates(UserName username) {
		List<Candidate> candidates = new ArrayList<Candidate>();

		ValidationResponse validation = validatorService.getValidationDetails(username);

		if (validation != null && validation.isValid()) {
			switch (validation.getLocumRole()) {
			case HOSPITAL:
				populateWithDoctors(candidates);
				break;

			case DOCTOR:
				populateWithHospitals(candidates);
				break;

			default:
				break;
			}
		}

		return candidates;
	}

	private void populateWithHospitals(List<Candidate> candidates) {
		candidates.add(buildCandidate("Birmingham Childrens Hospital", "/img/hospitals/BCH.png", "location", "bch"));
		candidates.add(buildCandidate("Birmingham Womens Hospital", "/img/hospitals/BWH.png", "location", "bwh"));
		candidates.add(buildCandidate("Great Ormond Street Hospital", "/img/hospitals/GOSH.jpg", "location", "gosh"));
		candidates.add(buildCandidate("Heart of England NHS Trust", "/img/hospitals/HOE.jpg", "location", "hoe"));
		candidates.add(buildCandidate("Queen Elizabeth Hospital", "/img/hospitals/QEH.jpg", "location", "qeh"));
	}

	private void populateWithDoctors(List<Candidate> candidates) {
		candidates.add(buildCandidate("Adrian Harris", "/img/doctors/AdrianHarris.jpg", "location", "adrian"));
		candidates.add(buildCandidate("Alex Walkinshaw", "/img/doctors/AlexWalkinshaw.png", "location", "alex"));
		candidates.add(buildCandidate("Caroline Webster", "/img/doctors/CarolineWebster.jpg", "location", "caroline"));
		candidates.add(buildCandidate("Chris Colquhoun", "/img/doctors/ChrisColquhoun.png", "location", "chris"));
		candidates.add(buildCandidate("Derek Thompson", "/img/doctors/DerekThompson.jpg", "location", "derek"));
	}

	private Candidate buildCandidate(String fullName, String imgUrl, String location, String name) {
		return new Candidate().withFullName(fullName).withImg(imgUrl).withLocation(location).withName(name).build();
	}

}
