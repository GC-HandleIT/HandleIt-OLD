package com.handleit;

public class NonProfObj {

	private String id;
	private String name;
	private String link;
	private String contactPerson;
	private String emailAddress;
	private String focus;
	private String location;
	private String projectType;
	private String projectDescription;

	public NonProfObj(String id, String name, String link, String contactPerson, String emailAddress, String focus,
			String location, String projectType, String projectDescription) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.contactPerson = contactPerson;
		this.emailAddress = emailAddress;
		this.focus = focus;
		this.location = location;
		this.projectType = projectType;
		this.projectDescription = projectDescription;
	}

	public NonProfObj() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

}
