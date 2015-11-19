package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CandidatesRepository {

	
	private SearchData hospitalsSearchData;
	private SearchData doctorsSearchData;
	private List<Candidate> allHospitals;
	private List<Candidate> allDoctors;

	public CandidatesRepository() {
		initHospitals();
		initDoctors();
	}

	public List<Candidate> getAllHospitals() {
		return new ArrayList<>(allHospitals);
	}

	public List<Candidate> getAllDoctors() {
		return new ArrayList<>(allDoctors);
	}
	
	public SearchData getAllHospitalsData(){
		return hospitalsSearchData.clone();
	}

	public SearchData getAllDoctorsData(){
		return doctorsSearchData.clone();
	}
	

	private void initHospitals() {
		hospitalsSearchData = new SearchData("hospitals");
		allHospitals = new ArrayList<>();
		addCandidate(buildCandidate("Birmingham Childrens Hospital", "/img/hospitals/BCH.png", "B4 6NH", "bch", "", "0121 333 9999", ""), allHospitals, hospitalsSearchData);
		addCandidate(buildCandidate("Birmingham Womens Hospital", "/img/hospitals/BWH.png", "B15 2TG", "bwh", "", "0121 472 1377", ""), allHospitals, hospitalsSearchData);
		addCandidate(buildCandidate("Great Ormond Street Hospital", "/img/hospitals/GOSH.jpg", "WC1N 3JH", "gosh", "", "020 7405 9200", ""), allHospitals, hospitalsSearchData);
		addCandidate(buildCandidate("Heart of England NHS Trust", "/img/hospitals/HOE.jpg", "B9 5SS", "hoe", "", "0121 424 2000", ""), allHospitals, hospitalsSearchData);
		addCandidate(buildCandidate("Queen Elizabeth Hospital", "/img/hospitals/QEH.jpg", "B15 2TH", "qeh", "", "0121 627 2000", ""), allHospitals, hospitalsSearchData);
	}


	private void initDoctors() {
		doctorsSearchData = new SearchData("doctors");
		allDoctors = new ArrayList<>();
		addCandidate(buildCandidate("Ravinder Gill", "/img/doctors/RavinderGill.jpg", "B6 8AX", "ravinder", "registrar", "07712096515", "geriatrics"), allDoctors, doctorsSearchData);
		addCandidate(buildCandidate("Adrian Harris", "/img/doctors/AdrianHarris.jpg", "B4 6NJ", "adrian", "registrar", "07912345678", "geriatrics"), allDoctors, doctorsSearchData);
		addCandidate(buildCandidate("Alex Walkinshaw", "/img/doctors/AlexWalkinshaw.png", "B8 6NH", "alex", "consultant", "07711345956", "oncology"), allDoctors, doctorsSearchData);
		addCandidate(buildCandidate("Caroline Webster", "/img/doctors/CarolineWebster.jpg", "location", "caroline", "registrar", "07911345956", "neurology"), allDoctors, doctorsSearchData);
		addCandidate(buildCandidate("Chris Colquhoun", "/img/doctors/ChrisColquhoun.png", "location", "chris", "foundation_2", "07811305956", "rheumatology"), allDoctors, doctorsSearchData);
		addCandidate(buildCandidate("Derek Thompson", "/img/doctors/DerekThompson.jpg", "location", "derek","registrar", "07811345906", "geriatrics"), allDoctors, doctorsSearchData);
	}
	
	
	private void addCandidate(Candidate candidate, List<Candidate> candidates, SearchData searchData) {
		candidates.add(candidate);
		searchData.addCandidate(candidate);
	}


	private Candidate buildCandidate(String fullName, String imgUrl, String postcode, String id, String grade,
			String phone, String specialty) {
		return new Candidate().withFullName(fullName).withImg(imgUrl).withPostcode(postcode).withId(id)
				.withGrade(grade).withPhone(phone).withSpecialty(specialty).build();
	}

}

