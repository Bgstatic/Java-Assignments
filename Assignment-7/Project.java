

import java.util.Calendar;

public class Project {

	private String projectName;
	private Calendar startDate;
	private boolean state;

	public Project(String pName, Calendar startDate, String state) { // Creating constructors from super class.

		this.setProjectName(pName);
		this.setStartDate(startDate);

	}

	public void setState(String state) { // setState method sets the state by the given state value.

		if (state.equalsIgnoreCase("Open")) {

			setState(true);
		} else if (state.equalsIgnoreCase("Close")) {

			setState(false);
		}

	}

	public String getState() { // getState method gets the state by the given state value.

		if (this.state == true) {

			return "Open";
		} else if (this.state == false) {

			return "Close";
		}

		return "NULL";
	}

	public void close() { // close method closes the state by the given state value.

		if (this.state == true) {

			this.state = false;
		}
	}
    
	//Creating getter and setter methods for all data fields.
	public void setState(boolean state) {

		this.state = state;

	}

	public Calendar getStartDate() {

		return startDate;

	}

	public void setStartDate(Calendar startDate) {

		this.startDate = startDate;

	}

	public String getProjectName() {

		return projectName;

	}

	public void setProjectName(String projectName) {

		this.projectName = projectName;

	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		int Birthday = startDate.get(5);
		int Birthmonth = startDate.get(2) + 1;
		int Birthyear = startDate.get(1);
		return "[Project [projectName=" + projectName + ", startDate=" + Birthday + "/" + Birthmonth + "/" + Birthyear
				+ ", state=" + state + "]";
	}

}
