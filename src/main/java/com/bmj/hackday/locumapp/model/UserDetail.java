package com.bmj.hackday.locumapp.model;

import com.bmj.hackday.locumapp.role.UserRole;

public class UserDetail {

	private UserRole userRole;
	private String id;
	private String fullName;
	private String imgUrl;
	private String postcode;
	private String phone;
	private String grade;
	private String specialty;
	

	public UserDetail(){};
	
	private UserDetail(UserRole userRole, String id, String fullName, String imgName, String postcode, String phone, String grade, String specialty) {
		this.userRole = userRole;
		this.id = id;
		this.fullName = fullName;
		this.imgUrl = imgName;
		this.postcode = postcode;
		this.phone = phone;
		this.grade = grade;
		this.specialty = specialty;
	}

	public UserRole getUserRole() {
		return this.userRole;
	}
	
	public String getId() {
		return this.id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public String getImg() {
		return this.imgUrl;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public String getGrade() {
		return this.grade;
	}

	public String getPhone() {
		return this.phone;
	}

	public String getSpecialty() {
		return this.specialty;
	}
	
	public UserDetail withUserRole(UserRole userRole) {
		this.userRole = userRole;
		return this;
	}

	public UserDetail withId(String id) {
		this.id = id.toLowerCase();
		return this;
	}

	public UserDetail withFullName(String fnm) {
		fullName = fnm;
		return this;
	}

	public UserDetail withImg(String im) {
		imgUrl = im;
		return this;
	}

	public UserDetail withPostcode(String postcode) {
		this.postcode = postcode.toLowerCase().replace(" ", "");
		return this;
	}

	public UserDetail withPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public UserDetail withGrade(String grade) {
		this.grade = grade.toLowerCase();
		return this;
	}
	
	public UserDetail withSpecialty(String specialty) {
		this.specialty = specialty.toLowerCase();
		return this;
	}
	
	public UserDetail build() {
		assertNotNull("userRole", userRole);
		assertNotNull("id", id);
		assertNotNull("fullName", fullName);
		assertNotNull("imgUrl", imgUrl);
		assertNotNull("postcode", postcode);
		assertNotNull("specialty", specialty);
		assertNotNull("grade", grade);

		return new UserDetail(userRole, id, fullName, imgUrl, postcode, phone, grade, specialty);
	}

	@Override
	public String toString() {
		return "UserDetail [userRole=" + userRole + ", id=" + id + ", fullName=" + fullName + ", imgUrl=" + imgUrl
				+ ", postcode=" + postcode + ", phone=" + phone + ", grade=" + grade + ", specialty=" + specialty + "]";
	}

	private static void assertNotNull(String name, Object obj) {
		if (obj == null)
			throw new RuntimeException("Object " + name + " is null.");
	}

}
