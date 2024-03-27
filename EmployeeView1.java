package com.kral;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;

public class EmployeeView {

	private Scanner scanner = new Scanner(System.in);
	private int empCount = 4;
	//private int empId = 4;
	private Employee[] employees = new Employee[50];
	Set<Employee> names = new HashSet<>();
	{
		Employee employee1 = new Employee(1, "nausha", LocalDate.of(1972,12,30), EmployeeType.CEO);
		Employee employee2 = new Employee(2, "akhtar", LocalDate.of(1999,07,21), EmployeeType.MANAGER);
		Employee employee3 = new Employee(3, "ravi", LocalDate.of(1995,07,15), EmployeeType.DEVELOPER);
		Employee employee4 = new Employee(4, "Roy", LocalDate.of(2001,01,01), EmployeeType.CTO);
		employees[0] = employee1;
		employees[1] = employee2;
		employees[2] = employee3;
		employees[3] = employee4;
		
		
		names.add(employee1);
		names.add(employee2);
		names.add(employee3);
		names.add(employee4);
		//names.add(employee1);
	}

	public EmployeeView() {
		System.out.println("Employee Management System");
		while (true) {
			System.out.println("Entering Main Options");
			mainOptions();
			System.out.println("End of some option");
		}
	}

	private void mainOptions() {
		System.out.println("Enter the option from below : ");
		System.out.println("1. Add Employee");
		System.out.println("2. Display All Employee");
		System.out.println("3. Display Employee with id :");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Display Employee by Type :");
		System.out.println("7. Display Employee by date of birth :");
		System.out.println("8. Exit Application");
		int option = scanner.nextInt();
		switch (option) {
		case 1: {
			addEmployees();
			System.out.println("add employee completeed");
			return;
		}
		case 2: {
			displayEmployees(employees);
			return;
		}
		case 4 :{
			updateEmployee();
			return;
		}
		case 5 : {
			deleteEmployee();
			return;
		}
		case 6:{
			displayByType();
			return;
		}
		case 7:{
			displayEmployeeByAge();
			return;
		}
		case 8: {
			System.err.println("End of Application.....");
			System.err.println("Thanks for using the Application.....");
			System.exit(0);
		}
		default:
			System.out.println("Please Select Proper Option");
		}
	}
	
	private void displayEmployeeByAge() {
		
		System.out.println("Enter the Age");
		scanner.nextLine();
		int empAge = scanner.nextInt();
		
		System.out.println(":-----------------------------------------------------------------------:");
		System.out.println("Id\t:\tName\t:\t\tDOB:\t\t\tType:");
		System.out.println(":-----------------------------------------------------------------------:");
		
		
		for (int i = 0; i < empCount; i++) { 
			Employee em = employees[i];
			
		
				Period period = Period.between(em.getDob(),LocalDate.now());
				int year = period.getYears();
				
				if(year > empAge) {
					
					System.out.println(em.getId() + "   \t\t" + em.getName() + "\t\t" + em.getDob() + "\t\t" + em.getType());
				
				
			}
		}
		System.out.println(":------------------------------------------------------------------------:");
		
		
		
		
	}
	
//	private void displayByDob() {
//		System.out.println("Enter the date (less than or equal) to search: ");
//		String inDob = scanner.nextLine();
//		CharSequence charDob = (String) inDob;
//		for (int i = 0; i < empCount; i++) { 
//			Employee em = employees[i];
//			LocalDate emDob = em.getDob();
//			DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-mm-yyyy");
//			LocalDate date = LocalDate.parse(emDob,dt);
//			LocalDate dateIn = LocalDate.parse(charDob,dt);
//			int compareInt = date.compareTo(dateIn);
//			if(compareInt <= 0) {
//				System.out.println(":-----------------------------------------------------------------------:");
//				System.out.println("Id\t:\tName\t:\tAge:\t\tType:");
//				System.out.println(":-----------------------------------------------------------------------:");
//				
//					System.out.println(em.getId() + "   \t\t" + em.getName() + "\t\t" + em.getDob() + "\t\t" + em.getType());
//
//			}
//			System.out.println(":------------------------------------------------------------------------:");
//			}
//		}
//	
	
