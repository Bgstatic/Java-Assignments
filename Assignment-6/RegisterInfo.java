

public class RegisterInfo {

	private Course course;
	private String result;
	private int resultID;
	private String registerMessage;
   
	
	//getter and setter methods
	public Course getCourse() {

		return course;

	}

	public String getResult() {

		return result;

	}

	public int getResultID() {

		return resultID;
	}

	public String getRegisterMessage() {

		return registerMessage;

	}

	public void setCourse(Course newCourse) {

		course = newCourse;

	}

	public void setResult(String newResult) {

		result = newResult;
	}

	public void setResultID(int newResultID) {

		resultID = newResultID;
	}

	public void setRegisterMessage(String newRegisterMessage) {

		registerMessage = newRegisterMessage;
	}
}
