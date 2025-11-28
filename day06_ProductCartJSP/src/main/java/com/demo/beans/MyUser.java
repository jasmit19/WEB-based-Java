package com.demo.beans;

public class MyUser {
	private String name;
	private String email;
	private String role;
	
	public MyUser() {
		super();
	}
	
	public MyUser(String name, String email, String role) {
		super();
		this.name = name;
		this.email = email;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
