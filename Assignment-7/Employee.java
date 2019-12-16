

import java.util.*;
public class Employee extends Person {

	private double salary;
	private Calendar hireDate;
	private Department department;
	private static int numberofEmployees;
	
	
	public Employee() { // No arg constructor.
		
		
	}
	
	public Employee( int id , String firstName, String lastName,  
			        String gender,Calendar birthDate, String maritalStatus, String hasDriverLicence,
			        double salary, Calendar hireDate, Department department) throws Exception { // Creating constructors from super class.
		
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		this.setHireDate(hireDate);
		this.setDepartment(department);
		this.salary = salary;
		Employee.setNumberofEmployees(Employee.getNumberofEmployees()+ 1);
		
	}
	
	public Employee(Person person , double salary ,Calendar hireDate ,Department department) throws Exception { // Creating overloaded constructors from super class.
		
		super.setId(person.getId());
		super.setFirstName(person.getFirstName());
		super.setLastName(person.getLastName());
		super.setGender(person.getGender());
		super.setBirthdate(person.getBirthdate());
		super.setMaritalStatus(person.getMaritalStatus());
		super.setHasDriverLicense(person.getHasDriverLicense());
		this.salary = salary;
		this.setHireDate(hireDate);
		this.setDepartment(department);
		Employee.setNumberofEmployees(Employee.getNumberofEmployees()+ 1);
	}
	
	public double raiseSalary(double percent) { /* raiseSalary method takes an double parameter and 
		                                         it raises the employee's salary after multiplication of salary and it's parameter*/
		
		double percentageMoney = this.salary * percent;
				
		return this.salary += percentageMoney;
	}
	
	public double raiseSalary(int amount) {// raiseSalary method takes an integer parameter and it raises the employee's salary by the given parameter.
		
		
		return this.salary += amount;
		
	}
	public double getSalary() {
		
		
		return this.salary;
		
	}
	
	//Creating getter and setter methods for all data fields.
	public void setSalary(double salary) {
		
		
		this.salary = salary;
		
	}

	public Calendar getHireDate() {
		
		return hireDate;
		
	}

	public void setHireDate(Calendar hireDate) {
		
		this.hireDate = hireDate;
		
	}

	public Department getDepartment() {
		
		return department;
		
	}

	public void setDepartment(Department department) {
		
		this.department = department;
		
	}

	public static int getNumberofEmployees() {
		
		return numberofEmployees;
		
	}
	
	public static void setNumberofEmployees(int numberofEmployees) {
		
		Employee.numberofEmployees = numberofEmployees;
		
	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		int Hireday = hireDate.get(5) ; // Getting the day from the calendar.
		int Hiremonth = hireDate.get(2) + 1; // Getting the month from the calendar.
 		int Hireyear = hireDate.get(1); //Getting the year form the calendar.
		return "[salary=" + salary + ", hireDate=" + Hireday + "/" + Hiremonth + "/" + Hireyear + "]";
	}
	
	
}
