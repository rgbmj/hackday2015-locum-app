package com.bmj.hackday.locumapp.model;

import java.util.ArrayList;
import java.util.List;

import com.bmj.hackday.locumapp.role.UserRole;

public class CandidatesChoices {

	final private List<String> choices;
	final private String id;
	final private UserRole userRole;
	
	public CandidatesChoices(String id, UserRole userRole) {
		this.id = id;
		this.userRole = userRole; 
		this.choices = new ArrayList<>();
	}
	
	
//	Copy constructor
	private CandidatesChoices(String id, UserRole userRole, List<String> choices) {
		this.id = id;
		this.userRole = userRole;
		this. choices = choices;
	}


	public String getId() {
		return id;
	}

	public CandidatesChoices addChoice(String id) {
		this.choices.add(id.toLowerCase());
		return this;
	}

	public void addChoices(List<String> choices) {
		this.choices.addAll(choices);
	}

	
	public List<String> getChoices() {
		return new ArrayList<>(choices);
	}
	
	public CandidatesChoices clone() {
		return new CandidatesChoices(this.id, this.userRole, this.choices);
	}


	public UserRole getRole() {
		return this.userRole;
	}



}
