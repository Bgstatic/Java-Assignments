

import java.util.Calendar;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private Calendar birthdate;
	private byte maritalStatus;
	private boolean hasDriverLicense;

	public Person(int id, String firstName, String lastName, String gender, Calendar birthdate, String marialStatus,
			String hasDriverLicense) throws Exception {  // Creating constructors from super class.

		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setBirthdate(birthdate);
		this.setGender(gender);
		this.setBirthdate(birthdate);
		this.setMaritalStatus(marialStatus);
		this.setHasDriverLicense(hasDriverLicense);

	}

	public Person() { // No arg constructor

	}

	
	public void setGender(String gender) throws Exception { // setGender method sets the gender to the 1 or 2 by the given string value.

		if (gender.equalsIgnoreCase("Woman")) {

			this.gender = 1;

		} else if (gender.equalsIgnoreCase("Man")) {

			this.gender = 2;
		}
		
		else {
			
			throw new Exception("Invalid type of gender");
		}

	}

	public String getGender() throws Exception { // getGender method gets the gender woman or man to by the given byte value.

		if (this.gender == 1) {

			return "Woman";

		} else if (this.gender == 2) {

			return "Man";
		} else {

			throw new Exception("Invalid input");
		}

	}

	public void setMaritalStatus(String status) throws Exception { // setMaritalStatus method sets the maritalStatus to the 1 or 2 by the given string value.

		if (status.equalsIgnoreCase("Single")) {

			this.maritalStatus = 1;
			
		} else if (status.equalsIgnoreCase("Married")) {

			this.maritalStatus = 2;
		}
		else {
			
			throw new Exception("Invalid type of status");
		}

	}

	public byte setMaritalStatus(byte marialStatus) { 

		return this.maritalStatus = marialStatus;
	}

	public String getMaritalStatus() throws Exception { // getMarialStatus method gets the martial status single or married by the given byte value.

		if (this.maritalStatus ==  1) {

			return "Single";

		} else if (this.maritalStatus == 2) {

			return "Married";
			
		} else {

			throw new Exception("Invalid input");
		}
	}

	public void setHasDriverLicense(String info) throws Exception {

		if (info.equalsIgnoreCase("Yes")) {

			setHasDriverLicense(true);

		} else if (info.equalsIgnoreCase("No")) {

			setHasDriverLicense(false);

		}
		else {
			
			throw new Exception("Invalid type of info");
		}
	}

	public boolean setHasDriverLicense(boolean hasDriverLicense) {

		return this.hasDriverLicense = hasDriverLicense;
	}

	public String getHasDriverLicense() throws Exception {

		if (this.hasDriverLicense == true) {

			return "Yes";

		} else if (this.hasDriverLicense == false) {

			return "No";
		} else {

			throw new Exception("Invalid input");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		
		int Birthday = birthdate.get(5) ; // Getting the day from the calendar.
		int Birthmonth = birthdate.get(2) + 1; // Getting the month from the calendar.
		int Birthyear = birthdate.get(1); // Getting the year from the calendar.
		
		try {
			return " [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + this.getGender()
					+ "]";
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Invalid input";
	}
	

}
