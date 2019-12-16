

import java.util.*;

public class Department { // Department Class.

	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) { // Creating constructors from super class.

		this.setDepartmentId(departmentId);
		this.setDepartmentName(departmentName);

	}
      
	// Creating getter and setter methods for all data fields.
	public int getDepartmentId() {

		return departmentId;

	}

	public void setDepartmentId(int departmentId) {

		this.departmentId = departmentId;

	}

	public String getDepartmentName() {

		return departmentName;

	}

	public void setDepartmentName(String departmentName) {

		this.departmentName = departmentName;

	}

	@Override
	// Creating toString method for printing the data fields.
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
