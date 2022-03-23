package com.covid.model;

public class Covid {
	private int new_cases;
	private String location;
	public int getNew_cases() {
		return new_cases;
	}
	public void setNew_cases(int new_cases) {
		this.new_cases = new_cases;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Covid [new_cases=" + new_cases + ", location=" + location + "]";
	}
	
}
