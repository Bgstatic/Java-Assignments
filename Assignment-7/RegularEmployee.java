

import java.util.*;

public class RegularEmployee extends Employee {
   
	private double performanceScore;
	private double bonus;
	
	
	public RegularEmployee() {
		
		super();
	}
	
	public RegularEmployee(int id, String firstName, String lastName, String gender, 
		   Calendar birthDate, String maritalStatus, String hasDriverLicence, 
		   double salary, Calendar hireDate, Department department, double performanceScore) throws Exception { // Creating constructors from super class.
		
		super(id , firstName , lastName , gender , birthDate , maritalStatus , hasDriverLicence , salary , hireDate, department);
		this.setPerformanceScore(performanceScore);
		
	}
	
	public RegularEmployee(Employee employee, double perfScore) throws Exception { // Creating overloaded constructors from super class.
		
		super.setId(employee.getId());
		super.setFirstName(employee.getFirstName());
		super.setLastName(employee.getLastName());
		super.setGender(employee.getGender());
		super.setBirthdate(employee.getBirthdate());
		super.setMaritalStatus(employee.getMaritalStatus());
		super.setHasDriverLicense(employee.getHasDriverLicense());
		super.setSalary(employee.getSalary());
		super.setHireDate(employee.getHireDate());
        super.setDepartment(employee.getDepartment());	
        
		this.setPerformanceScore(perfScore);
	}

	
    
	//Creating getter and setter methods for all data fields.
	public double getPerformanceScore() {
		
		return performanceScore;
		
	}

	public void setPerformanceScore(double performanceScore) {
		
		this.performanceScore = performanceScore;
		
	}

	public double getBonus() {
		
		return bonus;
		
	}

	public void setBonus(double bonus) {
		
		this.bonus = bonus;
		
	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		
		return "RegularEmployee [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
	}
	
}
