package com.role.model;

public class Resource {
	
	/*RES1("resource1"),
	RES2("resource2"),
	RES3("resource3"),
	RES4("resource4");*/
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Resource(String value) {
		this.value=value;
	}
}