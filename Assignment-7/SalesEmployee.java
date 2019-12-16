

import java.util.*;

public class SalesEmployee extends RegularEmployee {

	private ArrayList<Product> sales;
	public static int numberOfSalesEmployess;

	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate,
			String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department,
			double pScore, ArrayList<Product> s) throws Exception { // Creating constructors from super class.

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore);
		this.sales = s;
		SalesEmployee.setNumberOfSalesEmployess(SalesEmployee.getNumberOfSalesEmployess() + 1);
	}

	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) throws Exception { // Creating overloaded constructors from super class.

		super.setId(re.getId());
		super.setFirstName(re.getFirstName());
		super.setLastName(re.getLastName());
		super.setGender(re.getGender());
		super.setBirthdate(re.getBirthdate());
		super.setMaritalStatus(re.getMaritalStatus());
		super.setHasDriverLicense(re.getHasDriverLicense());
		super.setSalary(re.getSalary());
		super.setHireDate(re.getHireDate());
		super.setDepartment(re.getDepartment());
		this.sales = s;
		SalesEmployee.setNumberOfSalesEmployess(SalesEmployee.getNumberOfSalesEmployess() + 1);

	}
    
	public SalesEmployee() {
		// TODO Auto-generated constructor stub
	}

	public boolean addSale(Product s) { //addSale method adds the given products to the given sales array list.

		return sales.add(s);

	}

	public boolean removeSale(Product s) { // removeSale method removes the the given products from the given sales array list.

		return sales.remove(s);
	}
    
	//Creating getter and setter methods for all data fields.
	public ArrayList<Product> getSales() {

		return sales;
	}

	public void setSales(ArrayList<Product> sales) {

		this.sales = sales;

	}

	public static int getNumberOfSalesEmployess() {

		return numberOfSalesEmployess;

	}

	public static void setNumberOfSalesEmployess(int numberOfSalesEmployess) {

		SalesEmployee.numberOfSalesEmployess = numberOfSalesEmployess;

	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		return "SalesEmployee [sales=" + sales + "]";
	}

}
