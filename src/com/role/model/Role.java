package com.role.model;

import java.util.*;

public class Role {
	
	private String name;
	
	private HashMap<Resource,Action> access;
	
	private List<User> users;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Resource, Action> getAccess() {
		return access;
	}

	public void setAccess(HashMap<Resource, Action> access) {
		this.access = access;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}