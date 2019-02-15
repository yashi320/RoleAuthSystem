package com.role.service;

import java.util.HashMap;

import com.role.model.*;

public interface IFunctional {

	public void addUser(User user);
	
	public void addUser(User user, Role role);
	
	public void addRoleToUser(User user, Role role);
	
	public void removeRoleFromUser(User user, Role role);
	
	public boolean accessCheck(User user, Action action, Resource resource);
	
}