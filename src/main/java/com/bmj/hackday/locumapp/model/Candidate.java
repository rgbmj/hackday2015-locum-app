package com.bmj.hackday.locumapp.model;

public class Candidate {

	private String id;
	private String fullName;
	private String imgUrl;
	private String postcode;
	private String phone;
	private String grade;
	private String specialty;
	

	public Candidate(){};
	
	private Candidate(String id, String fullName, String imgName, String postcode, String phone, String grade, String specialty) {
		this.id = id;
		this.fullName = fullName;
		this.imgUrl = imgName;
		this.postcode = postcode;
		this.phone = phone;
		this.grade = grade;
		this.specialty = specialty;
	}

	public String getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getImg() {
		return imgUrl;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getGrade() {
		return grade;
	}

	public String getPhone() {
		return phone;
	}

	public String getSpecialty() {
		return specialty;
	}

	public Candidate withId(String id) {
		this.id = id.toLowerCase();
		return this;
	}

	public Candidate withFullName(String fnm) {
		fullName = fnm;
		return this;
	}

	public Candidate withImg(String im) {
		imgUrl = im;
		return this;
	}

	public Candidate withPostcode(String postcode) {
		this.postcode = postcode.toLowerCase().replace(" ", "");
		return this;
	}

	public Candidate withPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public Candidate withGrade(String grade) {
		this.grade = grade.toLowerCase();
		return this;
	}
	
	public Candidate withSpecialty(String specialty) {
		this.specialty = specialty.toLowerCase();
		return this;
	}
	
	public Candidate build() {
		assertNotNull("id", id);
		assertNotNull("fullName", fullName);
		assertNotNull("imgUrl", imgUrl);
		assertNotNull("postcode", postcode);
		assertNotNull("specialty", specialty);
		assertNotNull("grade", grade);

		return new Candidate(id, fullName, imgUrl, postcode, phone, grade, specialty);
	}

	private static void assertNotNull(String name, Object obj) {
		if (obj == null)
			throw new RuntimeException("Object " + name + " is null.");
	}

}
