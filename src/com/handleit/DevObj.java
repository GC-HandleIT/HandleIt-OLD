package com.handleit;

public class DevObj {
	
	private String id;	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String location;
	private String picUrl;
	private String profileUrl;
	private String skills;
	private String aboutMe;
	
	
	public DevObj(String id, String firstName, String lastName, String emailAddress, String location, String picUrl,
			String profileUrl, String skills, String aboutMe) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.location = location;
		this.picUrl = picUrl;
		this.profileUrl = profileUrl;
		this.skills = skills;
		this.aboutMe = aboutMe;
		
		
	}
	
	public DevObj() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getPicUrl() {
		return picUrl;
	}


	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}


	public String getProfileUrl() {
		return profileUrl;
	}


	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getAboutMe() {
		return aboutMe;
	}


	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

}
