package com.bmj.hackday.locumapp.model;

import java.util.HashMap;
import java.util.Map;

public class SearchData implements Cloneable {
	
	final private String name;
	
	private Map<String, SpecialtyData> data;

	public SearchData(String name) {
		this.name = name;
		this.data = new HashMap<>();
	}
	
	public SpecialtyData getSpecialtyData(String specialty) {
		SpecialtyData specialtyData = data.get(specialty);
		if (specialtyData == null)
			return null;
		else
			return specialtyData.clone();
	}
	
	public SearchData addCandidate(Candidate candidate) {
		String specialty = candidate.getSpecialty();
		SpecialtyData specialtyData = data.get(specialty);
		
		if (specialtyData == null) 
			addNewSpecialtyData(candidate);
		else 
			specialtyData.addCandidate(candidate);

		return this;
	}
	
	private void addNewSpecialtyData(Candidate candidate) {
		String specialty = candidate.getSpecialty();

		SpecialtyData specialtyData = new SpecialtyData();
		specialtyData.addCandidate(candidate);
		
		data.put(specialty, specialtyData);
	}

	@Override
	public SearchData clone() {
		SearchData clone = new SearchData(this.name);
		clone.data = new HashMap<>(this.data);
		return clone;
	}

}