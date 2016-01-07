package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.bmj.hackday.locumapp.model.bean.Specialty;

public class SearchData implements Cloneable {
	
	private Map<Specialty, GradesData> data;

	public SearchData() {
		this.data = new TreeMap<>();
	}
	
	public GradesData getGradesData(String specialty) {
		GradesData gradesData = data.get(specialty);
		if (gradesData == null)
			return null;
		else
			return gradesData.clone();
	}
	
	public List<GradesData> getAllGradesData(){
		return new ArrayList<>(data.values());
	}
	
	
	public SearchData addCandidate(UserDetail userDetail) {
		String specialtyVal = userDetail.getSpecialty();
		GradesData specialtyData = data.get(new Specialty(specialtyVal));
		
		if (specialtyData == null) 
			addNewSpecialty(userDetail);
		else 
			specialtyData.addCandidate(userDetail);

		return this;
	}
	
	private void addNewSpecialty(UserDetail candidate) {
		Specialty specialty = new Specialty(candidate.getSpecialty());

		GradesData gradesData = new GradesData();
		gradesData.addCandidate(candidate);
		
		data.put(specialty, gradesData);
	}

	@Override
	public SearchData clone() {
		SearchData clone = new SearchData();
		clone.data = new HashMap<>(this.data);
		return clone;
	}

	public Set<Specialty> getAllSpecialties() {
		return new TreeSet<>(data.keySet());
	}

}
