package com.role.service;

import java.util.HashMap;

import com.role.model.Action;
import com.role.model.Resource;
import com.role.model.Role;

public interface IInitialization {

	public void addRole(HashMap<Resource, Action> hm, String name);
	
//	public void addResource(Resource resource, Role role, Action action);
}
