package com.role.driver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.role.memory.InMemoryDb;
import com.role.model.Action;
import com.role.model.Resource;
import com.role.model.Role;
import com.role.model.User;
import com.role.service.FunctionalImpl;
import com.role.service.IFunctional;

public class Main {

	public static void main(String[] args) throws IOException {
		InMemoryDb.memoryInitialization();
		
		IFunctional actions = new FunctionalImpl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Display Menu:");
		System.out.println("1:ADD_USER");
		System.out.println("2:ADD_USER_WITH_ROLE");
		System.out.println("3:ADD_ROLE_TO_USER");
		System.out.println("4:REMOVE_ROLE_FROM_USER");
		System.out.println("5:ACCESS_CHECK");
		
		String s="";
		while((s=br.readLine())!=null) {
			if(s.equalsIgnoreCase("exit"))
				break;
			
			switch(s) {
			
			case "1":
				System.out.println("Enter user name");
				User user1 = new User();
				user1.setName(br.readLine());
				actions.addUser(user1);
				break;
				
			case "2":
				System.out.println("Enter user name");
				User user2 = new User();
				user2.setName(br.readLine());
				System.out.println("Select role name");
				InMemoryDb.displayRoleList();
				Role role1 = InMemoryDb.roles.get(br.readLine());
				actions.addUser(user2,role1);
				break;
				
			case "3":
				System.out.println("Enter user name");
				User user3 = InMemoryDb.users.get(br.readLine());
				System.out.println("Select role name");
				InMemoryDb.displayRoleList();
				Role role2 = InMemoryDb.roles.get(br.readLine());
				actions.addRoleToUser(user3,role2);
				break;
				
			case "4":
				System.out.println("Enter user name");
				User user4 = InMemoryDb.users.get(br.readLine());
				System.out.println("Select role name");
				InMemoryDb.displayRoleList();
				Role role3 = InMemoryDb.roles.get(br.readLine());
				actions.removeRoleFromUser(user4,role3);
				break;
				
			case "5":
				System.out.println("Enter user name");
				User user5 = InMemoryDb.users.get(br.readLine());
				System.out.println("Select resource name");
				InMemoryDb.displayResourceList();
				Resource resource = InMemoryDb.resources.get(br.readLine());
				System.out.println("Select action name");
				Action.displayActions();
				Action action= Action.valueOf(br.readLine());
				System.out.println(actions.accessCheck(user5,action,resource));
				break;
				
			default:
//				s="exit";
				
			}
		}
	}	
	
}