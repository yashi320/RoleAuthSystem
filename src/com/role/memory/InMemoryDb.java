package com.role.memory;

import java.util.HashMap;
import java.util.Iterator;

import com.role.model.Action;
import com.role.model.Resource;
import com.role.model.Role;
import com.role.model.User;
import com.role.service.IInitialization;
import com.role.service.InitializationImpl;

public class InMemoryDb {
	
	public static HashMap<String, User> users;
	
	public static HashMap<String, Role> roles;
	
	public static HashMap<String, Resource> resources;
	
	
	public static void memoryInitialization() {
		
		users = new HashMap<String, User>();
		roles = new HashMap<String, Role>();
		resources = new HashMap<String, Resource>();
		
		roleInitialization();
	}

	public static void displayRoleList() {
		System.out.println("ROLE LIST");
		Iterator it = roles.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println(key);
		}
		System.out.println("ROLE LIST ENDS");
	}
	
	
	public static void displayResourceList() {
		System.out.println("RESOURCE LIST");
		Iterator it = resources.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			System.out.println(key);
		}
		System.out.println("RESOURCE LIST ENDS");
	}
	
	
	public static void roleInitialization() {
		
		resourceInitialization();
		
		IInitialization init = new InitializationImpl();
		HashMap<Resource, Action> baseRoleHm = new HashMap<Resource, Action>();
		baseRoleHm.put(resources.get("Res1"), Action.READ);
		baseRoleHm.put(resources.get("Res2"), Action.READ);
		init.addRole(baseRoleHm, "Basic");
		
		HashMap<Resource, Action> adminRoleHm = new HashMap<Resource, Action>();
		adminRoleHm.put(resources.get("Res1"), Action.WRITE);
		adminRoleHm.put(resources.get("Res2"), Action.WRITE);
		adminRoleHm.put(resources.get("Res3"), Action.WRITE);
		adminRoleHm.put(resources.get("Res4"), Action.WRITE);
		adminRoleHm.put(resources.get("Res5"), Action.WRITE);
		init.addRole(adminRoleHm, "Admin");
		
		HashMap<Resource, Action> devRoleHm = new HashMap<Resource, Action>();
		devRoleHm.put(resources.get("Res1"), Action.WRITE);
		devRoleHm.put(resources.get("Res2"), Action.READ);
		devRoleHm.put(resources.get("Res3"), Action.READ);
		devRoleHm.put(resources.get("Res4"), Action.READ);
		devRoleHm.put(resources.get("Res5"), Action.WRITE);
		init.addRole(devRoleHm, "Developer");
		
		HashMap<Resource, Action> srDevRoleHm = new HashMap<Resource, Action>();
		srDevRoleHm.put(resources.get("Res1"), Action.WRITE);
		srDevRoleHm.put(resources.get("Res2"), Action.WRITE);
		srDevRoleHm.put(resources.get("Res3"), Action.WRITE);
		srDevRoleHm.put(resources.get("Res4"), Action.READ);
		srDevRoleHm.put(resources.get("Res5"), Action.DELETE);
		init.addRole(srDevRoleHm, "Sr.Developer");
	}
	
	
	public static void resourceInitialization() {
		Resource r1=new Resource("Res1");
		Resource r2=new Resource("Res2");
		Resource r3=new Resource("Res3");
		Resource r4=new Resource("Res4");
		Resource r5=new Resource("Res5");
		resources.put(r1.getValue(), r1);
		resources.put(r2.getValue(), r2);
		resources.put(r3.getValue(), r3);
		resources.put(r4.getValue(), r4);
		resources.put(r5.getValue(), r5);
		
		
	}
	
}