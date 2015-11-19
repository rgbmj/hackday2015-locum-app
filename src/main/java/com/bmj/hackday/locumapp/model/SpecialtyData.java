package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpecialtyData implements Cloneable {
	
	private Map<String, List<Candidate>> data;

	
	public SpecialtyData() {
		this.data = new HashMap<>();
	}
	
	
	public List<Candidate> getCandidates(String grade){
		List<Candidate> candidates = data.get(grade);
		if (candidates != null)
			return new ArrayList<>(candidates);
		else
			return null;
	}
	
	
	public SpecialtyData addCandidate(Candidate candidate) {
		String grade = candidate.getGrade();
		List<Candidate> candidates = data.get(grade);
		
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


	private List<Candidate> createCandidates(String grade) {
		List<Candidate> candidates = new ArrayList<>();
		data.put(grade, candidates);
		return candidates;
	}
	

}

