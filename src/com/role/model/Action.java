package com.role.model;

public enum Action {
	
	READ,WRITE,DELETE;

	public static void displayActions() {
		Action[] arr = Action.values();
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+". "+arr[i]);
		}
	}
}