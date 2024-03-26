package com.kral;

import java.time.LocalDate;

public class Employee {
	private int id;
	private String name;
	//private int age;
	private LocalDate dob;
	private EmployeeType et;
	
	public Employee(int id, String name, LocalDate dob, EmployeeType et) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.et = et;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setType(EmployeeType et) {
		this.et = et;
	}
	public EmployeeType getType() {
		return et;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDate getDob() {
		return dob;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
	
	

}
