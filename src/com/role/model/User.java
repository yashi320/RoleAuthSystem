package com.role.model;

import java.util.List;

public class User {
	
	private List<Role> role;

	private String name;
	
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}