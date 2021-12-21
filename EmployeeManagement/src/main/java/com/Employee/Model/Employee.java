package com.Employee.Model;

public class Employee {

	protected int id;
	protected String name;
	protected String email;
	protected String country;
	
	public Employee() {
		
	}
	
	public Employee(String name, String email, String countrty) {
		super();
		this.name = name;
		this.email = email;
		this.country = countrty;
	}
	
	public Employee(int id, String name, String email, String country) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmial(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static void add(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	
}
