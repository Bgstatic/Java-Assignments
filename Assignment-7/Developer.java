

import java.util.*;

public class Developer extends RegularEmployee {

	private ArrayList<Project> projects;
	public static int numberOfDevelopers;

	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus,
			String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore,
			ArrayList<Project> p) throws Exception { // Creating constructors from super class.

		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department,
				pScore);
		this.projects = p;
		Developer.setNumberOfDevelopers(Developer.getNumberOfDevelopers() + 1); //Increasing the number of developers by one.
	}

	public Developer(RegularEmployee re, ArrayList<Project> p) throws Exception { // Creating overloaded constructors from super class.

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
		this.projects = p;
		Developer.setNumberOfDevelopers(Developer.getNumberOfDevelopers() + 1); //Increasing the number of developers by one.
	}

	public boolean addProject(Project s) { //AddProject method adds the given project to the projects array list which is a data field in type of Array list. 

		return this.projects.add(s);

	}

	public boolean removeProject(Product s) {// removeProject method removes the given product from the project array list.

		return this.projects.remove(s);
	}
      
	// Creating getter and setter methods for all data fields.
	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		Developer.numberOfDevelopers = numberOfDevelopers;
	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		return "Developer [projects=" + projects + "]";
	}

}
