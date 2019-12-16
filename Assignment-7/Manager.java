

import java.util.*;

public class Manager extends Employee {

	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	private double bonusBudget;

	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget)
			throws Exception {// Creating constructors from super class.

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate,
				department);

		this.bonusBudget = bonusBudget;

	}

	public Manager(Employee employee, double bonusBudget) throws Exception {// Creating overloaded constructors from super class.

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

		this.bonusBudget = bonusBudget;

	}
    
	//Creating getter and setter methods for all data fields.
	public ArrayList<RegularEmployee> getRegularEmployees() {

		return regularEmployees;

	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {

		this.regularEmployees = regularEmployees;

	}

	public double getBonusBudget() {

		return bonusBudget;

	}

	public void setBonusBudget(double bonusBudget) {

		this.bonusBudget = bonusBudget;

	}

	public Manager() throws Exception {

		super();

	}

	public void addEmployee(RegularEmployee e) { /*AddEmployee method adds the given regular employee object to the 
		                                          regularEmployees array list which is a data field in type of Array list.*/

		this.regularEmployees.add(e);

	}

	public void removeEmployee(RegularEmployee e) {// removeEmployeee method removes the given regular employee object from the array list.

		this.regularEmployees.remove(e);

	}

	public void distributeBonusBudget() { /* distiruteBonusBudget method calculates the regular employee's 
		                                  bonus price with the given amount of regular employee, salary and performance score*/

		double salaryPerfMoney = 0;
		double unit = 0;
		double bonusMoney = 0;

		for (int i = 0; i < regularEmployees.size(); i++) {

			salaryPerfMoney += (regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());
		}
		unit = this.bonusBudget / salaryPerfMoney;

		for (int j = 0; j < regularEmployees.size(); j++) {
          
			bonusMoney = unit * regularEmployees.get(j).getSalary() * regularEmployees.get(j).getPerformanceScore();
			regularEmployees.get(j).setBonus( regularEmployees.get(j).getBonus() + bonusMoney );
			
		}

	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		return "Manager [id=" + super.getId() + ", " +  super.getFirstName() + " " + super.getLastName() + "     " +
	                             " # of Employee: " + Employee.getNumberofEmployees() +  "]";
	}

}
