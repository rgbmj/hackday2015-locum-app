package com.bmj.hackday.locumapp.model;

public class UserName {
	
	private String name;


	public void setName(String name) {
		this.name = name.toLowerCase();
	}


	public String getName() {
		return name;
	}

}
