package com.bmj.hackday.locumapp.model;

public class Candidate {

	private String name;
	private String fullName;
	private String imgUrl;
	private String location;

	public Candidate(){};
	
	private Candidate(String name, String fullName, String imgName, String location) {
		this.name = name;
		this.fullName = fullName;
		this.imgUrl = imgName;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public String getFullName() {
		return fullName;
	}

	public String getImg() {
		return imgUrl;
	}

	public String getLocation() {
		return location;
	}

	public Candidate withName(String nm) {
		name = nm;
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

	public Candidate withLocation(String loc) {
		location = loc;
		return this;
	}

	public Candidate build() {
		assertNotNull("name", name);
		assertNotNull("fullName", fullName);
		assertNotNull("imgUrl", imgUrl);
		assertNotNull("location", location);

		return new Candidate(name, fullName, imgUrl, location);
	}

	private static void assertNotNull(String name, Object obj) {
		if (obj == null)
			throw new RuntimeException("Object " + name + " is null.");
	}

}
