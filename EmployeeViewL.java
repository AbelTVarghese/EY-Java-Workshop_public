package com.kral;

import java.util.Scanner;
import java.util.function.Consumer;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;

public class EmployeeView {

	private Scanner scanner = new Scanner(System.in);
	private int empCount = 4;
	//private int empId = 4;
	List <Employee> employees;
	//private Employee[] employees = new Employee[50];
	Set<Employee> names = new HashSet<>();
	File file = new File("EmployeeData.ser");
	private int count = 0;
	{
		Employee employee1 = new Employee(1, "nausha", LocalDate.of(1972,12,30), EmployeeType.CEO, "Naushad1", true);
		Employee employee2 = new Employee(2, "akhtar", LocalDate.of(1999,07,21), EmployeeType.MANAGER, "akhtar2", true);
		Employee employee3 = new Employee(3, "ravi", LocalDate.of(1995,07,15), EmployeeType.DEVELOPER,"ravi3", false);
		Employee employee4 = new Employee(4, "Roy", LocalDate.of(2001,01,01), EmployeeType.CTO,"Roy4",false);
//		employees[0] = employee1;
//		employees[1] = employee2;
//		employees[2] = employee3;
//		employees[3] = employee4;
	
		
		names.add(employee1);
		names.add(employee2);
		names.add(employee3);
		names.add(employee4);
		//names.add(employee1);
		
		employees = new ArrayList<>(Arrays.asList(employee1, employee2, employee3, employee4));
		
		Consumer<Employee> consumer = new Consumer<Employee>() {

			@Override
			public void accept(Employee t) {
				System.out.println(t);			
			}
		};
		
		Consumer<Employee> consumer1 = t-> System.out.println(t);
		employees.forEach(consumer);
		employees.forEach(consumer1);
	}

	public EmployeeView() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("Employee Management System");
		deserialize();
//		System.out.println("Test");
		while (true) {
			System.out.println("Entering Main Options");
			mainOptions();
			System.out.println("End of some option");
		}
	}
	

	//@SuppressWarnings("unchecked")
	private void mainOptions() throws FileNotFoundException, ClassNotFoundException, IOException {
//		System.out.println("Enter the option from below");
//		System.out.println("1. User login");
//		System.out.println("2. New user registration");
//		int userOption = scanner.nextInt();
		
	//	switch(userOption) {
		
		//case 1: {
			System.out.println("Enter User Id");
			int userId = scanner.nextInt();
			System.out.println("Enter Password");
			String passWord = scanner.next();
			
			Boolean isAdmin = userAuth(userId, passWord);
		//}
		
//		case 2:{
//			System.out.println("Enter Username");
//			String userName = scanner.next();
//			System.out.println("Enter Password");
//			String passWord = scanner.next();
//			
//			userRegistration(userName, passWord);
//			
//			System.out.println("New user Registered");
//			mainOptions();
//		}
	//	}
//		System.out.println("Enter Username");
//		String userName = scanner.next();
//		System.out.println("Enter Password");
//		String passWord = scanner.next();
//		
//		Boolean isAdmin = userAuth(userName, passWord);
		if(isAdmin) {	
		System.out.println("Enter the option from below : ");
		System.out.println("1. Add Employee");
		System.out.println("2. Display All Employee");
		System.out.println("3. Display Employee with id :");
		System.out.println("4. Update Employee");
		System.out.println("5. Delete Employee");
		System.out.println("6. Display Employee by Type :");
		System.out.println("7. Display Employee by date of birth :");
		System.out.println("8. Exit Application");
		
//		if(count != 0) {
//			try(FileInputStream fir = new FileInputStream("EmployeeData.ser");
//					ObjectInputStream ois = new ObjectInputStream(fir)){
//				
//				Object object = ois.readObject();
//				employees = (Employee[]) object;
//				names = (Set<Employee>) object;
//			}
//			
//			} else {
//			count ++;
//		}
		
		int option = scanner.nextInt();
		switch (option) {
		case 1: {
			addEmployees();
			System.out.println("add employee completeed");
			return;
		}
		case 2: {
			displayEmployees();
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
			serialize();
			System.err.println("End of Application.....");
			System.err.println("Thanks for using the Application.....");
			System.exit(0);
		}
		default:
			System.out.println("Please Select Proper Option");
		}}
		else {
			System.out.println("Enter the option from below : ");
			//System.out.println("1. Add Employee");
			System.out.println("1. Display All Employee");
		//	System.out.println("3. Display Employee with id :");
			System.out.println("2. Update Employee");
			
			int empOption = scanner.nextInt();
			switch(empOption) {
			case 1 :{
				displayOneEmployee(userId);
			}
			
			case 2 :{
				updateOneEmployee(userId);
			}
			}
		}
	}
	
	private void updateOneEmployee(int userId) {
		for(Employee emp: employees) {
			if(emp.getId() == userId) {
				System.out.println("Enter Employee Name: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Enter Employee Date of Birth in format dd/MM/yyyy ");
				String dateOfBirth = scanner.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateOfBirth, formatter);
				
//				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
//				Date date1 = format.parse(dateOfBirth);
				
				System.out.println("Enter Employee Type: CEO/CTO/DEVELOPER/MANAGER ");
//				scanner.nextLine();
				String type = scanner.nextLine();
				
				System.out.println("Enter new password");
				String password = scanner.nextLine();
				
				
				EmployeeType enumType = EmployeeType.valueOf(type);
				
				emp.setName(name);
				emp.setDob(date);
				emp.setType(enumType);
				emp.setPassword(password);
				System.out.println("Employee with id "+userId+" is updated");
			}
			}
	}
	
	private void displayOneEmployee(int userId) {
		for(Employee emp: employees) {
			if(emp.getId() == userId) {
			System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDob()+" : "+Period.between(emp.getDob(),LocalDate.now()).getYears()+" : "+emp.getType());
		}
			}
	}
	
