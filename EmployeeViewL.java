
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
