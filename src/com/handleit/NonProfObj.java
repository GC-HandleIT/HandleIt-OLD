package com.handleit;

public class NonProfObj {

	private String id;	
	private String name;
	private String link;
	private String contact_person;
	private String email_address;
	private String focus; 
	private String location;
	private String project_type;
	private String project_description;
	
	public NonProfObj(String id, String name, String link, String contact_person, String email_address, String focus,
			String location, String project_type, String project_description) {
		super();
		this.id = id;
		this.name = name;
		this.link = link;
		this.contact_person = contact_person;
		this.email_address = email_address;
		this.focus = focus;
		this.location = location;
		this.project_type = project_type;
		this.project_description = project_description;
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
	public String getContact_person() {
		return contact_person;
	}
	public void setContact_person(String contact_person) {
		this.contact_person = contact_person;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
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
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getProject_description() {
		return project_description;
	}
	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	
}