//	private void userRegistration(String username, String password) {
//		
//	}
	
	private boolean userAuth(int userId, String password) {
		boolean correctPass= false;
		boolean isAdmin = false;
		
		for(Employee em: employees) {
			if((em.getId() == userId) && (em.getPassword() == password)) {
				correctPass = true;
				if(em.checkAdmin()) {
					isAdmin = true;
				}
			}
		}
		
		if(correctPass == false) {
			System.err.println("User nor registered");
			System.exit(0);
		}
		return isAdmin;
	}
	
	@SuppressWarnings("unchecked")
	private void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		try(FileInputStream fis = new FileInputStream("employeebasket.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);){
			
			Object object = ois.readObject();
			 employees = (List<Employee>)object;
			
			} 
	}
	
	private void serialize() throws IOException{
		
		File file = new File("employeebasket.txt");
		try(FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);){
			
			oos.writeObject(employees);
			System.out.println("Employee data added to Employee-Basket");
		}
		
	}

	
	private void displayEmployeeByAge() {
		
		System.out.println("Enter the Age");
		scanner.nextLine();
		int empAge = scanner.nextInt();
		
		System.out.println(":-----------------------------------------------------------------------:");
		System.out.println("Id\t:\tName\t:\t\tDOB:\t\t\tType:");
		System.out.println(":-----------------------------------------------------------------------:");
		
		
		for(Employee em: employees) {
			
		
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
			for(Employee em: employees) {
				if(em.getType() == etIn) {
			
				System.out.println(em.getId() + "   \t\t" + em.getName() + "\t\t" + em.getDob() + "\t\t" + em.getType());
			}
		}
		System.out.println(":-----	-------------------------------------------------------------------:");
	}
	

	private void addEmployees() throws FileNotFoundException, IOException, ClassNotFoundException {
		boolean ans = true;
		do {
		System.out.println("Enter Employee id: ");
		int id = scanner.nextInt();
		
		
		try {
			//boolean exist=false;
			for(Employee emp : employees) {
				if(id == emp.getId()) {
					//System.out.println("Sorry Employee Id already exist...");
					//exist = true;
					throw new EmployeeIdAlreadyExistException("The Employee Id entered is already exist in data");
				}
			}
				
				//if(!exist) {
					System.out.println("Enter Employee Name: ");
					scanner.nextLine();
					String name = scanner.nextLine();
					System.out.println("Enter Employee Date of Birth in the format dd/MM/yyyy");
					String dateOfBirth = scanner.nextLine();
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate date = LocalDate.parse(dateOfBirth, formatter);
					
					System.out.println("Enter Employee Type: CEO/CTO/DEVELOPER/MANAGER ");
//					scanner.nextLine();
					String type = scanner.nextLine();
					
					System.out.println("Enter temp password");
					String tempPass = scanner.nextLine();
					
					System.out.println("Enter is admin 1: Admin, 2: Normal");
					int isAdminInt = scanner.nextInt();
					
					boolean isAdmin = false;
					if(isAdminInt == 1 ) {
						isAdmin = true;
					}
					EmployeeType enumType = EmployeeType.valueOf(type);
					
					
					
					Employee employee1 = new Employee(id,name,date,enumType,tempPass, isAdmin);
				
					employees.add(employee1);
					//employees[empCount] = employee;
					//empCount++;
					System.out.println("Employee added");
					
				//}
		}
		catch(EmployeeIdAlreadyExistException e) {
			
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		
				
			
		
		
		System.out.println("Do you want to continue adding employee: y/n? ");
		String ansInput = scanner.next();
		
		
		if(!ansInput.equalsIgnoreCase("y")) {
			ans = false;
		}
		}while(ans);
		System.out.println("=============================================");
		return;
		
	}
	
	
	private void updateEmployee() {
		System.out.println("Enter employee id");
		int empId = scanner.nextInt();
		
		Employee findEmployee = null;
		for(Employee emp : employees) {
			if(empId == emp.getId()) {
				
				findEmployee = emp;
				break;
			}
		}
				//System.out.println("Sorry Employee Id already exist...");
				
		
			
			if(findEmployee != null) {
				
				
				System.out.println("Enter Employee Name: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.println("Enter Employee Date of Birth in format dd/MM/yyyy ");
				String dateOfBirth = scanner.nextLine();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(dateOfBirth, formatter);
				
//				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
//				Date date1 = format.parse(dateOfBirth);
				
				System.out.println("Enter Employee Type: CEO/CTO/DEVELOPER/MANAGER ");
//				scanner.nextLine();
				String type = scanner.nextLine();
				
				EmployeeType enumType = EmployeeType.valueOf(type);
				
				findEmployee.setName(name);
				findEmployee.setDob(date);
				findEmployee.setType(enumType);
				System.out.println("Employee with id "+empId+" is updated");
				
				
			}
			
			return;
	}
	
	private void deleteEmployee() {
		System.out.println("Enter employee id");
		int empId = scanner.nextInt();
		
		for(Employee emp: employees) {
			
			if(emp.getId() == empId) {
				
				employees.remove(emp);
				//empCount--;
				break;
			}
		}
		for(Employee emp: employees) {
			System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDob()+" : "+Period.between(emp.getDob(),LocalDate.now()).getYears()+" : "+emp.getType());
		}
		
		return;
	}

	private void displayEmployees() {
System.out.println("============================");
		
		for(Employee emp : employees) {
			
			System.out.println(emp.getId()+" : "+emp.getName()+" : "+emp.getDob()+" : "+Period.between(emp.getDob(),LocalDate.now()).getYears()+" : "+emp.getType());
			
		
		}
		System.out.println("============================");
}
}
