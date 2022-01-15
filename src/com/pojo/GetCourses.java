package com.pojo;

public class GetCourses {
	
	private String instructor;
	private String services;
	private String expertise;
	private String linkedIn;
	private Courses courses;
    private String url;
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getlinkedIn() {
		return linkedIn;
	}
	public void setlinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	
}
