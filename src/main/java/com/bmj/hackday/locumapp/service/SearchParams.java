package com.bmj.hackday.locumapp.service;

public class SearchParams {

	private String role; //String; "HOSPITAL" or "DOCTOR"; ignored if null/""/"ALL"
    private String grade; //String; ignored if null/""/"ALL"
    private String specialty;//String; ignored  if null/""/"ALL"
    private String postcode;//String; ignored if null/""/"ALL"
    private int range; // int; default 10,
	
    public SearchParams(){}

    
	public String getRole() {
		return role;
	}

	public String getGrade() {
		return grade;
	}

	public String getSpecialty() {
		return specialty;
	}

	public String getPostcode() {
		return postcode;
	}

	public int getRange() {
		return range;
	}

	public void setRole(String role) {
		this.role = toLowerCase(role);
	}

	public void setGrade(String grade) {
		this.grade = toLowerCase(grade);
	}

	public void setSpecialty(String specialty) {
		this.specialty = toLowerCase(specialty);
	}

	public void setPostcode(String postcode) {
		this.postcode = toLowerCase(postcode);
	}

	public void setRange(int range) {
		this.range = range;
	}
	
	
	@Override
	public String toString() {
		return "SearchParams [role=" + role + ", grade=" + grade + ", specialty=" + specialty + ", postcode=" + postcode
				+ ", range=" + range + "]";
	}


	private String toLowerCase(String string) {
		if (string != null)
			return string.toLowerCase();
		else 
			return null;
	}
}
