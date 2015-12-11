package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class GradesData implements Cloneable {
	
	private Map<String, List<UserDetail>> data;

	
	public GradesData() {
		this.data = new TreeMap<>();
	}
	
	
	public List<UserDetail> getCandidates(String grade){
		List<UserDetail> candidates = data.get(grade);
		if (candidates != null)
			return new ArrayList<>(candidates);
		else
			return null;
	}
	
	
	public GradesData addCandidate(UserDetail candidate) {
		String grade = candidate.getGrade();
		List<UserDetail> candidates = data.get(grade);
		
		if (candidates == null)
			candidates = createCandidates(grade);
		
		candidates.add(candidate);

		return this;
	}
	
	@Override
	public GradesData clone() {
		GradesData clone = new GradesData();
		clone.data = new HashMap<>(this.data);
		return clone;
	}


	private List<UserDetail> createCandidates(String grade) {
		List<UserDetail> candidates = new ArrayList<>();
		data.put(grade, candidates);
		return candidates;
	}


	public Set<String> getAllGrades() {
		return new TreeSet<>(data.keySet());
	}
	

}

