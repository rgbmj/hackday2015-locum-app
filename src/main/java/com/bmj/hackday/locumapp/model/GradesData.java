package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.bmj.hackday.locumapp.model.bean.Grade;

public class GradesData implements Cloneable {
	
	private Map<Grade, List<UserDetail>> data;

	
	public GradesData() {
		this.data = new TreeMap<>();
	}
	
	
	public List<UserDetail> getCandidates(String gradeName){
		List<UserDetail> candidates = data.get(new Grade(gradeName));
		if (candidates != null)
			return new ArrayList<>(candidates);
		else
			return null;
	}
	
	
	public GradesData addCandidate(UserDetail candidate) {
		Grade grade = new Grade(candidate.getGrade());
		
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


	private List<UserDetail> createCandidates(Grade grade) {
		List<UserDetail> candidates = new ArrayList<>();
		data.put(grade, candidates);
		return candidates;
	}


	public Set<Grade> getAllGrades() {
		return new TreeSet<>(data.keySet());
	}
	

}