	private void displayByType() {
		
		System.out.println("Enter Employee Type: 1:CEO \t 2:CTO \t 3.MANAGER \t 4.DEVELOPER  ");
		int type = scanner.nextInt();
		EmployeeType etIn = EmployeeType.DEVELOPER;
		if(type == 1) {
			etIn = EmployeeType.CEO;
		}else if(type == 2) {
			etIn = EmployeeType.CTO;
		}else if (type ==3) {
			etIn = EmployeeType.MANAGER;
		}else if(type == 4) {
			etIn = EmployeeType.DEVELOPER;
		}else {
			System.out.println("Enter the given options only");
		}
		
			System.out.println(":-----------------------------------------------------------------------:");
			System.out.println("Id\t:\tName\t:\tDOB:\t\tType:");
			System.out.println(":-----------------------------------------------------------------------:");
			for (int i = 0; i < empCount; i++) { 
				Employee em = employees[i];
				if(em.getType() == etIn) {
			
				System.out.println(em.getId() + "   \t\t" + em.getName() + "\t\t" + em.getDob() + "\t\t" + em.getType());
			}
		}
		System.out.println(":-----	-------------------------------------------------------------------:");
	}
	

	private void addEmployees() {
		boolean ans = true;
		do {
			System.out.println("Enter Employee Id : ");
			int id = scanner.nextInt();
			System.out.println("Enter Employee Name : ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.println("Enter Employee Date of Birth: ");
			String dateOfBirth = scanner.nextLine();
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(dateOfBirth, formatter);
			System.out.println("Enter Employee Type: 1:CEO \t 2:CTO \t 3.MANAGER \t 4.DEVELOPER  ");
			int type = scanner.nextInt();
			EmployeeType etIn = EmployeeType.DEVELOPER;
			if(type == 1) {
				etIn = EmployeeType.CEO;
			}else if(type == 2) {
				etIn = EmployeeType.CTO;
			}else if (type ==3) {
				etIn = EmployeeType.MANAGER;
			}else if(type == 4) {
				etIn = EmployeeType.DEVELOPER;
			}else {
				System.out.println("Enter the given options only");
			}
			Employee employee = new Employee(id, name, date, etIn);
			
			
			if(names.contains(employee) == true) {
				System.err.println("Enter another employee id");
				addEmployees();
			}
			
			employees[empCount] = employee;
			names.add(employee);
			empCount++;
			System.out.println("Employees Added....");
			System.out.println("Do you want to continue..... y/n");
			String input = scanner.next();
			if (!input.equalsIgnoreCase("y")) {
				ans = false;
			}
		} while (ans);
		return;
	}
	
	private void updateEmployee() {
		System.out.println("Enter Employee Id : ");
		int id = scanner.nextInt();
		System.out.println("Enter Employee Name : ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter Employee Date of Birth: ");
		String dateOfBirth = scanner.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateOfBirth, formatter);
		System.out.println("Enter Employee Type:\t\t  1:CEO \t 2:CTO \t 3.MANAGER \t 4.DEVELOPER  ");
		int type = scanner.nextInt();
		EmployeeType etIn = EmployeeType.DEVELOPER;
		if(type == 1) {
			etIn = EmployeeType.CEO;
		}else if(type == 2) {
			etIn = EmployeeType.CTO;
		}else if (type ==3) {
			etIn = EmployeeType.MANAGER;
		}else if(type == 4) {
			etIn = EmployeeType.DEVELOPER;
		}else {
			System.out.println("Enter the given options only");
		}
		for (int i = 0; i < empCount; i++) {
			Employee em = employees[i];
			if(em.getId() == id) {
				em.setName(name);
				em.setDob(date);
				em.setType(etIn);
			}
			}
	}
	
	private void deleteEmployee() {
		System.out.println("Enter Employee Id : ");
		int id = scanner.nextInt();
		for (int i = 0; i < empCount; i++) {
			Employee em = employees[i];
			if(em.getId() == id) {
				employees[i] = null;
				empCount--;
				for(int j =i; j< empCount; j++) {
					
				}
				System.out.println("Employee deleted with id:-" + id);
			}
		}
	}

	private void displayEmployees(Employee... employees) {
		if (employees.length != 0) {
			System.out.println(":--------------------------------------------------------------------:");
			System.out.println("Id\t:\tName\t:\tDOB:\t\tType:");
			System.out.println(":--------------------------------------------------------------------:");
		}
		for (Employee emp : employees) {
			if (emp != null) {
				System.out.println(emp.getId() + "   \t\t" + emp.getName() + "\t\t" + emp.getDob() + "\t\t" + emp.getType());
			}
		}
		System.out.println(":---------------------------------------------------------------------:");
	}
}
