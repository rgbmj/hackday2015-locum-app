package com.bmj.hackday.locumapp.model;

public class Grade implements Comparable<Grade> {

	private final String grade;

	public Grade(String grade) {
		super();
		this.grade = grade.toLowerCase();
	}

	public String getGrade() {
		return grade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Grade [grade=" + grade + "]";
	}

	@Override
	public int compareTo(Grade o) {
		return (this.hashCode() - o.hashCode());
	}
	
}
