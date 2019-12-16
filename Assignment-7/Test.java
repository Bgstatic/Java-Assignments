

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Test {
	
	// Bilgehan Ge�ici - 150117072
	
	/*This program creates a new .txt file by the given input file which is a txt file. In other words this program takes a input file and then it
	 creates new output file based on input file's instructors.*/

	public static void main(String[] args) throws Exception { // Main method

		File file = new File("input.txt"); // Creating a new file.

		Scanner input = new Scanner(file); // Scanning the file.

		ArrayList<Department> departmentList = new ArrayList<Department>(); // departmentList for department objects
		ArrayList<Project> projectList = new ArrayList<Project>(); // projectList for project objects.
		ArrayList<Product> productList = new ArrayList<Product>(); // producList for product objects.
		ArrayList<Person> personList = new ArrayList<Person>(); // personList for person objects.
		ArrayList<Employee> employeeList = new ArrayList<Employee>(); // employeeList for employee objects.
		ArrayList<Manager> managerList = new ArrayList<Manager>(); // managerList for manager objects.
		ArrayList<RegularEmployee> RegularEmployeeList = new ArrayList<RegularEmployee>(); // RegularEmployeeList for regularEmployee objects.
		ArrayList<Developer> developerList = new ArrayList<Developer>(); // developerList for developer objects.
		ArrayList<Customer> customerList = new ArrayList<Customer>(); // customerList for customer objects.
		ArrayList<SalesEmployee> salesEmployeeList = new ArrayList<SalesEmployee>(); // salesEmployeeList for salesEmployee objects.

		Calendar calendar = new GregorianCalendar(0, 0, 0); // Creating a new calendar and set the date to 0.

		while (input.hasNext()) { // Scanning the input file input by input.

			String className = input.next(); // Scanning the class name from file

			switch (className) {

			case "Department": // Creating department objects

				int DepartmentId = input.nextInt();
				String departmentName = input.next();
				Department department = new Department(DepartmentId, departmentName);

				departmentList.add(department); // add the objects to the list.

				break;

			case "Project": // Creating project objects

				String projectDepartment = input.next();
				String dateP = input.next();
				String statusP = input.next();
				calendar = new GregorianCalendar(0, 0, 0);
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateP.substring(0, 2))); // Setting the day
				calendar.set(Calendar.MONTH, Integer.parseInt(dateP.substring(3, 5)) - 1); // Setting the month
				calendar.set(Calendar.YEAR, Integer.parseInt(dateP.substring(6))); // Setting the year
				
				Project project = new Project(projectDepartment, calendar, statusP);
				
				projectList.add(project); // add the objects to the list.

				break;

			case "Product": // Creating product objects

				String productName = input.next();
				String datePr = input.next();
				double price = input.nextDouble();
				calendar = new GregorianCalendar(0, 0, 0);
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(datePr.substring(0, 2))); // Setting the day
				calendar.set(Calendar.MONTH, Integer.parseInt(datePr.substring(3, 5)) - 1);// Setting the month
				calendar.set(Calendar.YEAR, Integer.parseInt(datePr.substring(6)));// Setting the year
				Product product = new Product(productName, calendar, price);
				
				productList.add(product);// add the objects to the list.

				break;

			case "Person":// Creating project objects

				String firstName = input.next();
				String lastName = input.next();
				int PersonId = input.nextInt();
				String gender = input.next();
				String datePer = input.next();
				String maritalStatus = input.next();
				String drivingStatus = input.next();
				calendar = new GregorianCalendar(0, 0, 0);
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(datePer.substring(0, 2)));// Setting the day 
				calendar.set(Calendar.MONTH, Integer.parseInt(datePer.substring(3, 5)) - 1);// Setting the month
				calendar.set(Calendar.YEAR, Integer.parseInt(datePer.substring(6)));// Setting the year
				Person person = new Person(PersonId, firstName, lastName, gender, calendar, maritalStatus,
						drivingStatus);
				personList.add(person);// add the objects to the list.

				break;

			case "Employee":// Creating employee objects

				int employeeId = input.nextInt();
				int employeeSalary = input.nextInt();
				String EmployeeHireDate = input.next();
				String EmployeeDepartment = input.next();
				calendar = new GregorianCalendar(0, 0, 0);
				calendar.set(Calendar.YEAR, Integer.parseInt(EmployeeHireDate.substring(6)));// Setting the day
				calendar.set(Calendar.MONTH, Integer.parseInt(EmployeeHireDate.substring(3, 5)) - 1);// Setting the month
				calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(EmployeeHireDate.substring(0, 2)));// Setting the year

				Department TempDepartmentName = null;
				Person TempEmployeePerson = null;

				for (int i = 0; i < departmentList.size(); i++) {
					if (departmentList.get(i).getDepartmentName().equalsIgnoreCase(EmployeeDepartment)) {
						TempDepartmentName = departmentList.get(i);

						for (int j = 0; i < personList.size(); j++) {
							if (personList.get(j).getId() == employeeId) {
								TempEmployeePerson = personList.get(j);
								Employee employee = new Employee(TempEmployeePerson, employeeSalary, calendar,
										TempDepartmentName);
								employeeList.add(employee);// add the objects to the list.

								break;
							} else if (i == personList.size() - 1) {

								throw new Exception("Persons does not have same elements with Employee class");

							}
						}

						break;
					} else if (i == departmentList.size() - 1) {

						throw new Exception("Departments does not have same elements with Employee class");

					}
				}

				break;

			case "RegularEmployee": // Creating regular employee objects
				int RegularEmployeeId = input.nextInt();
				int perfScore = input.nextInt();
				Employee TempEmployee = null;

				for (int i = 0; i < employeeList.size(); i++) {
					if (employeeList.get(i).getId() == RegularEmployeeId) {

						TempEmployee = employeeList.get(i);
						RegularEmployee regularEmployee = new RegularEmployee(TempEmployee, perfScore);
						RegularEmployeeList.add(regularEmployee);// add the objects to the list.

						break;
					} else if (i == employeeList.size() - 1) {

						throw new Exception(
								"Employee Class does not have the same elements with RegularEmployee Class");

					}

				}

				break;

			case "Developer":
				String developerLine = input.nextLine();
				String[] stringLineList = developerLine.split(" ");
				int developerId = Integer.parseInt(stringLineList[1]);
				RegularEmployee TempRegularEmployee = null;
				ArrayList<Project> TempProject = new ArrayList<Project>();
				Developer developer = null;

				for (int i = 0; i < RegularEmployeeList.size(); i++) {
					if (developerId == RegularEmployeeList.get(i).getId()) {
						TempRegularEmployee = RegularEmployeeList.get(i);
						developer = new Developer(TempRegularEmployee, TempProject);
						developerList.add(developer);
						break;
					} else if (i == RegularEmployeeList.size() - 1) {
						throw new Exception("RegularEmployee class does not have same elements with Developer class");
					}
				}

				for (int i = 2; i < stringLineList.length; i++) {
					for (int j = 0; j < projectList.size(); j++) {
						if (stringLineList[i].equals(projectList.get(j).getProjectName())) {
							TempProject.add(projectList.get(j));
							developer.setProjects(TempProject);
							break;
						} else if (j == projectList.size() - 1)
							throw new Exception("Project class does not have same elements with Developer class");
					}

				}

				break;
			case "Customer":// Creating customer objects

				String customerLine = input.nextLine();
				stringLineList = customerLine.split(" ");
				int customerId = Integer.parseInt(stringLineList[1]);
				Person TempPerson = null;
				ArrayList<Product> TempCustomerProject = new ArrayList<Product>();
				Customer customer = null;

				for (int i = 0; i < personList.size(); i++) {
					if (customerId == personList.get(i).getId()) {

						TempPerson = personList.get(i);
						customer = new Customer(TempPerson, TempCustomerProject);
						customerList.add(customer); // add the objects to the list.
						break;
					} else if (i == personList.size() - 1)
						throw new Exception("Person Class does not have same elements with Person");
				}

				for (int i = 2; i < stringLineList.length; i++) {
					for (int j = 0; j < productList.size(); j++) {
						if (stringLineList[i].equals(productList.get(j).getProductName())) {
							TempCustomerProject.add(productList.get(j));
							customer.setProducts(TempCustomerProject);
							break;
						} else if (j == productList.size() - 1)
							throw new Exception("This product does not have any elements in ProductList");
					}
				}
				break;
			case "Manager":// Creating manager objects

				int managerId = input.nextInt();
				int managerBonusBudget = input.nextInt();
				Manager TempManager = null;

				for (int i = 0; i < employeeList.size(); i++) {
					if (employeeList.get(i).getId() == managerId) {
						TempManager = new Manager(employeeList.get(i), managerBonusBudget);
						managerList.add(TempManager); // add the objects to the list.
						break;
					} else if (i == employeeList.size() - 1)
						throw new Exception("Manager Class does not have same elements with EmployeeList");

				}

				break;

			case "SalesEmployee": // Creating sales employee objects.

				String SalesEmployeeLine = input.nextLine();
				stringLineList = SalesEmployeeLine.split(" ");
				int SalesEmployeeId = Integer.parseInt(stringLineList[1]);
				ArrayList<Product> TempSalesEmployeeProductList = new ArrayList<Product>();

				RegularEmployee TempRegEmp = null;
				SalesEmployee salesEmployee = null;

				for (int i = 0; i < RegularEmployeeList.size(); i++) {
					if (RegularEmployeeList.get(i).getId() == SalesEmployeeId) {
						TempRegEmp = RegularEmployeeList.get(i);
						break;
					} else if (i == RegularEmployeeList.size() - 1) {
						throw new Exception("SalesEmployee  Class does not have same elements in RegularEmployeeList");

					}
				}

				for (int i = 2; i < stringLineList.length; i++) {
					for (int j = 0; j < productList.size(); j++) {
						if (stringLineList[i].equals(productList.get(j).getProductName())) {
							TempSalesEmployeeProductList.add(productList.get(j));
							salesEmployee = new SalesEmployee(TempRegEmp, TempSalesEmployeeProductList);
							salesEmployeeList.add(salesEmployee);  // add the objects to the list
							break;
						} else if (j == productList.size() - 1) {
							throw new Exception("Product does not have any elements in ProductList");
						}
					}
				}

				break;

			default:

				throw new Exception("Invalid type of class name ");
			}
		}
		for (int i = 0; i < managerList.size(); i++) { // Invoking distributeBonusBudget method and raiseSalary for all manager objects

			managerList.get(i).distributeBonusBudget();
			managerList.get(i).raiseSalary(0.2);
		}
		for (int i = 0; i < RegularEmployeeList.size(); i++) { // Invoking raiseSalary method for all RegularEmployee objects.

			RegularEmployeeList.get(i).raiseSalary(0.3);
		}
		for (int i = 0; i < salesEmployeeList.size(); i++) { // Invoking raiseSalary method for all sales employee objects

			salesEmployeeList.get(i).raiseSalary(0.18);
			salesEmployeeList.get(i).raiseSalary(1000);
		}

		File outputFile = new File("output.txt"); // Creating a new file named output.

		if (outputFile.exists()) { // Checks if it exists.

			System.out.println("File already exists");
			System.exit(0);
		}
 
		// Printing the all objects and their toString methods to output file.
		PrintWriter output = new PrintWriter(outputFile);
		output.println("************************************************");
		for (int i = 0; i < managerList.size(); i++) {

			output.println(departmentList.get(i).toString());
			output.println("************************************************");
			output.println("\t" + managerList.get(i).toString() + "\t" + "1. Developer" + "\t" + "Person info" +

					personList.get(i).toString() + "\t" + "Employee info" + employeeList.get(i).toString()
					+ "			" + RegularEmployeeList.get(i).toString() + "\t" + projectList.get(i).toString() + "\t"
					+ "2. SalesEmployee" + "\t" + personList.get(i + 1).toString() + "\t" + "Employee info"
					+ employeeList.get(i + 1).toString() + "\t" + "3. RegularEmployee"
					+ personList.get(i + 2).toString() + "\t" + "Employee info" + employeeList.get(i + 2) + "\t"
					+ productList.get(i).toString() + "\t" + RegularEmployeeList.get(i + 1).toString());

		}
		output.println("**********************CUSTOMERS************************");

		for (int i = 0; i < customerList.size(); i++) {

			output.println(customerList.get(i).toString());
		}
		output.println("**********************PEOPLE************************");

		for (int i = 0; i < customerList.size(); i++) {

			output.println("Person" + personList.get(i).toString());
		}

		output.close();

	}
}
