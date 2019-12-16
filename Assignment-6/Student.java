package HW6;

public class Student {

	private String name;
	private String surname;
	private String major;
	private int ID;
	private int year;
	private RegisterInfo[] RegisterList;

	public Student(String name, String surname, String major, int ID, int year) {

		this.name = name;
		this.surname = surname;
		this.major = major;
		this.ID = ID;
		this.year = year;

	}
    // Adding the students to the given course.
	public void addRegisterInfo(RegisterInfo registerInfo) {

		if (RegisterList == null) {

			RegisterList = new RegisterInfo[1];
			RegisterList[0] = registerInfo;
		} else {

			RegisterInfo[] temp = RegisterList;
			RegisterList = new RegisterInfo[RegisterList.length + 1];

			for (int i = 0; i < temp.length; i++) {

				RegisterList[i] = temp[i];
				RegisterList[RegisterList.length - 1] = registerInfo;

			}

		}
	}
     // Removing the students from the course.
	public boolean removeRegisterInfo(Course course) {

		boolean Find = false;
		for (int i = 0; i < RegisterList.length; i++) {

			if (RegisterList[i].getCourse() == course) {

				RegisterList[i] = null;
				Find = true;

			}

		}

		if (Find) {

			int counter = 0;
			RegisterInfo[] temp = RegisterList;
			RegisterList = new RegisterInfo[RegisterList.length - 1];

			for (int k = 0; k < temp.length; k++) {

				if (temp[k] != null) {

					RegisterList[counter] = temp[k];
					counter++;

				}
			}

		}

		return Find;
	}
   // Printing course list
	public void printCourseList() {

		System.out.println(" Courses that " + this.name + " " + this.surname + " attemps to be register are: ");

		for (int i = 0; i < RegisterList.length; i++) {

			System.out.println(RegisterList[i].getCourse());
		}
	}

	//Calculating the the total credits.
	public int getTotalCredit() {
		int sum = 0;

		for (int i = 0; i < RegisterList.length; i++) {

			sum += RegisterList[i].getCourse().getCredits();
		}
		return sum;

	}
   
	//getter and setter methods.
	public String getName() {

		return name;
	}

	public String getSurName() {

		return surname;
	}

	public String getMajor() {

		return major;
	}

	public int getID() {

		return ID;
	}

	public int getYear() {

		return year;
	}

	public RegisterInfo[] getRegisterList() {

		return RegisterList;
	}

	public void setName(String newName) {

		name = newName;
	}

	public void setSurname(String newSurname) {

		surname = newSurname;
	}

	public void setMajor(String newMajor) {

		major = newMajor;

	}

	public void setID(int newID) {

		ID = newID;
	}

	public void setYear(int newYear) {

		year = newYear;

	}

	public void setRegisterList(RegisterInfo[] newRegisterList) {

		RegisterList = newRegisterList;

	}
}
