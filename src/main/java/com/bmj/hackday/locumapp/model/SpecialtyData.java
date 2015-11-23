package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialtyData implements Cloneable {
	
	private Map<String, List<UserDetail>> data;

	
	public SpecialtyData() {
		this.data = new HashMap<>();
	}
	
	
	public List<UserDetail> getCandidates(String grade){
		List<UserDetail> candidates = data.get(grade);
		if (candidates != null)
			return new ArrayList<>(candidates);
		else
			return null;
	}
	
	
	public SpecialtyData addCandidate(UserDetail candidate) {
		String grade = candidate.getGrade();
		List<UserDetail> candidates = data.get(grade);
		
		if (candidates == null)
			candidates = createCandidates(grade);
		
		candidates.add(candidate);

		return this;
	}
	
	@Override
	public SpecialtyData clone() {
		SpecialtyData clone = new SpecialtyData();
		clone.data = new HashMap<>(this.data);
		return clone;
	}


	private List<UserDetail> createCandidates(String grade) {
		List<UserDetail> candidates = new ArrayList<>();
		data.put(grade, candidates);
		return candidates;
	}
	

}

