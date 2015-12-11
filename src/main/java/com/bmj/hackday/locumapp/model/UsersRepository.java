package com.bmj.hackday.locumapp.model;

import static com.bmj.hackday.locumapp.role.UserRole.DOCTOR;
import static com.bmj.hackday.locumapp.role.UserRole.HOSPITAL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

import com.bmj.hackday.locumapp.role.UserRole;

@Component
public class UsersRepository {

	
	private SearchData hospitalsSearchData;
	private SearchData doctorsSearchData;
	private Map<String, UserDetail> allHospitalsCandidates;
	private Map<String, UserDetail> allDoctorsCandidates;
	private Map<String, UserRole> idRoles;

	public UsersRepository() {
		idRoles = new HashMap<String, UserRole>();
		initHospitals();
		initDoctors();
	}

	public List<UserDetail> getAllHospitals() {
		return new ArrayList<>(allHospitalsCandidates.values());
	}

	public List<UserDetail> getAllDoctors() {
		return new ArrayList<>(allDoctorsCandidates.values());
	}
	
	public SearchData getAllHospitalsData(){
		return hospitalsSearchData.clone();
	}

	public SearchData getAllDoctorsData(){
		return doctorsSearchData.clone();
	}

	public UsersRepository addUser(UserDetail userDetail) {
		switch (userDetail.getUserRole()) {
		case HOSPITAL:
			addHospital(userDetail);
			break;
		case DOCTOR:
			addDoctor(userDetail);
			break;
		}
		
		idRoles.put(userDetail.getId(), userDetail.getUserRole());
		
		return this;
	}
	
	public UserDetail getUser(String matchId) {
		UserDetail userDetail = allHospitalsCandidates.get(matchId);
		
		if (userDetail == null)
			userDetail = allDoctorsCandidates.get(matchId);
		
		return userDetail;	
	}
	

	private void initHospitals() {
		hospitalsSearchData = new SearchData("hospitals");
		allHospitalsCandidates = new HashMap<>();
//		addUser(buildCandidate(HOSPITAL, "Hospital 1", "", "", "hospital1", "", "", ""));
		addUser(buildCandidate(HOSPITAL, "Birmingham Childrens Hospital", "/img/hospitals/BCH.png", "B4 6NH", "bch", "registrar", "0121 333 9999", "paediatrics"));
		addUser(buildCandidate(HOSPITAL, "Birmingham Womens Hospital", "/img/hospitals/BWH.png", "B15 2TG", "bwh", "registrar", "0121 472 1377", "geriatrics"));
		addUser(buildCandidate(HOSPITAL, "Great Ormond Street Hospital", "/img/hospitals/GOSH.jpg", "WC1N 3JH", "gosh", "consultant", "020 7405 9200", "paediatrics"));
		addUser(buildCandidate(HOSPITAL, "Heart of England NHS Trust", "/img/hospitals/HOE.jpg", "B9 5SS", "hoe", "consultant", "0121 424 2000", "geriatrics"));
		addUser(buildCandidate(HOSPITAL, "Queen Elizabeth Hospital", "/img/hospitals/QEH.jpg", "B15 2TH", "qeh", "registrar", "0121 627 2000", "geriatrics"));
	}


	private void initDoctors() {
		doctorsSearchData = new SearchData("doctors");
		allDoctorsCandidates = new HashMap<>();
//		addUser(buildCandidate(DOCTOR, "Doctor 1", "", "", "doc1", "", "", ""));
		addUser(buildCandidate(DOCTOR, "Ravinder Gill", "/img/doctors/RavinderGill.jpg", "B6 8AX", "ravinder", "registrar", "07712096515", "geriatrics"));
		addUser(buildCandidate(DOCTOR, "Adrian Harris", "/img/doctors/AdrianHarris.jpg", "B4 6NJ", "adrian", "registrar", "07912345678", "paediatrics"));
		addUser(buildCandidate(DOCTOR, "Alex Walkinshaw", "/img/doctors/AlexWalkinshaw.png", "B8 6NH", "alex", "consultant", "07711345956", "oncology"));
		addUser(buildCandidate(DOCTOR, "Caroline Webster", "/img/doctors/CarolineWebster.jpg", "B11 9NH", "caroline", "registrar", "07911345956", "neurology"));
		addUser(buildCandidate(DOCTOR, "Chris Colquhoun", "/img/doctors/ChrisColquhoun.png", "location", "chris", "foundation_2", "07811305956", "rheumatology"));
		addUser(buildCandidate(DOCTOR, "Derek Thompson", "/img/doctors/DerekThompson.jpg", "location", "derek","registrar", "07811345906", "geriatrics"));
	}
	
	

	private UserDetail buildCandidate(UserRole userRole, String fullName, String imgUrl, String postcode, String id, String grade,
			String phone, String specialty) {
		return new UserDetail()
				.withUserRole(userRole)
				.withFullName(fullName)
				.withImg(imgUrl)
				.withPostcode(postcode)
				.withId(id)
				.withGrade(grade)
				.withPhone(phone)
				.withSpecialty(specialty)
				.build();
	}

	

	private void addHospital(UserDetail userDetail) {
		allHospitalsCandidates.put(userDetail.getId(), userDetail);
		hospitalsSearchData.addCandidate(userDetail);
	}

	private void addDoctor(UserDetail userDetail) {
		allDoctorsCandidates.put(userDetail.getId(), userDetail);
		doctorsSearchData.addCandidate(userDetail);
	}

	public Set<String> getAllHospitalsGrades() {
		return getAllGrades(hospitalsSearchData);
	}


	public Set<String> getAllDoctorsGrades() {
		return getAllGrades(doctorsSearchData);
	}

	private Set<String> getAllGrades(SearchData searchData) {
		Set<String> allHospitalGrades= new TreeSet<>();
		
		List<GradesData> allGradesData = searchData.getAllGradesData();
		for (GradesData gradesData : allGradesData) 
			allHospitalGrades.addAll(gradesData.getAllGrades());
		
		return allHospitalGrades;
	}
}

