package com.bmj.hackday.locumapp.doctor;

public class LocumDoctor {

	private String name;
	private String specialty;
	private MedicalGrade grade;
	private String postcode;
	private String imgId;
	private String phoneNumber;

	public String getName() {
		return name;
	}

	public LocumDoctor setName(String name) {
		this.name = name;
		return this;
	}

	public String getSpecialty() {
		return specialty;
	}

	public LocumDoctor setSpecialty(String specialty) {
		this.specialty = specialty;
		return this;
	}

	public MedicalGrade getGrade() {
		return grade;
	}

	public LocumDoctor setGrade(MedicalGrade grade) {
		this.grade = grade;
		return this;
	}

	public String getPostcode() {
		return postcode;
	}

	public LocumDoctor setPostcode(String postcode) {
		this.postcode = postcode;
		return this;
	}

	public String getImgId() {
		return imgId;
	}

	public LocumDoctor setImgId(String imgId) {
		this.imgId = imgId;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public LocumDoctor setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

}
