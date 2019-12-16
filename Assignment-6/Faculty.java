

public class Faculty {

	private int ID;
	private String name;
	private String surname;
	private String departmentName;
	private AssignInfo[] assignInfoList;
	

	public Faculty(int ID, String name, String surname, String departmentName) {

		this.ID = ID;
		this.name = name;
		this.surname = surname;
		this.departmentName = departmentName;
	}
    
	public boolean withdrawAssignInfo(Course course) {

		boolean Find = false;
		for (int i = 0; i < assignInfoList.length; i++) {

			if (assignInfoList[i].getCourse() == course) {

				assignInfoList[i] = null;
				Find = true;

			}

		}

		if (Find) {

			int counter = 0;
			AssignInfo[] temp = assignInfoList;
			assignInfoList = new AssignInfo[assignInfoList.length - 1];

			for (int k = 0; k < temp.length; k++) {

				if (temp[k] != null) {

					assignInfoList[counter] = temp[k];
					counter++;

				}
			}
		}
		return Find;
	}
     // Assign the instructor to the given course.
	public void addAssignInfo(AssignInfo assignInfo) {

		if (assignInfoList == null) {

			assignInfoList = new AssignInfo[1];
			assignInfoList[0] = assignInfo;
		} else {

			AssignInfo[] temp = assignInfoList;
			assignInfoList = new AssignInfo[assignInfoList.length + 1];

			for (int i = 0; i < temp.length; i++) {

				assignInfoList[i] = temp[i];
				assignInfoList[assignInfoList.length - 1] = assignInfo;
			}
		}

	}
    // Printing the course list.
	public void printCourseList() {

		for (int i = 0; i < assignInfoList.length; i++) {

			System.out.println(assignInfoList[i].getCourse());

		}
	}

	public int getID() {

		return ID;
	}

	public String getName() {

		return name;
	}

	public String getSurname() {

		return surname;
	}

	public String getDepartmentName() {

		return departmentName;
	}

	public AssignInfo[] getAssignInfoList() {

		return assignInfoList;
	}

	public void setID(int newID) {

		ID = newID;
	}

	public void setName(String newName) {

		name = newName;
	}

	public void setSurname(String newSurname) {

		surname = newSurname;
	}

	public void setDepartmentName(String newDepartmentName) {

		departmentName = newDepartmentName;
	}

	public void setAssignInfoList(AssignInfo[] newAssignInfoList) {

		assignInfoList = newAssignInfoList;
	}

}
