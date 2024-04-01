package com.kral;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Serializable{
	
	private static final long serialVersionUID = -9004916547179581980L;
	private int id;
	private String name;
	//private int age;
	private LocalDate dob;
	private EmployeeType et;
	private String password;
	private boolean isAdmin;
	
	public Employee(int id, String name, LocalDate dob, EmployeeType et, String password, boolean isAdmin) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.et = et;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public boolean checkAdmin() {
		return isAdmin;
	}
	
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}

//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
	
	

}
