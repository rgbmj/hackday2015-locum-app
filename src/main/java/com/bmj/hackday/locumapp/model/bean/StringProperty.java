package com.bmj.hackday.locumapp.model.bean;

public abstract class StringProperty implements Comparable<StringProperty> {

	final int prime = 31;
	final private String value;

	private int hash;

	public StringProperty(String value) {
		super();
		this.value = value.toLowerCase();
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		StringProperty other = (StringProperty) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		if (hash > 0)
			return hash;

		hash = 1;
		hash = prime * hash + ((value == null) ? 0 : value.hashCode());
		return hash;
	}

	@Override
	public String toString() {
		return getClass().toString() + " [" + value + "]";
	}

	@Override
	public int compareTo(StringProperty o) {
		return (this.hashCode() - o.hashCode());
	}

}
