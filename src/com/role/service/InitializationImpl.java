package com.role.service;

import java.util.HashMap;

import com.role.memory.InMemoryDb;
import com.role.model.Action;
import com.role.model.Resource;
import com.role.model.Role;

public class InitializationImpl implements IInitialization {

	@Override
	public void addRole(HashMap<Resource, Action> hm, String name) {
		// TODO Auto-generated method stub
		Role role = new Role();
		role.setAccess(hm);
		role.setName(name);
		InMemoryDb.roles.put(name,role);
	}	
}