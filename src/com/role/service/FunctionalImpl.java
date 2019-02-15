package com.role.service;

import java.util.ArrayList;
import java.util.List;

import com.role.memory.InMemoryDb;
import com.role.model.Action;
import com.role.model.Resource;
import com.role.model.Role;
import com.role.model.User;

public class FunctionalImpl implements IFunctional {

	@Override
	public void addUser(User user) {			//assigning default role to user
		// TODO Auto-generated method stub
		if(InMemoryDb.users.containsKey(user.getName())) {
			System.out.println("User already present in system.");
			System.out.println("Try changing this user's role");
		}
		else {
			List<Role> roleList = new ArrayList<Role>();
			roleList.add(InMemoryDb.roles.get("Basic"));		//"Basic" role given
			user.setRole(roleList);
			InMemoryDb.users.put(user.getName(),user);
			
		}	
	}
	
	@Override
	public void addUser(User user, Role role) {
		// TODO Auto-generated method stub
		if(InMemoryDb.users.containsKey(user.getName())) {
			System.out.println("User already present in system.");
			System.out.println("Try changing this user's role");
		}
		else {
			List<Role> roleList = new ArrayList<Role>();
			roleList.add(role);
			user.setRole(roleList);
			InMemoryDb.users.put(user.getName(),user);
		}
	}

	@Override
	public void addRoleToUser(User user, Role role) {
		// TODO Auto-generated method stub
		List<Role> roleList = user.getRole();
		roleList.add(role);
		user.setRole(roleList);
	}

	@Override
	public void removeRoleFromUser(User user, Role role) {
		// TODO Auto-generated method stub
		List<Role> roleList = user.getRole();
		roleList.remove(role);
		user.setRole(roleList);
	}
	
	@Override
	public boolean accessCheck(User user, Action action, Resource resource) {
		// TODO Auto-generated method stub
		List<Role> roleList = user.getRole();
		for(Role role: roleList) {
			if(role.getAccess().containsKey(resource)) {
				if(role.getAccess().get(resource).equals(action))
					return true;
			}
		}
		return false;
	}
}